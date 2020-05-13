package algorithm.programmers;

import java.util.*;

/*
 * 2018 summer/winter conding
 * 배달
 * */
public class Pro12978 {

    private static ArrayList<ArrayList<int[]>> list;//각 마을에 대한 인접 마을과 가중치를 배열로 저장한 리스트
    private static int[] visited;//방문 마을의 최소 거리를 저장
    private static final int MAX_VAL = Integer.MAX_VALUE;
    private static int ans,max;

    public static int solution(int N, int[][] road, int K) {

        visited = new int[N+1];

        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) list.add(new ArrayList<int[]>());

        Arrays.fill(visited, MAX_VAL);//방문 거리를 최댓값으로 초기화

        for (int i = 0; i < road.length; i++) {

            int u 	 = road[i][0];
            int v 	 = road[i][1];
            int cost = road[i][2];

            list.get(u).add(new int[] {v,cost});//양방향으로 인접 마을에 대한 정보를 저장
            list.get(v).add(new int[] {u,cost});
        }

        ans = 1;
        max = K;

        visited[1] = 0;//처음 시작하는 마을의 방문 거리를 셋팅

        dfs(1,0);

        return ans;
    }

    private static void dfs(int u, int sum) {

        for (int[] nx : list.get(u)) {//현재 마을의 인접 마을에 대한 정보

            int v    = nx[0];//인접 마을
            int cost = nx[1];//현재 마을부터 v까지의 거리

            //현재 v마을의 방문 거리와 현재 마을부터 인접 마을까지의 거리를 비교
            if (cost+sum >= visited[v] || cost+sum > max) continue;

            if (visited[v] == MAX_VAL) ans++;//방문 거리가 셋팅이 안되어있을 때는 셋팅

            visited[v] = cost+sum;//현재 방문했던 루트보다 더 큰 거리값을 다시 지날 필요가 없으므로 최솟값으로 셋팅

            dfs(v,cost+sum);//인접 마을까지의 거리 합과 인접 마을로 이동해서 DFS 재탐색
        }


    }
}
