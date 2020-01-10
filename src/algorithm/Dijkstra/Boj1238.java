package algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Boj1238 {
	private static int N,M,X;
	private static List<List<Node>> list,revList;
	private static int[] dist,revDist;
	private static int INF = 100;
	
	private static class Node {
		private int index;
		private int weight;
		
		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
	}
	
	public static void solution() throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		N = reader.read();
		X = reader.read();
		M = reader.read();
		
		Arrays.fill(dist, 100);
		Arrays.fill(revDist, 100);
		
		list = new ArrayList();
		revList = new ArrayList();
		for (int i = 0; i < N; i++) {
			
			list.add(new ArrayList<Node>());
			revList.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < M; i++) {
			
			String[] str = reader.readLine().split(" ");
			
			list.get(Integer.parseInt(str[0])).add(new Node(Integer.parseInt(str[1]),Integer.parseInt(str[2])));
			revList.get(Integer.parseInt(str[1])).add(new Node(Integer.parseInt(str[0]),Integer.parseInt(str[2])));
		}
		
		//X번 마을에서 각 마을로 돌아가는 최단 경로
		Dijkstra(list,dist,X);
		
		//각 마을에서 X번 마을로 돌아가는 최단 경로
		Dijkstra(revList,dist,X);
		
	}

	private static void Dijkstra(List<List<Node>> list, int[] distance, int start) {
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		distance[start] = 0;
		visited[start] = true;
		
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			
			int now = pq.poll().index;
			
			if (visited[now]) continue;
			
			visited[now] = true;
			
			for (Node node : list.get(now)) {
				
				if (distance[node.index] > distance[now] + node.weight) {
					distance[node.index] = distance[now] + node.weight;
					
					pq.offer(new Node(node.index,distance[node.index]));
				}
			}
		}
		
	}
}
