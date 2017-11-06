package com.imooc.girl.core.web.httprpc;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by hmh on 2017/8/28.
 */
public class JsonUtil {

    public static JsonResult jsonToObject(String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonResult result = mapper.readValue(jsonString, JsonResult.class);
        return result;
    }

    public static String getJson(Object jsonObject) throws IOException {
        String jsonString = null;
        ObjectMapper mapper = new ObjectMapper();
        StringWriter sw = new StringWriter();
        JsonGenerator generator = new JsonFactory().createJsonGenerator(sw);

        mapper.writeValue(generator, jsonObject);
        generator.close();
        jsonString = sw.toString();
        return jsonString;
    }


}
