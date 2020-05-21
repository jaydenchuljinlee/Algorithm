package algorithm.programmersLevel2;

import java.util.*;

/*
* 2017 īī���ڵ� ����
* īī�������� �÷�����
* */
public class Pro1829 {
    private static boolean[][] visited;//�湮������ ǥ��
    private static int[] dx = {-1,1,0,0};//��,��,��,��
    private static int[] dy = {0,0,-1,1};

    //��ǥ ���� Ŭ����
    private static class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {

        visited = new boolean[m][n];

        int maxArea = 0;//�ִ� ������ ����
        int area = 0;//���� ���� ����

        //�׸� Ž��
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (picture[j][i] != 0 && !visited[j][i]) {

                    area++;//���� ������ ����

                    Queue<Dot> q = new LinkedList<>();

                    q.add(new Dot(i,j));

                    int cnt = 0;//����

                    while(!q.isEmpty()) {//���� ������ ���� ������

                        Dot d = q.poll();

                        for (int dir = 0; dir < 4; dir++) {

                            int nx = d.x + dx[dir];//���� ���� x��ǥ
                            int ny = d.y + dy[dir];//���� ���� y��ǥ

                            //�׸��� ũ�⸦ �Ѿ ��
                            if (nx < 0 || ny < 0 || nx == n || ny == m) continue;

                            //�湮�߰ų� ���� ������ �ƴϸ�
                            if (visited[ny][nx] || picture[ny][nx] != picture[j][i]) continue;

                            visited[ny][nx] = true;//�湮������ ǥ��

                            cnt++;//������ ����
                            q.add(new Dot(nx,ny));//���� ������ Ž�� ������ �߰�

                        }
                    }

                    maxArea = Math.max(maxArea,cnt);//���� ������ ������ �ִ� ��
                }
            }
        }

        int[] answer = new int[2];

        answer[0] = area;//���� ����
        answer[1] = maxArea;//�ִ� ���� ����

        return answer;
    }
}
