package com.kusbaka.DataExtractor;

import org.junit.*;
import static org.junit.Assert.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;


public class HttpHandlerTest  {

	HttpClient httpClient;
	 ResponseHandler<String> responseHandler;
	@Before
	public void setUp() {

		 httpClient = HttpClientBuilder.create().build();
		 responseHandler = new BasicResponseHandler();
	}
@Test
	public void testgetResponse()  {
		try {
			String url = "http://omdbapi.com/?t=Indiana Jones&r=json&y=1989";
			HttpGet httpget = new HttpGet(url.replace(" ", "%20"));
			String responseBody = httpClient.execute(httpget, responseHandler);
			if(responseBody!=null){

				assert(true);
			}

		}catch (Exception e) {

			fail();
		}

	}



}
