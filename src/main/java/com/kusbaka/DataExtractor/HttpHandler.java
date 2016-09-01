package com.kusbaka.DataExtractor;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpHandler {


	
	public static String getResponse(String url){
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		String responseBody = null;
		try{
			HttpGet httpget = new HttpGet(url.replace(" ", "%20"));
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
	         responseBody = httpClient.execute(httpget, responseHandler);
		}catch(Exception e){
			e.printStackTrace();
		}

		return responseBody;
	}


}
