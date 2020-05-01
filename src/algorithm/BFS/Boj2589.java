package algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2589 {
	private static int r,c;
	private static char[][] map;
	private static int[][] dist;
	private static boolean[][] visited;
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {1,-1,0,0};
	private static int ans = 0;
	
	public static class Dot {
		int x;
		int y;
		
		Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void solution() throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		r = reader.read();
		c = reader.read();
		
		map = new char[c][r];
		
		for (int i = 0; i < c; i++) {
			
			map[i] = reader.readLine().toCharArray();
		}
		
		for (int i = 0; i < c; i++) {
			
			for (int j = 0; j < r; j++) {
				
				dist = new int[c][r];
				visited = new boolean[c][r];
				
				BFS(i,j);
			}
		}
	}


	private static void BFS(int y, int x) {

		Queue<Dot> list = new LinkedList();
		
		list.offer(new Dot(x,y));
		visited[y][x] = true;
		int temp = 0;
		
		while(!list.isEmpty()) {
			
			Dot d = list.poll();
			
			for (int i = 0; i < 4; i++) {
				
				int next_x = d.x + dx[i];
				int next_y = d.y + dy[i];
				
				if (next_x < 0 || next_y < 0 || next_x >= r || next_y >= c) continue;
				
				if (visited[next_y][next_x] || map[next_y][next_x] == 'W') continue;
				
				list.offer(new Dot(next_x,next_y));
				visited[next_y][next_x] = true;
				dist[next_y][next_x] = dist[d.y][d.x]+1;
				
				if (temp < dist[next_y][next_x]) {
					temp = dist[next_y][next_x];
				}
			}
		}
		
		if (ans < temp) ans = temp;
		
	}
}
