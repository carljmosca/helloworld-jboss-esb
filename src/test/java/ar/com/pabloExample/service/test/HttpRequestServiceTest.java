package ar.com.pabloExample.service.test;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.junit.Test;

public class HttpRequestServiceTest {
	
	private static Logger logger = Logger.getLogger(HttpRequestServiceTest.class);
	
	@Test
	public void httpRequestServiceTest() throws HttpException, IOException {
		
		HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://localhost:8080/helloworld-jboss-esb/http/helloWorldCategory/helloWorldService");
        post.setQueryString("?name=pablito");
        client.executeMethod(post);
        
        String result = post.getResponseBodyAsString();
        post.releaseConnection();

        logger.info("Service returned: " + result);
	}

}