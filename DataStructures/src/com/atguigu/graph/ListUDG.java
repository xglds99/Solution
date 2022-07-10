package com.atguigu.graph;

import java.io.IOException;
import java.util.Scanner;

public class ListUDG {

    // �ڽӱ��б��Ӧ������Ķ���
    private class ENode {
        int ivex;       // �ñ���ָ��Ķ����λ��
        ENode nextEdge; // ָ����һ������ָ��
    }

    // �ڽӱ��б�Ķ���
    private class VNode {
        char data;          // ������Ϣ
        ENode firstEdge;    // ָ���һ�������ö���Ļ�
    };

    private VNode[] mVexs;  // ��������


    /*
     * ����ͼ(�Լ���������)
     */
    public ListUDG() {

        // ����"������"��"����"
        System.out.printf("input vertex number: ");
        int vlen = readInt();
        System.out.printf("input edge number: ");
        int elen = readInt();
        if ( vlen < 1 || elen < 1 || (elen > (vlen*(vlen - 1)))) {
            System.out.printf("input error: invalid parameters!\n");
            return ;
        }

        // ��ʼ��"����"
        mVexs = new VNode[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("vertex(%d): ", i);
            mVexs[i] = new VNode();
            mVexs[i].data = readChar();
            mVexs[i].firstEdge = null;
        }

        // ��ʼ��"��"
        //mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            // ��ȡ�ߵ���ʼ����ͽ�������
            System.out.printf("edge(%d):", i);
            char c1 = readChar();
            char c2 = readChar();
            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            // ��ʼ��node1
            ENode node1 = new ENode();
            node1.ivex = p2;
            // ��node1���ӵ�"p1���������ĩβ"
            if(mVexs[p1].firstEdge == null)
                mVexs[p1].firstEdge = node1;
            else
                linkLast(mVexs[p1].firstEdge, node1);
            // ��ʼ��node2
            ENode node2 = new ENode();
            node2.ivex = p1;
            // ��node2���ӵ�"p2���������ĩβ"
            if(mVexs[p2].firstEdge == null)
                mVexs[p2].firstEdge = node2;
            else
                linkLast(mVexs[p2].firstEdge, node2);
        }
    }

    /*
     * ����ͼ(�����ṩ�ľ���)
     *
     * ����˵����
     *     vexs  -- ��������
     *     edges -- ������
     */
    public ListUDG(char[] vexs, char[][] edges) {

        // ��ʼ��"������"��"����"
        int vlen = vexs.length;
        int elen = edges.length;

        // ��ʼ��"����"
        mVexs = new VNode[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
            mVexs[i].firstEdge = null;
        }

        // ��ʼ��"��"
        for (int i = 0; i < elen; i++) {
            // ��ȡ�ߵ���ʼ����ͽ�������
            char c1 = edges[i][0];
            char c2 = edges[i][1];
            // ��ȡ�ߵ���ʼ����ͽ�������
            int p1 = getPosition(edges[i][0]);
            int p2 = getPosition(edges[i][1]);

            // ��ʼ��node1
            ENode node1 = new ENode();
            node1.ivex = p2;
            // ��node1���ӵ�"p1���������ĩβ"
            if(mVexs[p1].firstEdge == null)
                mVexs[p1].firstEdge = node1;
            else
                linkLast(mVexs[p1].firstEdge, node1);
            // ��ʼ��node2
            ENode node2 = new ENode();
            node2.ivex = p1;
            // ��node2���ӵ�"p2���������ĩβ"
            if(mVexs[p2].firstEdge == null)
                mVexs[p2].firstEdge = node2;
            else
                linkLast(mVexs[p2].firstEdge, node2);
        }
    }

    /*
     * ��node�ڵ����ӵ�list�����
     */
    private void linkLast(ENode list, ENode node) {
        ENode p = list;

        while(p.nextEdge!=null)
            p = p.nextEdge;
        p.nextEdge = node;
    }

    /*
     * ����chλ��
     */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++)
            if(mVexs[i].data==ch)
                return i;
        return -1;
    }

    /*
     * ��ȡһ�������ַ�
     */
    private char readChar() {
        char ch='0';

        do {
            try {
                ch = (char)System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while(!((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z')));

        return ch;
    }

    /*
     * ��ȡһ�������ַ�
     */
    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /*
     * ���������������ͼ�ĵݹ�ʵ��
     */
    private void DFS(int i, boolean[] visited) {
        ENode node;

        visited[i] = true;
        System.out.printf("%c ", mVexs[i].data);
        node = mVexs[i].firstEdge;
        while (node != null) {
            if (!visited[node.ivex])
                DFS(node.ivex, visited);
            node = node.nextEdge;
        }
    }

    /*
     * ���������������ͼ
     */
    public void DFS() {
        boolean[] visited = new boolean[mVexs.length];       // ������ʱ��

        // ��ʼ�����ж��㶼û�б�����
        for (int i = 0; i < mVexs.length; i++)
            visited[i] = false;

        System.out.printf("DFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i])
                DFS(i, visited);
        }
        System.out.printf("\n");
    }

    /*
     * ����������������������Ĳ�α�����
     */
    public void BFS() {
        int head = 0;
        int rear = 0;
        int[] queue = new int[mVexs.length];            // �������
        boolean[] visited = new boolean[mVexs.length];  // ������ʱ��

        for (int i = 0; i < mVexs.length; i++)
            visited[i] = false;

        System.out.printf("BFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.printf("%c ", mVexs[i].data);
                queue[rear++] = i;  // �����
            }

            while (head != rear) {
                int j = queue[head++];  // ������
                ENode node = mVexs[j].firstEdge;
                while (node != null) {
                    int k = node.ivex;
                    if (!visited[k])
                    {
                        visited[k] = true;
                        System.out.printf("%c ", mVexs[k].data);
                        queue[rear++] = k;
                    }
                    node = node.nextEdge;
                }
            }
        }
        System.out.printf("\n");
    }

    /*
     * ��ӡ�������ͼ
     */
    public void print() {
        System.out.printf("List Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("%d(%c): ", i, mVexs[i].data);
            ENode node = mVexs[i].firstEdge;
            while (node != null) {
                System.out.printf("%d(%c) ", node.ivex, mVexs[node.ivex].data);
                node = node.nextEdge;
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = new char[][]{
                {'A', 'C'},
                {'A', 'D'},
                {'A', 'F'},
                {'B', 'C'},
                {'C', 'D'},
                {'E', 'G'},
                {'F', 'G'}};
        ListUDG pG;

        // �Զ���"ͼ"(����������)
        //pG = new ListUDG();
        // �������е�"ͼ"
        pG = new ListUDG(vexs, edges);

        pG.print();   // ��ӡͼ
        pG.DFS();     // ������ȱ���
        pG.BFS();     // ������ȱ���
    }
}
