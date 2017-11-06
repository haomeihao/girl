package com.imooc.girl.core.rpc.httprpc;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hmh on 2017/8/28.
 */
@WebServlet(urlPatterns = "/consumer.do")
public class ServiceConsumer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 参数
        String service = "com.http.sayhello";
        String format = "json";
        String arg1 = "hello";
        String url = "http://127.0.0.1:8081/provider.do?"
                + "service=" + service + "&format=" + format + "&arg1=" + arg1;

        System.out.println(service+"\t"+format+"\t"+arg1+"\t"+url);

        // 组装请求
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);

        // 接收响应
        HttpResponse response = httpClient.execute(httpGet);

        HttpEntity entity = response.getEntity();
        byte[] bytes = EntityUtils.toByteArray(entity);
        String jsonResult = new String(bytes, "utf-8");

        JsonResult result = JsonUtil.jsonToObject(jsonResult);

        resp.getWriter().write(result.getResult().toString());
    }
}
