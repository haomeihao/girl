package com.imooc.girl.core.rpc.httpclient;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

/**
 * Created by hmh on 2017/8/28.
 */
public class JSONTest {

    public static void main(String[] args) throws IOException {
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(18);
        person.setBirth(new Date());
        person.setAddress("hangzhou,china");

        // JSON对象序列化
        String personJson = null;
        ObjectMapper mapper = new ObjectMapper();
        StringWriter sw = new StringWriter();
        JsonGenerator generator = new JsonFactory().createJsonGenerator(sw);

        mapper.writeValue(generator, person);
        generator.close();
        personJson = sw.toString();

        System.out.println(person);
        System.out.println(personJson);

        // JSON对象反序列化
        ObjectMapper mapper1 = new ObjectMapper();
        Person zhangsan = mapper1.readValue(personJson, Person.class);
        System.out.println(zhangsan);
    }
}
