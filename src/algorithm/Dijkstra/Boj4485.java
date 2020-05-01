package algorithm.Dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj4485 {
	private static int n;
	private static int[][] map;
	private static int[][] dist;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static int min;
	private static int INF = Integer.MAX_VALUE;
	
	private static class Dot implements Comparable<Dot>{
		int x;
		int y;
		int cost;
		
		public Dot(int x,int y, int cost) {
			this.x		= x;
			this.y		= y;
			this.cost	= cost;
		}

		@Override
		public int compareTo(Dot o) {
			
			return this.cost - o.cost;
		}
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		int testCase = 1;
		while(true) {
			
			n = sc.nextInt();
			sc.nextLine();
			
			if (n == 0) break;
			
			map		= new int[n][n];
			dist	= new int[n][n];
			min		= Integer.MAX_VALUE;
			
			for (int i = 0; i < n; i ++) {
				
				String[] str= sc.nextLine().split(" ");
				
				for (int j = 0 ; j < n; j++) {
					
					map[i][j] = Integer.parseInt(str[j]);
					dist[i][j] = INF;
				}
			}
			
			solve();
			
			System.out.println("Problem "+testCase+": "+dist[n-1][n-1]);
			
			testCase++;
		}
	}

	private static void solve() {

		PriorityQueue<Dot> pq = new PriorityQueue();
		
		pq.add(new Dot(0,0,map[0][0]));
		dist[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			
			Dot d = pq.poll();
			
			int curX	= d.x;
			int curY	= d.y;
			int curCost	= d.cost;
			
			if (dist[curY][curX] < curCost) continue;
			
			for (int i = 0; i < 4; i++) {
				
				int nx = curX +dx[i];
				int ny = curY +dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
				
				if (dist[ny][nx] > dist[curY][curX] + map[ny][nx]) {
					dist[ny][nx] = dist[curY][curX] + map[ny][nx];
					pq.add(new Dot(nx,ny,dist[ny][nx]));
				}
			}
			
		}
	}
}
