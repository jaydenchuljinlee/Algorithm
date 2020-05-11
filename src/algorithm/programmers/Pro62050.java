package algorithm.programmers;

import java.util.*;

/*
 * 2019 summer/winter conding
 * 지형 이동
 * */
public class Pro62050 {

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};
    private static int[] parent;//공통 구역을 찾아줄 배열
    private static int[][] check;//구역을 나눠 줄 배열
    private static ArrayList<Node> list;//구역이 다른 두 지형의 차이를 저장할 리스트

    private static class Dot {//BFS 탐색을 위한 좌표 클래스
        int x;
        int y;

        protected Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private static class Node {//서로 다른 두 구역과 두 구역의 차이를 저장할 클래스
        int first;
        int second;
        int diff;

        protected Node(int first, int second, int diff) {
            this.first = first;
            this.second = second;
            this.diff = diff;
        }

    }

    private static int findParent(int value) {//공통 구역을 찾기 위한 메서드

        if (value == parent[value]) return value;//value가 현재 구역의 공통 구역일 때
        return parent[value] = findParent(parent[value]);//공통 구역이 아니라면, 재탐색
    }

    private static void union(int first, int second) {//두 구역을 공통으로 묶어줄 메서드

        first   = findParent(first);//첫 번째 인자의 공통 구역 탐색
        second = findParent(second);//두 번째 인자의 공통 구역 탐색

        if (first < second) parent[second] = first;//두 구역중 작은쪽을 공통 구역으로 묶어준다.
        else parent[first] = second;
    }

    public static int solution(int[][] land, int height) {
        int answer = 0;

        HashMap<String,String> map = new HashMap<>();

        int len = land.length;

        check = new int[len][len];

        for (int i = 0; i < len; i++) Arrays.fill(check[i],-1);//구역을 저장할 배열을 -1로 채움

        list = new ArrayList<>();

        int area = -1;

        for (int i = 0; i < len; i++) {

            for (int j = 0; j < len; j++) {

                if (check[i][j] >= 0) continue;//이미 구역이 정해져있다면

                area++;

                Queue<Dot> q = new LinkedList<>();

                q.add(new Dot(i,j));

                check[i][j] = area;//구역을 정해준다.

                while(!q.isEmpty()) {//하나의 구역이 만들어질 때까지

                    Dot cur = q.poll();

                    for (int dir = 0; dir < 4; dir++) {

                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];

                        if (nx < 0 || ny < 0 || nx == len || ny == len) continue;

                        if (check[nx][ny] >= 0) continue;//구역이 정해져 있다면

                        if (Math.abs(land[nx][ny] - land[cur.x][cur.y]) > height) continue;//지형의 차이가 height보다 크다면

                        check[nx][ny] = area;
                        q.add(new Dot(nx,ny));

                    }
                }
            }
        }

        parent = new int[area+1];//구역의 갯수만큼 공통 구역 배열을 초기화

        for (int i = 0; i < parent.length; i++) parent[i] = i;

        for (int i = 0; i < len; i++) {//상,하,좌,우 탐색

            for (int j = 0; j < len; j++) {

                for (int dir = 0; dir < 4; dir++) {

                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if (nx < 0 || ny < 0 || nx == len || ny == len) continue;

                    if (check[i][j] == check[nx][ny]) continue;//같은 구역이면

                    list.add(new Node(check[i][j],check[nx][ny],Math.abs(land[i][j]-land[nx][ny])));//해당 구역과 타켓 구역, 두 구역간의 차이
                }
            }
        }

        Collections.sort(list, new Comparator<Node>() {//구역 차이-현재 구역-다켓 구역 순으로 정렬

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


        int cnt = 0;//공통 구역을 찾을 때마다 갯수를 늘려주기 위함.

        for (Node n : list) {//구역 차이가 최소인 값부터 먼저 공통 구역 탐색을 한다.

            if (findParent(n.first) != findParent(n.second)) {//현재 구역과 타겟 구역이 같지 않다면

                union(n.first,n.second);//두 구역을 공통 구역이 더 작은쪽으로 묶어준다.

                answer += n.diff;//결과값에 최솟값을 추가

                if (++cnt == area) break;//공통 구역의 갯수가 전체 구역-1일 될 때 종료.(총 N-1개가 나와야하기 때문에)
            }
        }

        return answer;
    }
}
