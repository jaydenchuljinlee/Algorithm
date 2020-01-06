package algorithm.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1799 {
	private static int N;
	private static int[][] map;
	private static int[] dx = {1,-1,-1,1};
	private static int[] dy = {1,1,-1,-1};
	private static int w_cnt = 0;
	private static int b_cnt = 0;
	private static boolean[][] visited;
	
	public static void solution() throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		N = reader.read();
		
		map = new int[N][N];
		
		for (int i = 0 ; i < N; i++) {
			
			String[] str = reader.readLine().split(" ");
			
			for (int j = 0; j < N; j++) {
				
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		visited = new boolean[N][N];
		
		white_search(0,0,0);
		
		black_search(0,1,0);
		
		System.out.println(w_cnt + b_cnt);
	}

	private static void black_search(int y, int x, int cnt) {
		
		b_cnt = Math.max(b_cnt, cnt);
		
		if (x >= N) {
			y += 1;
			x = (y % 2) == 0 ? 0 : 1;
		}
		
		if (isAble(y,x)) {
			visited[y][x] = true;
			black_search(y,x+2,cnt+1);
			visited[y][x] = false;
		}
		
		black_search(y,x+2,cnt);
	}
	
	private static void white_search(int y, int x, int cnt) {

		w_cnt = Math.max(w_cnt, cnt);
		
		if (x >= N) {
			y += 1;
			x = (y % 2) == 0 ? 1 : 0;
		}
		
		if (isAble(y,x)) {
			visited[y][x] = true;
			white_search(y,x+2,cnt+1);
			visited[y][x] = false;
		}
		
		white_search(y,x+2,cnt);
		
	}
	
	private static boolean isAble(int y, int x) {

		if (map[y][x] == 0) return false;
		
		for (int i = 0; i < 4; i++) {
			
			int nx = x + dx[i];
			int ny = x + dy[i];
			
			for (int j = 0; j < N; j++) {
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) return false;
				
				if (visited[nx][ny]) return false;
				
				nx += dx[i];
				ny += dy[i];
			}
		}
		
		return true;
	}
}
