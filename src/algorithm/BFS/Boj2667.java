package algorithm.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2667 {
	private static int[][] map;
	private static boolean[][] visited;
	private static ArrayList<Integer> list;
	private static int[] mx = {1,-1,0,0};
	private static int[] my = {0,0,-1,1};
	
	private static class Dot {
		private static int x;
		private static int y;
		
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void bfs(int x, int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.offer(new Dot(x,y));
		
		int cnt = 0;
		
		map[x][y] = 2;
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			
			Dot current = q.poll();
			
			for (int i = 0; i < 4; i++) {
				
				int next_x = current.x + mx[i];
				int next_y = current.y + my[i];
				
				if (next_x < 0 || next_y < 0 || next_x > map.length || next_y > map[x].length) continue;
				
				if (map[next_x][next_y] != 1 || visited[next_x][next_y]) continue;
				
				map[x][y] = 2;
				visited[x][y] = true;
				q.add(new Dot(next_x,next_y));
				cnt++;
			}
			
		}
		
		list.add(cnt);
		
	}
	
	public static void solution(int N, Scanner sc) {
		
		map = new int[N+1][N+1];
		
		for (int i = 0; i < N+1; i++) {
			
			Arrays.fill(map[i], 0);
			Arrays.fill(visited[i], false);
		}
		
		for (int i = 0; i < N+1; i++) {
			
			for (int j = 0; j < N+1; j++) {
				
				map[i][j] = sc.nextInt();
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N+1; i++) {
			
			for (int j = 0; j < N+1; j++) {
				
				if (map[i][j] == 1 && !visited[i][j]) bfs(i,j);
			}
		}
	}
	
}
