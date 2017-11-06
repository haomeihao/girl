package com.imooc.girl.core.nio.channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by hmh on 2017/8/23.
 */
public class FileChannelTest {
    public static void main(String[] args) throws IOException {

        RandomAccessFile aFile = new RandomAccessFile("nio-data.txt", "rw");

        // 获取通道
        FileChannel inChannel = aFile.getChannel();

        // 新建ByteBuffer从通道读取数据
        ByteBuffer buf = ByteBuffer.allocate(96);

        // 通道数据读入Buffer
        // 对Buffer来说是写入数据
        int bytesRead = inChannel.read(buf);

        while (bytesRead != -1) {
            System.out.println("Read:" + bytesRead);
            // 从写模式进入读模式
            buf.flip();

            // 当position < limit
            while (buf.hasRemaining()) {
                System.out.print(buf.get());
            }
            System.out.println();

            // 清空整个Buffer
            buf.clear();
            bytesRead = inChannel.read(buf);
        }

        // 关闭文件资源 顺便关闭Channel
        aFile.close();

    }
}
