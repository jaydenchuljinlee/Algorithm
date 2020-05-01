package algorithm.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj11724 {
	private static int n,m,cnt;
	private static int[][] map;
	private static boolean[] visited;
	private static ArrayList<Integer> list;
	
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map		= new int[n][n];
		visited = new boolean[n];
		
		for (int i = 0; i < m; i++) {
			
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			
			map[u][v] = 1;
		}
		
		list = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			
			if(!visited[i]) {
				cnt = 1;
				DFS(i,cnt);
				list.add(cnt);
			} 
		}
		
		System.out.println(list.size());
	}

	private static void DFS(int idx,int depth) {
		
		visited[idx] = true;
		
		for (int i = 0; i < n; i++) {
			
			if(map[idx][i] == 1 && !visited[i]) {
				DFS(i,depth+1);
			}
		}
		
	}
}
