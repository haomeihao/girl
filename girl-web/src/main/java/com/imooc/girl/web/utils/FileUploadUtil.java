package com.imooc.girl.web.utils;

import com.imooc.girl.web.enums.FileTypeEnum;
import lombok.extern.log4j.Log4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hmh on 2017/9/6.
 */
@Log4j
public class FileUploadUtil {

    /**
     * 读取文件头
     */
    private static String getFileHeader(String filePath) throws IOException {
        byte[] b = new byte[28];
        InputStream inputStream = new FileInputStream(filePath);

        inputStream.read(b, 0, 28);
        inputStream.close();

        return byte2hex(b);
    }

    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) hs = hs + "0" + stmp;
            else hs = hs + stmp;
            if (n < b.length - 1) hs = hs + "%";
        }
        return hs.toUpperCase();
    }

    /**
     * 判断文件类型
     */
    public static FileTypeEnum getType(String filePath) throws IOException {
        String fileHeader = getFileHeader(filePath);
        if (fileHeader == null || fileHeader.length() == 0) {
            return null;
        }
        fileHeader = fileHeader.toUpperCase();
        FileTypeEnum[] fileTypes = FileTypeEnum.values();
        for (FileTypeEnum type : fileTypes) {
            if (fileHeader.startsWith(type.getValue())) {
                return type;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "C:/Users/hmh/Desktop/html/admin.html";
        String value = getType(filePath).getValue();
        System.out.println(value);
    }

}
