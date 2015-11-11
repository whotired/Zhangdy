package test.zhangdy.security;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class Simple_SSLSocket {
	// 定义要连接的服务器名和端口号
	private static final int DEFAULT_PORT = 54321;
	private static final String DEFAULT_HOST = "localhost";
	// 相关的 jks 文件及其密码定义
	private final static String TRUST_STORE = "D:/test_client_trust.jks";
	private final static String TRUST_STORE_PASSWORD = "Testpassw0rd";

	public static void main(String args[]) {
		SSLSocket socket = null;
//		// 使用默认的方式获取工厂实例
//		SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();
		try {
			//清单4
			
			// 载入 jks 文件
			FileInputStream f_trustStore = new FileInputStream(TRUST_STORE);
			KeyStore ks = KeyStore.getInstance("jks");
			ks.load(f_trustStore, TRUST_STORE_PASSWORD.toCharArray());
			f_trustStore.close();

			// 创建并初始化信任库工厂
//			String alg = TrustManagerFactory.getDefaultAlgorithm();
//			TrustManagerFactory tmFact = TrustManagerFactory.getInstance(alg);
//			tmFact.init(ks);
//
//			TrustManager[] tms = tmFact.getTrustManagers();
			// 使用自定义的 MyTrustManager 产生信任库
			TrustManager[] tms=new TrustManager[]{new MyTrustManager()}; 

			// 创建并初始化 SSLContext 实例
			SSLContext context = SSLContext.getInstance("SSL");
			context.init(null, tms, null);
			SSLSocketFactory sf = context.getSocketFactory();
			//end 清单4
			
			// 连接服务端的端口，完成握手过程
			socket = (SSLSocket) sf.createSocket(DEFAULT_HOST, DEFAULT_PORT);
			socket.startHandshake();
			System.out.println("Connected to " + DEFAULT_HOST + ":"
					+ DEFAULT_PORT + " !");
			// 从控制台输入要发送给服务端的文字
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));
			Writer writer = new OutputStreamWriter(socket.getOutputStream());
			// 可以反复向服务端发送消息
			boolean done = false;
			while (!done) {
				System.out.print("Send Message: ");
				String line = reader.readLine();
				if (line != null) {
					writer.write(line + "\n");
					writer.flush();
				} else {
					done = true;
				}
			}
			socket.close();
		} catch (Exception e) {
			System.out.println("Connection failed: " + e);
			try {
				socket.close();
			} catch (IOException ioe) {
			}
			socket = null;
		}
	}

	
}
class MyTrustManager implements X509TrustManager {
	// 相关的 jks 文件及其密码定义
	private final static String TRUST_STORE = "D:/test_client_trust.jks";
	private final static String TRUST_STORE_PASSWORD = "Testpassw0rd";
	X509TrustManager xtm;

	public MyTrustManager() throws Exception {
		// 载入 jks 文件
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(new FileInputStream(TRUST_STORE),
				TRUST_STORE_PASSWORD.toCharArray());
		TrustManagerFactory tmf = TrustManagerFactory.getInstance(
				"SunX509", "SunJSSE");
		tmf.init(ks);
		TrustManager[] tms = tmf.getTrustManagers();
		// 筛选出 X509 格式的信任证书
		for (int i = 0; i < tms.length; i++) {
			if (tms[i] instanceof X509TrustManager) {
				xtm = (X509TrustManager) tms[i];
				return;
			}
		}
	}

	// 服务端检验客户端证书的接口
	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
	}

	// 客户端检验服务端证书的接口
	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		try {
			xtm.checkServerTrusted(chain, authType);
		} catch (CertificateException excep) {
			System.out.println(excep.getMessage());
			throw excep;
		}
	}

	// 获取可接受的发行者
	public X509Certificate[] getAcceptedIssuers() {
		// return xtm.getAcceptedIssuers();
		return null;
	}
}