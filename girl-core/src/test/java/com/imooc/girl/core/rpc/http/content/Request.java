package com.imooc.girl.core.rpc.http.content;

/**
 * Created by hmh on 2017/8/25.
 */
public class Request {

    private byte encode; //协议编码
    private String command; //命令
    private int commandLength; //命令长度

    public byte getEncode() {
        return encode;
    }

    public void setEncode(byte encode) {
        this.encode = encode;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getCommandLength() {
        return commandLength;
    }

    public void setCommandLength(int commandLength) {
        this.commandLength = commandLength;
    }
}
