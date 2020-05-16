package algorithm.programmers;

import java.util.*;

/*
* 2019 카카오 블라인드
* 길 찾기 게임
*
* */
public class Pro42892 {

    //노드의 정보
    private static class Node {
        int x;
        int y;
        int value;
        Node leftNode;//왼쪽
        Node rightNode;//오른쪽

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public static int[][] solution(int[][] nodeinfo) {

        ArrayList<Node> list = new ArrayList<>();

        //들어온 노드 배열정보를 클래스화여 리스트에 넣어준다.
        for (int i = 0, loop = nodeinfo.length; i < loop; i++) {

            list.add(new Node(nodeinfo[i][0],nodeinfo[i][1],i+1));
        }

        //리스트를 y의 내림차순, x의 오른차순으로 정렬해준다.
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

        //리스트의 첫 번째 요소가 탑노드이다.
        Node top = list.get(0);

        //탑노드의 오른쪽 요소들과 왼쪽 요소들을 결정할 리스트 선언
        ArrayList<Node> leftSide  = new ArrayList<>();
        ArrayList<Node> rightSide = new ArrayList<>();

        for (int i = 1, loop = list.size(); i < loop; i++) {

            Node cur = list.get(i);

            if (top.x < cur.x) rightSide.add(cur);//현재 노드의 x값이 탑노드보다 크면, 오른쪽 리스트에
            else leftSide.add(cur);//작으면 왼쪽 리스트에 추가한다.
        }

        makeEdge(top,leftSide,0);//탑노드 기준 왼쪽 요소들을 결정할 메서드
        makeEdge(top,rightSide,1);//탑노드 기준 오른쪽 요소들을 결정할 메서드

        ArrayList<Integer> preList  = new ArrayList<>();//전위순회를 저장할 리스트
        ArrayList<Integer> postList = new ArrayList<>();//후위순회를 저장할 리스트

        preorder(top,preList);//전위순회
        postorder(top,postList);//후위순회

        int[][] answer = new int[2][preList.size()];

        for (int i = 0, loop = preList.size(); i < loop; i++) {

            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }


        return answer;
    }

    //전위순회
    public static void preorder(Node top,ArrayList<Integer> list) {

        if (top == null) return;

        list.add(top.value);//탑노드를 먼저 탐색
        preorder(top.leftNode,list);//왼쪽 노드 탐색
        preorder(top.rightNode,list);//오른쪽 노드 탐색
    }

    //후위순회
    public static void postorder(Node top, ArrayList<Integer> list) {

        if (top == null) return;

        postorder(top.leftNode,list);//왼쪽 노드 탐색
        postorder(top.rightNode,list);//오른쪽 노드 탐색
        list.add(top.value);//탑노드 탐색
    }

    //현재 노드 기준 간선을 만들어주는 메서드
    public static void makeEdge(Node prev, ArrayList<Node> list,int dir) {

        if (list.size() == 0) return;//더이상 만들 간선이 없다.

        Node top = list.get(0);

        if (dir == 0) prev.leftNode = top;//0이면 이전 노드의 왼쪽에
        else prev.rightNode = top;//1이면 이전 노드의 오른쪽에 현재 탑노드를 위치시켜준다.

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
