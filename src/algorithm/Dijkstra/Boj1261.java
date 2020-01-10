package algorithm.Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj1261 {
	private static int n,m;
	private static int[][] map;
	private static int[][] dist;
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {1,-1,0,0};
	private static int INF;
	private static PriorityQueue<Dot> pq;
	
	private static class Dot implements Comparable<Dot>{
		private int x;
		private int y;
		private int dist;
		
		public Dot(int x,int y,int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
					
		}

		@Override
		public int compareTo(Dot o) {
			
			return this.dist < o.dist ? -1 : 1;
		} 
		
	}
	
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		INF = Integer.MAX_VALUE;
		map = new int[n][m];
		dist = new int[n][m];
		
		for (int i = 0 ; i < n; i++) {
			
			String str = sc.next();
			Arrays.fill(dist, false); 
			
			for (int j = 0 ; j < m; j++) {
				
				map[i][j] = str.charAt(j);
			}
		}
		
		pq = new PriorityQueue();
		
		Dijkstra();
	}


	private static void Dijkstra() {
		
		pq.add(new Dot(1,1,0));
		
		dist[0][0] = 0;
		
		while(!pq.isEmpty()) {
			
			Dot dot = pq.poll();
			
			if (dot.y == n-1 && dot.x == m-1) {
				
				System.out.println(dot.dist);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				
				int nx = dot.x + dx[i];
				int ny = dot.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n-1 || ny >= m-1) return;
				
				if (dist[ny][nx] > dist[dot.y][dot.x] + map[ny][nx]) {
					dist[ny][nx] = dist[dot.y][dot.x] + map[ny][nx];
					pq.add(new Dot(nx,ny,dist[ny][nx]));
					
				}
			}
		}
		
	}
}
