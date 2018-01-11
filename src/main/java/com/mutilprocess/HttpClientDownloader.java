package com.mutilprocess;

import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;


public class HttpClientDownloader {
	
	public HttpClientDownloader() {
	}
	
	public RequestBuilder getRequestBuilder() {
		String method = "";
		RequestBuilder requestBuilder = null;
		if (method == null || method.equalsIgnoreCase("get")) {
			requestBuilder = RequestBuilder.get();
		} else if (method.equalsIgnoreCase("post")) {
			requestBuilder = RequestBuilder.post();
			NameValuePair[] nameValuePair = new NameValuePair[6];
			requestBuilder.addParameters(nameValuePair);
		} else if (method.equalsIgnoreCase("head")) {
			requestBuilder = RequestBuilder.head();
		}
		requestBuilder.setUri("");
		return requestBuilder;
	}

	public HttpUriRequest getHttpUriRequest() {
		RequestBuilder requestBuilder = getRequestBuilder();
		requestBuilder.addHeader("", "");
		Builder configBuilder = RequestConfig.custom().setConnectTimeout(1000).setSocketTimeout(1000).setConnectionRequestTimeout(1000);
		HttpHost hostProxy = new HttpHost("",0); 
		configBuilder.setProxy(hostProxy);
		requestBuilder.setConfig(configBuilder.build());
		return requestBuilder.build();
	}
	public HttpClientBuilder getHttpClientBuilder() {
		 HttpClientBuilder httpClientBuilder =HttpClients.custom();
		 Registry<ConnectionSocketFactory> registerBuilder = RegistryBuilder.<ConnectionSocketFactory>create()
				                           .register("http",null)
				                           .register("https",null)
				                            .build();
		 PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(registerBuilder);
		 httpClientBuilder.setConnectionManager(manager);
		 return httpClientBuilder;
	}
	
}
