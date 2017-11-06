package com.imooc.girl.core.base;

import java.io.*;

/**
 * Created by hmh on 2017/8/25.
 */
public class SerializerTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("zhangsan", 23);

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        ObjectOutputStream out = new ObjectOutputStream(os);

        out.writeObject(person);

        byte[] personByte = os.toByteArray();

        System.out.println(personByte);

        System.out.println("---------");

        ByteArrayInputStream is = new ByteArrayInputStream(personByte);

        ObjectInputStream in = new ObjectInputStream(is);

        Person object = (Person) in.readObject();

        System.out.println(object);
    }
}
