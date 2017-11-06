package com.imooc.girl.core.rpc.http;

import com.imooc.girl.core.rpc.http.content.Request;
import com.imooc.girl.core.rpc.http.content.Response;
import com.imooc.girl.core.rpc.http.util.ProtocolUtil;
import com.sun.xml.internal.fastinfoset.Encoder;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hmh on 2017/8/25.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("Client startup...");

        Request request = new Request();

        request.setCommand("HELLO");
        request.setCommandLength(request.getCommand().length());
        request.setEncode(Encoder.UTF_8.getBytes()[0]);

        Socket client = new Socket("127.0.0.1", 4567);

        OutputStream output = client.getOutputStream();

        // 发送请求
        ProtocolUtil.writeRequest(output, request);

        // 读取相应数据
        InputStream input = client.getInputStream();
        Response response = ProtocolUtil.readResponse(input);

        System.out.println(client.isClosed());
        client.close();
        Thread.sleep(1000);
        System.out.println(client.isClosed());
    }
}
