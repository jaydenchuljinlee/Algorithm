package algorithm.programmers;

import java.util.*;

/*
 * 2018 summer/winter conding
 * ���
 * */
public class Pro12978 {

    private static ArrayList<ArrayList<int[]>> list;//�� ������ ���� ���� ������ ����ġ�� �迭�� ������ ����Ʈ
    private static int[] visited;//�湮 ������ �ּ� �Ÿ��� ����
    private static final int MAX_VAL = Integer.MAX_VALUE;
    private static int ans,max;

    public static int solution(int N, int[][] road, int K) {

        visited = new int[N+1];

        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) list.add(new ArrayList<int[]>());

        Arrays.fill(visited, MAX_VAL);//�湮 �Ÿ��� �ִ����� �ʱ�ȭ

        for (int i = 0; i < road.length; i++) {

            int u 	 = road[i][0];
            int v 	 = road[i][1];
            int cost = road[i][2];

            list.get(u).add(new int[] {v,cost});//��������� ���� ������ ���� ������ ����
            list.get(v).add(new int[] {u,cost});
        }

        ans = 1;
        max = K;

        visited[1] = 0;//ó�� �����ϴ� ������ �湮 �Ÿ��� ����

        dfs(1,0);

        return ans;
    }

    private static void dfs(int u, int sum) {

        for (int[] nx : list.get(u)) {//���� ������ ���� ������ ���� ����

            int v    = nx[0];//���� ����
            int cost = nx[1];//���� �������� v������ �Ÿ�

            //���� v������ �湮 �Ÿ��� ���� �������� ���� ���������� �Ÿ��� ��
            if (cost+sum >= visited[v] || cost+sum > max) continue;

            if (visited[v] == MAX_VAL) ans++;//�湮 �Ÿ��� ������ �ȵǾ����� ���� ����

            visited[v] = cost+sum;//���� �湮�ߴ� ��Ʈ���� �� ū �Ÿ����� �ٽ� ���� �ʿ䰡 �����Ƿ� �ּڰ����� ����

            dfs(v,cost+sum);//���� ���������� �Ÿ� �հ� ���� ������ �̵��ؼ� DFS ��Ž��
        }


    }
}
