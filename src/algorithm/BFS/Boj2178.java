package algorithm.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2178 {
	private static int map[][];
	private static int distance[][];
	private static boolean visited[][];
	private static int[] mx = {1,-1,0,0};
	private static int[] my= {0,0,-1,1};
	
	public static class Dot {
		private static int x;
		private static int y;
		
		public Dot(int x, int y) {
			x = this.x;
			y = this.y;
		}
		
	}
	
	public static void bfs(int x,int y) {
		
		Queue<Dot> q = new LinkedList<Dot>(); 
		q.offer(new Dot(x,y));
		
		while(!q.isEmpty()) {
			
			Dot d = q.poll();
			
			if (d.x == map.length && d.y == map[x].length) break;
			
			for (int i = 0; i < 4; i++) {
				
				int next_x = d.x + mx[i];
				int next_y = d.y + my[i];
				
				if (next_x < 0 || next_y < 0 || next_x > map.length || next_y > map[x].length) continue;
				
				if (visited[next_x][next_y] ||  map[next_x][next_y] == 0) continue;
				
				q.offer(new Dot(next_x,next_y));
				distance[next_x][next_y] = distance[d.x][d.y] + 1;
				visited[next_x][next_y] = true;
			}
		}
		
	}
	
	public static void solution(int N, int M,Scanner sc) {
		
		map = new int[N+1][M+1];
		distance = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		
		for (int i = 0; i<N; i++) {
			
			Arrays.fill(map[i], 0);
			distance = new int[N+1][M+1];
			Arrays.fill(visited[i],false);
		}
		
		for (int i = 0; i < N+1; i++) {
			
			for (int j = 0; j < M+1; j++) {
				
				int s = sc.nextInt();
				int e = sc.nextInt();
				
				map[s][e] = 1;
			}
		}
		visited[0][0] = true;
		bfs(0,0);
		System.out.println(map[N][M]);
	}
	
}
