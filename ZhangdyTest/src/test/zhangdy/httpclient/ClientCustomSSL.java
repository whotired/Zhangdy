package test.zhangdy.httpclient;

/**
 * Created with IntelliJ IDEA.
 * User: victor
 * Date: 13-10-11
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
 import java.io.File;
 import java.io.FileInputStream;
 import java.security.KeyStore;

 import javax.net.ssl.SSLContext;

 import org.apache.http.HttpEntity;
 import org.apache.http.client.methods.CloseableHttpResponse;
 import org.apache.http.client.methods.HttpGet;
 import org.apache.http.conn.ssl.SSLContexts;
 import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
 import org.apache.http.impl.client.CloseableHttpClient;
 import org.apache.http.impl.client.HttpClients;
 import org.apache.http.util.EntityUtils;
/**
 * 代码展示了如果使用ssl context创建安全socket连接
 */
 public class ClientCustomSSL {

     public final static void main(String[] args) throws Exception {
         KeyStore trustStore  = KeyStore.getInstance(KeyStore.getDefaultType());
         //加载证书文件
         FileInputStream instream = new FileInputStream(new File("C:/_zhangdy/MyDocument/_IMPORTANT/Apache/HttpClient/HttpClient教程/my.store"));
         try {
             trustStore.load(instream, "changeit".toCharArray());
         } finally {
             instream.close();
         }
         SSLContext sslcontext = SSLContexts.custom()
                 .loadTrustMaterial(trustStore)
                 .build();

         SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,
                 SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
         CloseableHttpClient httpclient = HttpClients.custom()
                 .setSSLSocketFactory(sslsf)
                 .build();
         try
         {
             //访问支付宝
             HttpGet httpget = new HttpGet("https://www.alipay.com/");

             System.out.println("executing request" + httpget.getRequestLine());

             CloseableHttpResponse response = httpclient.execute(httpget);
             try {
                 HttpEntity entity = response.getEntity();

                 System.out.println("----------------------------------------");
                 System.out.println(response.getStatusLine());
                 if (entity != null) {
                     System.out.println(EntityUtils.toString(entity));
                 }
             } finally {
                 response.close();
             }
         } finally {
             httpclient.close();
         }
     }

 }
