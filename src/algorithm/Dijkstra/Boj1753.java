package algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Boj1753 {
	private static int V,E,K;
	private static List<List<Dot>> list;
	private static int[] dist;
	private static final int INF = 987654321;
	
	private static class Dot {
		private int v;
		private int w;
		
		public Dot(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	private static void solution() throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		V = reader.read();
		E = reader.read();
		K = reader.read();
		
		list = new ArrayList<List<Dot>>();
		
		dist= new int[V+1];
		
		Arrays.fill(dist, INF);
		
		for (int i = 0; i < V; i++) {
			
			list.add(new ArrayList<Dot>());
		}
		
		for (int i = 0; i < E; i++) {
			
			String[] str = reader.readLine().split(" ");
			
			Dot dot = new Dot(Integer.parseInt(str[1]),Integer.parseInt(str[2]));
			
			list.get(Integer.parseInt(str[0])).add(dot);
		}
		
		dijkstra(K);
		
	}

	private static void dijkstra(int start) {

		boolean[] visited = new boolean[V+1];
		PriorityQueue<Dot> q = new PriorityQueue<Dot>();
		
		dist[start] = 0;
		q.add(new Dot(start,0));
		
		while(!q.isEmpty()) {
			int now = q.poll().v;
			
			if (visited[now]) continue;
			
			visited[now] = true;
			
			for(Dot node : list.get(now)) {
				
				if (dist[node.v] > dist[now]+node.w) {
					
					dist[node.v] = dist[now]+node.w;
					q.add(new Dot(node.v,dist[node.v]));
				}
			}
		}
	}
}
