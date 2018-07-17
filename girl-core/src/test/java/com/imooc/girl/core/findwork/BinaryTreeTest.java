package com.imooc.girl.core.findwork;

/**
 * 二叉树数据结构的实现
 * Created by hmh on 2018/6/29.
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTreeManger binaryTreeManger = new BinaryTreeManger();

        binaryTreeManger.add(1);
        binaryTreeManger.add(3);
        binaryTreeManger.add(4);
        binaryTreeManger.add(8);
        binaryTreeManger.add(6);
        binaryTreeManger.print();
    }
}

class BinaryTreeManger {

    private Node root;//根节点

    public void add(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            root.addNode(data);
        }
    }

    public void print() {
        root.print("根");
    }

    class Node {
        private int data;
        private Node left; //左子树
        private Node right; //右子树

        public Node(int data) {
            this.data = data;
        }

        //添加节点
        public void addNode(int data) {
            //首先判断大小，来决定将data放在那个子树上
            if (data > this.data) {//当前数据较大，放在右子树
                if (this.right == null) {
                    this.right = new Node(data);
                } else {
                    this.right.addNode(data);
                }
            } else { //较小放在左子树上
                if (this.left == null) {
                    this.left = new Node(data);
                } else {
                    this.left.addNode(data);
                }

            }

        }

        //中序遍历 左 -> 根 -> 右
        public void print(String location) {
            if (this.left != null) {
                this.left.print("左");
            }
            System.out.print(location + data + "、");
            if (this.right != null) {
                this.right.print("右");
            }
        }
    }
}
