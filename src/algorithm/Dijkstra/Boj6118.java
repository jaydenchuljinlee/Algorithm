package algorithm.Dijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj6118 {
	private static int n,m;
	private static int[][] map;
	private static int[] dist;
	private static int first,distance,same;
	private static final int INF = Integer.MAX_VALUE;
	
	private static class Dot {
		int pos;
		int dist;
		
		public Dot(int pos, int dist) {
			this.pos	= pos;
			this.dist	= dist; 
		}
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map		= new int[n][n];
		dist	= new int[n];
		
		Arrays.fill(dist, INF);
		
		for (int i = 0; i < m; i++) {
			
			int u = sc.nextInt() -1;
			int v = sc.nextInt() -1;
			
			map[u][v] = 1;
			map[v][u] = 1;
		}
		
		dijkstra();
		
		first = 1;
		distance = dist[0];
		same = 1;
		
		for (int i = 1; i < n; i++) {
			
			if (distance < dist[i]) {
				first = i+1;
				distance = dist[i];
				same = 1;
			} else if (distance == dist[i]) {
				same++;
			}
		}
		
		System.out.println(first + " " + distance + " " + same);
	}

	private static void dijkstra() {

		Queue<Dot> q = new LinkedList();
		
		q.add(new Dot(0,dist[0]=0));
		
		while(!q.isEmpty()) {
			
			Dot d = q.poll();
			
			int curPos	= d.pos;
			int curDist	= d.dist;
			
			for (int i = 0; i < n; i++) {
				
				if (map[curPos][i] == 0 || dist[i] <= curDist + map[curPos][i]) continue;
				
				q.add(new Dot(i, dist[i] = curDist + map[curPos][i]));
				
			}
		}
		
	}
}
