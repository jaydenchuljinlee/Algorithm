package algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2206 {
	private static int n,m;
	private static int[][] map;
	private static int[][] visited;
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {1,-1,0,0};
	private static int ans;
	
	public static class Dot {
		int x;
		int y;
		int dist;
		int drill;
		
		Dot(int x,int y, int dist, int drill) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.drill = drill;
		}
	}
	
	
	public static void solution() throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		n = reader.read();
		m = reader.read();
		
		map = new int[n][m];
		visited = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = reader.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);//char 형식이라 제대로 변환해줘야함
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		ans = Integer.MAX_VALUE;
		BFS(0,0);
		
		if (ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}


	private static void BFS(int x, int y) {

		Queue<Dot> list = new LinkedList();
		
		list.offer(new Dot(x,y,1,0));
		
		visited[y][x] = 0;
		
		while(!list.isEmpty()) {
			
			Dot d = list.poll();
			
			if (d.y == n-1 && d.x == m) {
				ans = d.dist;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
				
				if (visited[ny][nx] <= d.drill) continue;
				
				if (map[ny][nx] == 0) {
					
					visited[ny][nx] = d.drill;
					list.offer(new Dot(nx,ny,d.dist+1,d.drill));
				} else {
					if (d.drill == 0) {
						
						visited[ny][nx] = d.drill +1;
						list.offer(new Dot(nx,ny,d.dist+1,d.drill+1));
					}
					
				}
			}
		}
	}
}
