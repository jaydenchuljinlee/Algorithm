package algorithm.programmers;

import java.util.*;

/*
 * 2019 summer/winter conding
 * ���� �̵�
 * */
public class Pro62050 {

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};
    private static int[] parent;//���� ������ ã���� �迭
    private static int[][] check;//������ ���� �� �迭
    private static ArrayList<Node> list;//������ �ٸ� �� ������ ���̸� ������ ����Ʈ

    private static class Dot {//BFS Ž���� ���� ��ǥ Ŭ����
        int x;
        int y;

        protected Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private static class Node {//���� �ٸ� �� ������ �� ������ ���̸� ������ Ŭ����
        int first;
        int second;
        int diff;

        protected Node(int first, int second, int diff) {
            this.first = first;
            this.second = second;
            this.diff = diff;
        }

    }

    private static int findParent(int value) {//���� ������ ã�� ���� �޼���

        if (value == parent[value]) return value;//value�� ���� ������ ���� ������ ��
        return parent[value] = findParent(parent[value]);//���� ������ �ƴ϶��, ��Ž��
    }

    private static void union(int first, int second) {//�� ������ �������� ������ �޼���

        first   = findParent(first);//ù ��° ������ ���� ���� Ž��
        second = findParent(second);//�� ��° ������ ���� ���� Ž��

        if (first < second) parent[second] = first;//�� ������ �������� ���� �������� �����ش�.
        else parent[first] = second;
    }

    public static int solution(int[][] land, int height) {
        int answer = 0;

        HashMap<String,String> map = new HashMap<>();

        int len = land.length;

        check = new int[len][len];

        for (int i = 0; i < len; i++) Arrays.fill(check[i],-1);//������ ������ �迭�� -1�� ä��

        list = new ArrayList<>();

        int area = -1;

        for (int i = 0; i < len; i++) {

            for (int j = 0; j < len; j++) {

                if (check[i][j] >= 0) continue;//�̹� ������ �������ִٸ�

                area++;

                Queue<Dot> q = new LinkedList<>();

                q.add(new Dot(i,j));

                check[i][j] = area;//������ �����ش�.

                while(!q.isEmpty()) {//�ϳ��� ������ ������� ������

                    Dot cur = q.poll();

                    for (int dir = 0; dir < 4; dir++) {

                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];

                        if (nx < 0 || ny < 0 || nx == len || ny == len) continue;

                        if (check[nx][ny] >= 0) continue;//������ ������ �ִٸ�

                        if (Math.abs(land[nx][ny] - land[cur.x][cur.y]) > height) continue;//������ ���̰� height���� ũ�ٸ�

                        check[nx][ny] = area;
                        q.add(new Dot(nx,ny));

                    }
                }
            }
        }

        parent = new int[area+1];//������ ������ŭ ���� ���� �迭�� �ʱ�ȭ

        for (int i = 0; i < parent.length; i++) parent[i] = i;

        for (int i = 0; i < len; i++) {//��,��,��,�� Ž��

            for (int j = 0; j < len; j++) {

                for (int dir = 0; dir < 4; dir++) {

                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if (nx < 0 || ny < 0 || nx == len || ny == len) continue;

                    if (check[i][j] == check[nx][ny]) continue;//���� �����̸�

                    list.add(new Node(check[i][j],check[nx][ny],Math.abs(land[i][j]-land[nx][ny])));//�ش� ������ Ÿ�� ����, �� �������� ����
                }
            }
        }

        Collections.sort(list, new Comparator<Node>() {//���� ����-���� ����-���� ���� ������ ����

            @Override
            public int compare(Node o1, Node o2) {

                if (o1.diff < o2.diff) {

                    return -1;
                } else if (o1.diff == o2.diff) {

                    if (o1.first < o2.first) return -1;
                    else return 1;

                } else {

                    return 1;
                }
            }
        });


        int cnt = 0;//���� ������ ã�� ������ ������ �÷��ֱ� ����.

        for (Node n : list) {//���� ���̰� �ּ��� ������ ���� ���� ���� Ž���� �Ѵ�.

            if (findParent(n.first) != findParent(n.second)) {//���� ������ Ÿ�� ������ ���� �ʴٸ�

                union(n.first,n.second);//�� ������ ���� ������ �� ���������� �����ش�.

                answer += n.diff;//������� �ּڰ��� �߰�

                if (++cnt == area) break;//���� ������ ������ ��ü ����-1�� �� �� ����.(�� N-1���� ���;��ϱ� ������)
            }
        }

        return answer;
    }
}
