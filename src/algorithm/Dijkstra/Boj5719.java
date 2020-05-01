package algorithm.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Boj5719 {
	private static int n,m;
	private static int start,end;
	private static int[][] map;
	private static int[] dist;
	private static List<Integer>[] list;
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
		
		while(true) {
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			if (n == 0 && m == 0) break;
			
			start = sc.nextInt();
			end = sc.nextInt();
			
			map = new int[n][n];
			dist = new int[n];
			list = new ArrayList[n];
			
			for (int i = 0; i < n; i++) {
				dist[i] = INF;
				Arrays.fill(map[i], -1);
				list[i] = new ArrayList();
			}
			
			for (int i = 0; i < m; i++) {
				
				int u = sc.nextInt();
				int v = sc.nextInt();
				int p = sc.nextInt();
				
				map[u][v] = p;
				
			}
			
			dijkstra();
			traceBack();
			Arrays.fill(dist, INF);
			System.out.println(dijkstra());
			
		}
	}

	private static void traceBack() {

		Queue<Integer> q = new LinkedList();
		
		q.add(end);
		
		while(!q.isEmpty()) {
			
			int cur = q.poll();
			
			for (int prev : list[cur]) {
				
				if (map[prev][cur] == -1 || dist[cur] != map[prev][cur] + dist[prev]) continue;
				
				q.add(prev);
				map[prev][cur] = -1;
			}
		}
	}

	private static int dijkstra() {

		PriorityQueue<Dot> q = new PriorityQueue<>(Comparator.comparingInt(e1 -> e1.pos));
		
		q.add(new Dot(start,dist[start] = 0));
		
		while(!q.isEmpty()) {
			
			Dot d = q.poll();
			
			int curPos	= d.pos;
			int curDist	= d.dist;
			
			for (int i = 0; i < n; i++) {
				
				if (map[curPos][i] == -1 || dist[i] < curDist + map[curPos][i]) continue;
				
				q.add(new Dot(i,dist[i] = curDist + map[curPos][i]));
				
				list[i].add(curPos);
			}
		}
		
		return dist[end] >= INF ? -1 : dist[end];
	}

	
}
