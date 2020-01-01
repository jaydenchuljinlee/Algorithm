package algorithm.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1260 {
	private static int[][] map;
	private static boolean[] visited;

	public static void dfs(int v) {
		
		visited[v] = true;
		
		System.out.print(v+" ");
		
		for(int i=0;i<map[v].length;i++) {
			
			if (!visited[i] && map[v][i] == 1) dfs(i);
		}
	}
	
	public static void bfs(int v) {
		Queue<Integer> q= new LinkedList<Integer>();
		q.offer(v);
		
		visited[v] = true;
		
		while(!q.isEmpty()) {
			
			int temp = q.poll();
			
			System.out.print(temp+" ");
			
			for (int i=temp;i<map[temp].length;i++) {
				
				if (!visited[i] && map[v][i] == 1) {
					
					q.add(i);
					visited[i] = true;
				} 
			}
		}
		
		
		
		
	}
	
	public static void solution(int N, int M, int V,Scanner sc) {
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1]; 
		
		for (int i=0;i<N+1;i++) Arrays.fill(map[i], 0);
		
		Arrays.fill(visited, false);
		
		for(int i=0;i<M;i++) {
			int s=sc.nextInt();
			int e=sc.nextInt();
			
			map[s][e] = 1;
			map[e][s] = 1;
		}
		
		System.out.println("DFS 시작");
		dfs(V);
		
		System.out.println("BFS 시작");
	}
}
