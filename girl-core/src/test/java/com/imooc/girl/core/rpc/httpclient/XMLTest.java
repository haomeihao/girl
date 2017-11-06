package com.imooc.girl.core.rpc.httpclient;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.Date;

/**
 * Created by hmh on 2017/8/28.
 */
public class XMLTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(18);
        person.setBirth(new Date());
        person.setAddress("hangzhou,china");

        // 将person对象序列化为XML
        XStream xStream = new XStream(new DomDriver());
        // 设置person类的别名
        xStream.alias("person", Person.class);
        String personXML = xStream.toXML(person);

        System.out.println(personXML);

        // 将XML反序列化为person对象
        Person zhangsan = (Person) xStream.fromXML(personXML);
        System.out.println(zhangsan);
    }
}
