package algorithm.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj7562 {
	private static int test,n;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = {-2,-1,2,1,2,1,-2,-1};
	private static int[] dy = {1,2,1,2,-1,-2,-1,-2};
	private static int start_x,start_y,end_x,end_y;
	
	private static class Dot {
		int x;
		int y;
		
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		test = sc.nextInt();
		
		for (int i = 0; i < test; i++) {
			
			n = sc.nextInt();
			start_x = sc.nextInt();
			start_y = sc.nextInt();
			end_x	= sc.nextInt();
			end_x	= sc.nextInt();
			
			map = new int[n][n];
			visited = new boolean[n][n];
			
			bfs(new Dot(start_x,start_y));
			System.out.println(map[end_x-1][end_y-1]);
		}
	}


	private static void bfs(Dot d) {
		
		Queue<Dot> list = new LinkedList();
		
		if (d.x == end_x && d.y == end_y ) {
			
			return;
		}
		
		list.offer(d);
		
		visited[start_x][start_y] = true;
		
		while(!list.isEmpty()) {
			
			Dot temp = list.poll();
			
			int nx;
			int ny;
			
			for (int i = 0; i < dx.length; i++) {
				nx = d.x+dx[i];
				ny = d.y+dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) continue;
				
				list.offer(new Dot(nx,ny));
				map[nx][ny] = map[d.x][d.y]+1;
				visited[nx][ny] = true;
				
			}
		}
	}
}
