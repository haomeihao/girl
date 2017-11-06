package com.imooc.girl.core.rpc.tcp;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by hmh on 2017/8/25.
 */
public class Consumer {
    public static void main(String[] args) {
        System.out.println("服务消费者已启动...");
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入任意字符串:");
            String hello = sc.nextLine();

            new Consumer().sayHello(hello);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sayHello(String hello) throws Exception {
        String name = SayHelloService.class.getName();

        Method method = SayHelloService.class.getMethod("sayHello", String.class);

        Object[] args = {hello};

        System.out.println("输入参数：" + Arrays.toString(args));

        Socket socket = new Socket("127.0.0.1", 1234);

        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        output.writeUTF(name);
        output.writeUTF(method.getName());
        output.writeObject(method.getParameterTypes());
        output.writeObject(args);


        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        Object result = input.readObject();

        System.out.println("请求结果：" + result.toString());
    }
}
