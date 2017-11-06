package com.imooc.girl.core.rpc.http.util;

/**
 * Created by hmh on 2017/8/25.
 */
public class ByteUtil {
    public static int byte2Int(byte[] bytes) {
        int num = bytes[3] & 0xFF;
        num |= ((bytes[2] << 8) & 0xFF00);
        num |= ((bytes[1] << 16) & 0xFF0000);
        num |= ((bytes[0] << 24) & 0xFF000000);
        return num;
    }
}
