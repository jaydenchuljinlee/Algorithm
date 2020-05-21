package algorithm.programmersLevel2;

import java.util.*;

/*
* 2017 카카오코드 예선
* 카카오프렌즈 컬러링북
* */
public class Pro1829 {
    private static boolean[][] visited;//방문했을을 표시
    private static int[] dx = {-1,1,0,0};//상,하,좌,우
    private static int[] dy = {0,0,-1,1};

    //좌표 정보 클래스
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

        int maxArea = 0;//최대 영역의 갯수
        int area = 0;//영역 구간 갯수

        //그림 탐색
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (picture[j][i] != 0 && !visited[j][i]) {

                    area++;//영역 구간을 증가

                    Queue<Dot> q = new LinkedList<>();

                    q.add(new Dot(i,j));

                    int cnt = 0;//갯수

                    while(!q.isEmpty()) {//같은 영역이 있을 때까지

                        Dot d = q.poll();

                        for (int dir = 0; dir < 4; dir++) {

                            int nx = d.x + dx[dir];//다음 구할 x좌표
                            int ny = d.y + dy[dir];//다음 구할 y좌표

                            //그림의 크기를 넘어설 때
                            if (nx < 0 || ny < 0 || nx == n || ny == m) continue;

                            //방문했거나 같은 영역이 아니면
                            if (visited[ny][nx] || picture[ny][nx] != picture[j][i]) continue;

                            visited[ny][nx] = true;//방문했음을 표시

                            cnt++;//갯수를 증가
                            q.add(new Dot(nx,ny));//현재 가능한 탐색 구간을 추가

                        }
                    }

                    maxArea = Math.max(maxArea,cnt);//현재 영역의 갯수와 최댓값 비교
                }
            }
        }

        int[] answer = new int[2];

        answer[0] = area;//영역 갯수
        answer[1] = maxArea;//최대 영역 갯수

        return answer;
    }
}
