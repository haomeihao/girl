package com.imooc.girl.parent.zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by hmh on 2017/8/28.
 */
public class ZKDemo {

    private static String CLIENT_HOST, CLIENT_PORT;

    static {
        CLIENT_HOST = "127.0.0.1";
        CLIENT_PORT = "8081";
    }

    private static CountDownLatch connectedSignal = new CountDownLatch(1);

    static class ClientBase {
        static int CONNECTION_TIMEOUT = 3000;
    }

    public static void main(String[] args) {
        // 创建一个与服务器的连接
        ZooKeeper zk = null;
        try {
            System.setProperty("jute.maxbuffer", 4096 * 1024 * 300 + "");

            zk = new ZooKeeper(CLIENT_HOST + ":" + CLIENT_PORT,
                    ClientBase.CONNECTION_TIMEOUT, new Watcher() {
                // 监控所有出发的事件
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("已经触发了" + event.getType() + "事件！");
                    if (event.getState() == Event.KeeperState.SyncConnected) {
                        connectedSignal.countDown(); // 倒数-1
                    }
                }
            });

            // 等待连接完成
            connectedSignal.await();

            // 取出子目录节点列表
            System.out.println(zk.getChildren("/testRootPath", true));

            // 创建一个目录节点
            zk.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT);

            // 创建一个子目录节点
            zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT);

            System.out.println(new String(zk.getData("/testRootPath", false, null)));

            // 取出子目录节点列表
            System.out.println(zk.getChildren("/testRootPath", true));

            // 修改子目录节点数据
            zk.setData("/testRootPath/testChildPathOne", "modifyChildDataOne".getBytes(), -1);
            System.out.println("目录节点状态：[" + zk.exists("/testRootPath", true) + "]");

            // 创建另外一个子目录节点
            zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT);

            System.out.println(new String(zk.getData("/testRootPath", false, null)));

            // 删除子目录节点
            zk.delete("/testRootPath/testChildPathTwo", -1);
            zk.delete("/testRootPath/testChildPathOne", -1);

            // 删除父目录节点
            zk.delete("/testRootPath", -1);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            try {
                zk.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
