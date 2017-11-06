package com.imooc.girl.core.rpc.tcp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by hmh on 2017/8/25.
 */
public class Provider {
    public static void main(String[] args) {
        System.out.println("服务生产者已启动...");
        try {
            HashMap<String, Object> services = new HashMap();

            String serviceInterfaceName = SayHelloService.class.getName();
            SayHelloService service = new SayHelloServiceImpl();
            services.put(serviceInterfaceName, service);

            new Provider().sayHello(services);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sayHello(HashMap services) throws Exception {
        ServerSocket server = new ServerSocket(1234);

        while (true) {
            Socket socket = server.accept();

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            String interfaceName = input.readUTF();
            String methodName = input.readUTF();
            Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
            Object[] args = (Object[]) input.readObject();

            System.out.println("传输参数：" + Arrays.toString(args));

            Class serviceInterfaceClass = Class.forName(interfaceName);
            Object service = services.get(interfaceName);
            Method method = serviceInterfaceClass.getMethod(methodName, parameterTypes);

            Object result = method.invoke(service, args);

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(result);

            System.out.println("返回结果：" + result.toString());
        }

    }

}
