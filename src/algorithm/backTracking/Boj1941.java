package algorithm.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1941 {
	private static char[][] map = new char[5][5];
	private static boolean[][] check = new boolean[5][5];
	private static boolean[] visited = new boolean[25];
	private static int[] dx = {-1,0,1,0};
	private static int[] dy = {0,-1,1,1};
	private static int cnt,ans;

	public static void solution() throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 5; i++) {
			map[i] = reader.readLine().toCharArray();
		}
		
		for (int i = 0; i < 25; i++) {
			
			DFS(i,1,0);
		}
		
	}

	private static void DFS(int n, int cnt, int s) {

		if (map[n/5][n%5] == 'S') ++s;
		
		visited[n] = true;
		check[n/5][n%5] = true;
		
		if (cnt == 7) {
			
			if (s >= 4) {
				find();
			}
		} else {
			
			for (int i = n+1; i < 25; i++) {
				
				if (!visited[i]) {
					DFS(i,cnt+1,s);
				}
			}
		}
		
		visited[n] = false;
		check[n/5][n%5] = false;
		
	}

	private static void find() {

		for (int i = 0; i < 25; i++) {
			
			if (visited[i]) {
				
				int y = i/5;
				int x = i%5;
				
				boolean[][] visited = new boolean[5][5];
				visited[y][x] = true;
				cnt = 1;
				
				isComponent(y,x,visited);
			}
		}
		
		
		
	}

	private static void isComponent(int y, int x, boolean[][] checked) {
		
		if (cnt == 7) {
			++ans;
		} else {
			
			for (int i = 0; i < 4; i++) {
				
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (nx < 0 || ny < 0 || nx >=5 || ny >= 5) return;
				
				if (check[ny][nx] && !checked[ny][nx]) {
					
					checked[ny][nx] = true;
					++cnt;
					isComponent(ny,nx,checked);
					
				}
			}
				
		}
			
		
		
	}
}
