package test.zhangdy.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.util.EntityUtils;

import com.ibm.json.java.JSONObject;

public class HttpClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HttpClientTest httpClient = new HttpClientTest();
//		httpClient.testHttpRequest();
//		httpClient.testHttpResponse();
//		httpClient.testResponseHeader3();
//		httpClient.testHttpEntity();
		httpClient.testJSONResponse();
	}
	
	void testHttpRequest(){
		try {
			URI uri = new URIBuilder()
			.setScheme("http")
			.setHost("www.google.com")
			.setPath("/search")
			.setParameter("q", "httpclient")
			.setParameter("btnG", "Google Search")
			.setParameter("aq", "f")
			.setParameter("oq", "")
			.build();
			HttpGet httpget = new HttpGet(uri);
		    System.out.println(httpget.getURI());
		    /*
		     * result:
		     *  http://www.google.com/search?q=httpclient&btnG=Google+Search&aq=f&oq=
		     */
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void testHttpResponse(){
		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");

		System.out.println(response.getProtocolVersion());
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getStatusLine().getReasonPhrase());
		System.out.println(response.getStatusLine().toString());
		
		/*
		 * result:
		 * 	HTTP/1.1
			200
			OK
			HTTP/1.1 200 OK
		 */
	}
	
	//一个 Http 消息可以包含一系列的消息头，用来对 http 消息进行描述，比如消息长度，消息类型等等。
	//HttpClient 提供了 API 来获取、添加、修改、遍历消息头。
	void testResponseHeader1(){
		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
		response.addHeader("Set-Cookie", "c1=a; path=/; domain=yeetrack.com");
		response.addHeader("Set-Cookie", "c2=b; path=\"/\", c3=c; domain=\"yeetrack.com\"");
		Header h1 = response.getFirstHeader("Set-Cookie");
		System.out.println(h1);
		Header h2 = response.getLastHeader("Set-Cookie");
		System.out.println(h2);
		Header[] hs = response.getHeaders("Set-Cookie");
		System.out.println(hs.length);
	}
	
	//最有效的获取指定类型的消息头的方法还是使用 HeaderIterator 接口。
	void testResponseHeader2(){
		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
		response.addHeader("Set-Cookie", "c1=a; path=/; domain=yeetrack.com");
		response.addHeader("Set-Cookie", "c2=b; path=\"/\", c3=c; domain=\"yeetrack.com\""); 
		HeaderIterator it = response.headerIterator("Set-Cookie"); 
		while (it.hasNext()) 
		{ System.out.println(it.next()); } 
	}
	
	//HeaderIterator 也提供非常便捷的方式，将 Http 消息解析成单独的消息头元素。
	void testResponseHeader3(){
		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
		response.addHeader("Set-Cookie", "c1=a; path=/; domain=yeetrack.com");
		response.addHeader("Set-Cookie", "c2=b; path=\"/\", c3=c; domain=\"yeetrack.com\"");

		HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator("Set-Cookie"));

		while (it.hasNext()) {
			HeaderElement elem = it.nextElement(); 
			System.out.println(elem.getName() + " = " + elem.getValue());
			NameValuePair[] params = elem.getParameters();
			for (int i = 0; i < params.length; i++) {
				System.out.println(" " + params[i]);
			}
		}
		/*
		 * result:
		 *  c1 = a
			path=/
			domain=yeetrack.com
			c2 = b
			path=/
			c3 = c
			domain=yeetrack.com
		 */
	}
	
	void testHttpEntity(){
		StringEntity myEntity = new StringEntity("important message", ContentType.create("text/plain", "UTF-8"));
		System.out.println(myEntity.getContentType());
		System.out.println(myEntity.getContentLength());
		try {
			System.out.println(EntityUtils.toString(myEntity));
			System.out.println(EntityUtils.toByteArray(myEntity).length);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void testJSONResponse(){
		
		String url = "http://engagests.ciopaas1.innovate.ibm.com/isc/sts/engage/webdata/ER-WBS-IN";
		
		CloseableHttpClient httpClient =  HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		
		httpPost.setHeader("Content-Type", "application/json");
		JSONRequestEntity jsonEntity = new JSONRequestEntity();
		System.out.println("jsonEntity.toString() ==" +jsonEntity.toString());
		try {
			HttpEntity requestEntity = new StringEntity(jsonEntity.toString());
			httpPost.setEntity(requestEntity);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity responseEntity =  httpResponse.getEntity();
			String content = EntityUtils.toString(responseEntity);
			JSONObject jsonObj = JSONObject.parse(content);
			
			System.out.println(content);
			System.out.println(jsonObj.get("rqnbr"));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void testMultipartRequest(){
		
		String url = "https://engagests.ciopaas1.innovate.ibm.com/isc/sts/engage/upload";
		
		CloseableHttpClient httpClient =  HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);

		MultipartEntityBuilder mutiEntityBuilder = MultipartEntityBuilder.create();

		String idRef = "SWGUS15061801407-1";
		String orderXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><order><TransactionReferenceKey>      U01700335_P    </TransactionReferenceKey></order>";
		mutiEntityBuilder.addTextBody("idRef", idRef);

//		File file = new File("C:/_zhangdy/_Project/ESW/PTR10044-EngageSTS/order-xml-format.xml");
//		mutiEntityBuilder.addPart("file", new FileBody(file));
		
		mutiEntityBuilder.addPart("file", new ByteArrayBody(orderXml.getBytes(),ContentType.create("application/xml", "UTF-8"),"ShopzOrder.xml"));

		httpPost.setEntity(mutiEntityBuilder.build());

		HttpResponse httpResponse;
		try {
			httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity =  httpResponse.getEntity();

			String content = EntityUtils.toString(httpEntity);
			System.out.println(content);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
