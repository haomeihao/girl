package com.imooc.girl.core.rpc.http.content;

/**
 * Created by hmh on 2017/8/25.
 */
public class Response {

    private byte encode;
    private String response;
    private int responseLength;

    public byte getEncode() {
        return encode;
    }

    public void setEncode(byte encode) {
        this.encode = encode;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getResponseLength() {
        return responseLength;
    }

    public void setResponseLength(int responseLength) {
        this.responseLength = responseLength;
    }
}
