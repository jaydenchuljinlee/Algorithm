package algorithm.programmers;

import java.util.*;

/*
 * 2018 summer/winter conding
 * ¹è´Þ
 * */
public class Pro12978 {

    private static ArrayList<ArrayList<int[]>> list;
    private static int[] visited;
    private static final int MAX_VAL = Integer.MAX_VALUE;
    private static int ans,max;

    public static int solution(int N, int[][] road, int K) {

        visited = new int[N+1];

        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) list.add(new ArrayList<int[]>());

        Arrays.fill(visited, MAX_VAL);

        for (int i = 0; i < road.length; i++) {

            int u 	 = road[i][0];
            int v 	 = road[i][1];
            int cost = road[i][2];

            list.get(u).add(new int[] {v,cost});
            list.get(v).add(new int[] {u,cost});
        }

        ans = 1;
        max = K;

        visited[1] = 0;

        dfs(1,0);

        return ans;
    }

    private static void dfs(int u, int sum) {

        for (int[] nx : list.get(u)) {

            int v    = nx[0];
            int cost = nx[1];

            if (cost+sum >= visited[v] || cost+sum > max) continue;

            if (visited[v] == MAX_VAL) ans++;

            visited[v] = cost+sum;

            dfs(v,cost+sum);
        }


    }
}
