package com.imooc.girl.core.rpc.http;

import com.imooc.girl.core.rpc.http.content.Request;
import com.imooc.girl.core.rpc.http.content.Response;
import com.imooc.girl.core.rpc.http.util.ProtocolUtil;
import com.sun.xml.internal.fastinfoset.Encoder;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by hmh on 2017/8/25.
 */
public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("Server startup...");

        ServerSocket server = new ServerSocket(4567);

        while (true) {
            Socket client = server.accept();

            // 读取请求数据
            InputStream input = client.getInputStream();
            Request request = ProtocolUtil.readRequest(input);

            OutputStream output = client.getOutputStream();
            // 组装响应
            Response response = new Response();
            response.setEncode(Encoder.UTF_8.getBytes()[0]);
            if ("HELLO".equals(request.getCommand()))
                response.setResponse("hello!");
            else
                response.setResponse("bye bye!");
            response.setResponseLength(response.getResponse().length());

            ProtocolUtil.writeResponse(output, response);

            Thread.sleep(2000);
            System.out.println(client.isClosed());
        }

    }
}
