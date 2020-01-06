package algorithm.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj3109 {
	private static int R,C;
	private static char[][] map;
	private static int[] dy = {-1,0,1};
	private static boolean[][] visited;
	private static int cnt = 0;
	
	public static void solution() throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		R = reader.read();
		C = reader.read();
		
		map = new char[R][C];
		
		for (int i = 0; i < map.length; i++) {
			map[i] = reader.readLine().toCharArray();
		}
		
		for (int i = 0; i < C;) {
			dfs(i,0);
		}
		
	}

	private static void dfs(int y, int x) {

		if (x == R-1) {
			++cnt;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			
			int nx = x+1;
			int ny = dy[i] + y;
			
			if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[ny][nx] == 'x') continue;
			
			if (!visited[ny][nx]) {
				visited[ny][nx] = true;
				dfs(ny,nx);
			}
			
		}
		
	}
}
