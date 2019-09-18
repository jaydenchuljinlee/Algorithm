package algorithm.DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1260 {
	public static boolean[] visited;//�湮�ߴ����� üũ
	public static int[][] map;
	public static int n;
	public static int m;
	public static int v;

	public static void dfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(i);
		visited[i] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			System.out.println(temp + " ");
			
			for (int j = 1; j <= n; j++) {//���� �湮�� ������ �������� ������� ã������
				
				if (map[temp][j] == 1 && visited[j] == false) {// ������ �ְ� && �湮���� �ʾ�����
					q.offer(j);
					visited[j] = true;
				}
			}
		}
	}
	
	public static void bfs(int i) {
		visited[i] = true;
		
		System.out.println(i + " ");
		
		for (int j = 1; j<=n; j++) {
			
			if (map[i][j] == 1 && visited[j] == false) {// ������ �ְ� && �湮���� �ʾ�����
				dfs(j);//���� ���� �湮
			} 
		}
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i < n+1; i++) {
			Arrays.fill(map[i], 0);
		}
		
		Arrays.fill(visited, false);
		
		for (int i = 0; i < m; i++) {
			String edge = sc.next();
			String[] str = edge.split(" ");
			
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			map[a][b] = 1;
			map[b][a] = 1;
			
		}
		
		dfs(v);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(v);
		
	}
}
