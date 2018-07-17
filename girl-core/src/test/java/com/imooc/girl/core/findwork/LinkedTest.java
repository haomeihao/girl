package com.imooc.girl.core.findwork;

/**
 * 链表的实现
 * Created by hmh on 2018/6/29.
 */
public class LinkedTest {

    public static void main(String[] args) {
        NodeManager nodeManager = new NodeManager();
        nodeManager.addNode("找");
        nodeManager.addNode("到");
        nodeManager.addNode("一");
        nodeManager.addNode("个");
        nodeManager.addNode("好");
        nodeManager.addNode("工");
        nodeManager.addNode("作");
        nodeManager.delNode("好");
        nodeManager.print();
    }
}


//节点管理类
class NodeManager {

    private Node root;//根节点

    //添加节点
    public void addNode(String data) {
        if (root == null) {
            root = new Node(data);
        } else {
            root.addNode(data);
        }
    }

    //删除节点
    public void delNode(String data) {
        if (root.data.equals(data)) {
            root = root.next;
        } else {
            root.delNode(data);
        }
    }

    //打印节点
    public void print() {
        if (root != null) {
            System.out.print(root.data + " ->");
            root.print();
        }
    }


    // 节点类
    class Node {
        private String data;//数据源
        private Node next;//指针域

        public Node(String data) {
            this.data = data;
        }

        //添加方法
        public void addNode(String data) {
            if (this.next == null) {
                this.next = new Node(data);
            } else {
                this.next.addNode(data);
            }
        }

        //删除方法
        public void delNode(String name) {
            if (this.next != null) {
                if (this.next.data.equals(name)) {
                    this.next = this.next.next;
                } else {
                    this.next.delNode(name);
                }
            }
        }

        //打印方法
        public void print() {
            if (this.next != null) {
                System.out.print(this.next.data + "->");
                this.next.print();
            }
        }
    }

}
