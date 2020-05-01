package algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj6593 {
	private static int l,r,c;
	private static char[][][] map;
	private static int[][][] dist;
	private static int[] dx = {1,-1,0,0,0,0};
	private static int[] dy = {0,0,-1,1,0,0};
	private static int[] dr = {0,0,0,0,1,-1};
	private static Queue<Dot> q;
	private static Dot start,end;
	private static final int INF = Integer.MAX_VALUE;
	
	private static class Dot {
		int x;
		int y;
		int r;
		
		public Dot(int x, int y,int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
	
	public static void solution() throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			String[] str = reader.readLine().split(" ");
			
			l = Integer.parseInt(str[0]);
			r = Integer.parseInt(str[1]);
			c = Integer.parseInt(str[2]);
			
			if (l == 0 && r == 0 && c == 0) break;
			
			map		= new char[l][r][c];
			dist	= new int[l][r][c];
			
			for (int i = 0; i < l; i++) {
				
				for (int j = 0; j < r; j++) {
					
					String str2 = reader.readLine();
						
					for (int k = 0; k < c; k++) {
						map[i][j][k] = str2.charAt(k);
						
						if (map[i][j][k] == 'S') {
							start = new Dot(i,j,k);
						}
						
						if (map[i][j][k] == 'E') {
							end = new Dot(i,j,k);
						}
					}
				}
				
				reader.readLine();
			}
			
			solve();
			int result = dist[end.r][end.y][end.x];
			
			if (result == 0) {
				System.out.println("Trapped");
			} else {
				System.out.println("Excaped in " + result + " minute(s)");
			}
		}
		
	}

	private static void solve() {

		q = new LinkedList();
		
		q.add(start);
		
		while(!q.isEmpty()) {
			
			Dot d = q.poll();
			
			int curX = d.x;
			int curY = d.y;
			int curR = d.r;
			
			for (int i = 0 ; i < 6; i++) {
				
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				int nr = curR + dr[i];
				
				if (nx < 0 || ny < 0 || nr < 0 || nx >= c || ny >= r || nr >= l) continue;
				
				if (map[nr][ny][nx] == '#' || dist[nr][ny][nx] != 0) continue;
				
				q.add(new Dot(nx,ny,nr));
				dist[nr][ny][nx] = dist[curR][curY][curX] + 1;
			}
			
		}
		
	}
}
