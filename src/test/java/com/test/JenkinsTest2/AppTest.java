package com.test.JenkinsTest2;

import static org.junit.Assert.assertEquals;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.junit.Test;

public class AppTest {

	@Test
	public void testApiDataMatch() throws Exception {
		String apiUrl1 = "https://dummyjson.com/products/1";
		String apiUrl2 = "https://dummyjson.com/products/1";

		String dataFromApi1 = getDataFromApi(apiUrl1);
		String dataFromApi2 = getDataFromApi(apiUrl2);

		assertEquals("API data mismatch", dataFromApi1, dataFromApi2);
	}

	private String getDataFromApi(String apiUrl) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(apiUrl);
		CloseableHttpResponse response = httpClient.execute(httpGet);

		String responseData = EntityUtils.toString(response.getEntity());
		httpClient.close();

		return responseData;
	}
}
