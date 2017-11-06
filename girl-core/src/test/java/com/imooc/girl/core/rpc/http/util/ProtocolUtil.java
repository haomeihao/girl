package com.imooc.girl.core.rpc.http.util;

import com.imooc.girl.core.rpc.http.content.Request;
import com.imooc.girl.core.rpc.http.content.Response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * HTTP 协议栈
 * 0、服务器在指定端口监听客户端请求
 * 1、客户端发送请求
 * 2、服务器解析请求
 * 3、服务器返回响应
 * 4、客户端读取响应
 * Created by hmh on 2017/8/25.
 */
public class ProtocolUtil {

    /**
     * 客户端 发送 请求
     *
     * @param output
     * @param request
     * @throws InterruptedException
     */
    public static void writeRequest(OutputStream output, Request request) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis() + "-->writeRequest...");
    }

    /**
     * 服务器 解析 请求
     *
     * @param input
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static Request readRequest(InputStream input) throws IOException, InterruptedException {
        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis() + "-->readRequest...");
        // 读取编码
//        byte[] encodeByte = new byte[1];
//        input.read(encodeByte);
//        byte encode = encodeByte[0];
//
//        // 读取命令长度
//        byte[] commandLengthBytes = new byte[4];
//        input.read(commandLengthBytes);
//        int commandLength = ByteUtil.byte2Int(commandLengthBytes);
//
//        // 读取命令
//        byte[] commandBytes = new byte[commandLength];
//        input.read(commandBytes);
//        String command = "";
//
//        command = new String(commandBytes, "UTF8");

        // 组装请求返回
        Request request = new Request();
//        request.setEncode(encode);
//        request.setCommand(command);
//        request.setCommandLength(commandLength);

        return request;
    }


    /**
     * 服务器 返回 响应
     *
     * @param output
     * @param response
     * @throws IOException
     * @throws InterruptedException
     */
    public static void writeResponse(OutputStream output, Response response) throws IOException, InterruptedException {
        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis() + "-->writeResponse...");
        // 将response响应返回给客户端
        output.write(response.getEncode());
        output.write(response.getResponseLength());

        output.write(response.getResponse().getBytes("UTF-8"));
        output.flush();
    }

    /**
     * 客户端 读取 响应
     *
     * @param input
     * @return
     * @throws InterruptedException
     */
    public static Response readResponse(InputStream input) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis() + "-->readResponse...");

        Response response = new Response();
        return response;
    }
}

