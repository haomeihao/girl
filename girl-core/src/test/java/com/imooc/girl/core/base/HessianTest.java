package com.imooc.girl.core.base;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.*;

/**
 * Created by hmh on 2017/8/25.
 */
public class HessianTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person zhangsan = new Person("zhangsan", 23);

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        // Hessian序列化输出
        HessianOutput ho = new HessianOutput(os);
        ho.writeObject(zhangsan);

        byte[] zhangsanByte = os.toByteArray();

        System.out.println(zhangsanByte);

        System.out.println("---------");

        ByteArrayInputStream is = new ByteArrayInputStream(zhangsanByte);

        // Hessian反序列化读取对象
        HessianInput hi = new HessianInput(is);
        Person person = (Person) hi.readObject();

        System.out.println(person);
    }
}
