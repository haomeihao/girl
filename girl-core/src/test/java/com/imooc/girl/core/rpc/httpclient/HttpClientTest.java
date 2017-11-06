package com.imooc.girl.core.rpc.httpclient;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by hmh on 2017/8/28.
 */
public class HttpClientTest {

    private static String url = "https://www.sogou.com";

    public static void main(String[] args) throws IOException {

        // 组装请求
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);

        // 接收响应
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        byte[] bytes = EntityUtils.toByteArray(entity);
        String result = new String(bytes, "utf-8");

        System.out.println(result);
    }
}
