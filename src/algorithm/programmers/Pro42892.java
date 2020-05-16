package algorithm.programmers;

import java.util.*;

/*
* 2019 īī�� ����ε�
* �� ã�� ����
*
* */
public class Pro42892 {

    //����� ����
    private static class Node {
        int x;
        int y;
        int value;
        Node leftNode;//����
        Node rightNode;//������

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public static int[][] solution(int[][] nodeinfo) {

        ArrayList<Node> list = new ArrayList<>();

        //���� ��� �迭������ Ŭ����ȭ�� ����Ʈ�� �־��ش�.
        for (int i = 0, loop = nodeinfo.length; i < loop; i++) {

            list.add(new Node(nodeinfo[i][0],nodeinfo[i][1],i+1));
        }

        //����Ʈ�� y�� ��������, x�� ������������ �������ش�.
        Collections.sort(list,new Comparator<Node>() {

            @Override
            public int compare(Node o1,Node o2) {

                if (o1.y == o2.y) {

                    if (o1.x < o2.x) return -1;
                    else return 1;

                } else if (o1.y < o2.y) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        //����Ʈ�� ù ��° ��Ұ� ž����̴�.
        Node top = list.get(0);

        //ž����� ������ ��ҵ�� ���� ��ҵ��� ������ ����Ʈ ����
        ArrayList<Node> leftSide  = new ArrayList<>();
        ArrayList<Node> rightSide = new ArrayList<>();

        for (int i = 1, loop = list.size(); i < loop; i++) {

            Node cur = list.get(i);

            if (top.x < cur.x) rightSide.add(cur);//���� ����� x���� ž��庸�� ũ��, ������ ����Ʈ��
            else leftSide.add(cur);//������ ���� ����Ʈ�� �߰��Ѵ�.
        }

        makeEdge(top,leftSide,0);//ž��� ���� ���� ��ҵ��� ������ �޼���
        makeEdge(top,rightSide,1);//ž��� ���� ������ ��ҵ��� ������ �޼���

        ArrayList<Integer> preList  = new ArrayList<>();//������ȸ�� ������ ����Ʈ
        ArrayList<Integer> postList = new ArrayList<>();//������ȸ�� ������ ����Ʈ

        preorder(top,preList);//������ȸ
        postorder(top,postList);//������ȸ

        int[][] answer = new int[2][preList.size()];

        for (int i = 0, loop = preList.size(); i < loop; i++) {

            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }


        return answer;
    }

    //������ȸ
    public static void preorder(Node top,ArrayList<Integer> list) {

        if (top == null) return;

        list.add(top.value);//ž��带 ���� Ž��
        preorder(top.leftNode,list);//���� ��� Ž��
        preorder(top.rightNode,list);//������ ��� Ž��
    }

    //������ȸ
    public static void postorder(Node top, ArrayList<Integer> list) {

        if (top == null) return;

        postorder(top.leftNode,list);//���� ��� Ž��
        postorder(top.rightNode,list);//������ ��� Ž��
        list.add(top.value);//ž��� Ž��
    }

    //���� ��� ���� ������ ������ִ� �޼���
    public static void makeEdge(Node prev, ArrayList<Node> list,int dir) {

        if (list.size() == 0) return;//���̻� ���� ������ ����.

        Node top = list.get(0);

        if (dir == 0) prev.leftNode = top;//0�̸� ���� ����� ���ʿ�
        else prev.rightNode = top;//1�̸� ���� ����� �����ʿ� ���� ž��带 ��ġ�����ش�.

        ArrayList<Node> leftSide = new ArrayList<>();
        ArrayList<Node> rightSide = new ArrayList<>();

        for (int i = 1, loop = list.size(); i < loop; i++) {

            Node cur = list.get(i);

            if (top.x < cur.x) rightSide.add(cur);
            else leftSide.add(cur);
        }

        makeEdge(top,leftSide,0);
        makeEdge(top,rightSide,1);
    }

}
