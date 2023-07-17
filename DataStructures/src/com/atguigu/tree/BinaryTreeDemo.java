package com.atguigu.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(0, "宋江");
        HeroNode node1 = new HeroNode(1, "吴用");
        HeroNode node2 = new HeroNode(2, "卢俊义");
        HeroNode node3 = new HeroNode(3, "林冲");
        HeroNode node4 = new HeroNode(4, "李广");
        binaryTree.setRoot(root);
        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);
        node2.setLeft(node4);
        binaryTree.levelOrder();
        System.out.println("***********");
        binaryTree.delNode(5);
        binaryTree.postOrder();
    }
}

//定义二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除指定节点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树！");
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode infixOrderSearch(int no) {
        if (this.root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode postOrderSearch(int no) {
        if (this.root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }


    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("该二叉树为空");
        }
    }

    /**
     * 前序遍历的非递归写法
     */
    public void preOrder_1() {
        Deque<HeroNode> st = new LinkedList<>();
        if (root != null) {
            st.push(root);
            while (!st.isEmpty()) {
                HeroNode p = st.pop();
                System.out.println(p);
                if (p.getRight() != null) {
                    st.push(p.getRight());
                }
                if (p.getLeft() != null) {
                    st.push(p.getLeft());
                }
            }
        }
    }


    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("该二叉树为空");
        }
    }

    //中序遍历非递归写法
    public void infixOrder_1() {
        HeroNode p = root;
        Deque<HeroNode> st = new LinkedList<>();
        while (!st.isEmpty() || p != null) {
            while (p != null) {
                st.push(p);
                p = p.getLeft();
            }
            if (!st.isEmpty()) {
                HeroNode pop = st.pop();
                System.out.println(pop);
                p = pop.getRight();
            }
        }
    }

    //后续遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("该二叉树为空");
        }
    }

    //后序遍历非递归写法
    public void postOrder_1() {
        HeroNode p, r;
        boolean flag;
        Deque<HeroNode> st = new LinkedList<>();
        p = root;
        do {
            while (p != null) {
                st.push(p);
                p = p.getLeft();
            }
            r = null;
            flag = true;
            while (!st.isEmpty() && flag) {
                p = st.peek();
                if (p.getRight() == r) {
                    System.out.println(p);
                    st.pop();
                    r = p;
                } else {
                    p = p.getRight();
                    flag = false;
                }
            }
        } while (!st.isEmpty());
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {

        if (this.root == null) {
            return;
        }
        Queue<HeroNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            HeroNode cur = queue.poll();
            System.out.println(cur);
            if (cur.getLeft() != null) {
                queue.add(cur.getLeft());
            }
            if (cur.getRight() != null) {
                queue.add(cur.getRight());
            }
        }
    }
}


class HeroNode {
    private int sum;
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public HeroNode(int no) {
        this.no = no;
    }

    public HeroNode() {
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //删除节点
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }

    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            left.preOrder();
        }
        if (this.right != null) {
            right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            right.infixOrder();
        }
    }

    //后续遍历
    public void postOrder() {
        if (this.left != null) {
            left.postOrder();
        }
        if (this.right != null) {
            right.postOrder();
        }
        System.out.println(this);
    }


    //前序查找
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历~");
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (left != null) {
            resNode = left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (right != null) {
            resNode = right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序查找
    public HeroNode infixOrderSearch(int no) {

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入前序遍历~");
        if (this.no == no)
            return this;
        if (this.right != null) {
            resNode = right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入前序遍历~");
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}