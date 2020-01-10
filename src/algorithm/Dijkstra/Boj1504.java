package algorithm.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj1504 {
	private static int N,E,M1,M2;
	private static List<List<Node>> list;
	private static int[] dist;
	private static boolean[] check;
	private static int INF = Integer.MAX_VALUE;
	
	private static class Node implements Comparable<Node>{
		private int index;
		private int weight;
		
		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			
			return this.weight < o.weight ? -1 : 1;
		}
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		E = sc.nextInt();
		sc.nextLine();
		dist = new int[N];
		check = new boolean[N];
		
		list = new ArrayList();
		
		for (int i = 0; i < N; i++) {
			
			list.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < E; i++) {
			
			String[] str = sc.nextLine().split(" ");
			
			list.get(Integer.parseInt(str[0])-1).add(new Node(Integer.parseInt(str[1])-1,Integer.parseInt(str[2])));
			list.get(Integer.parseInt(str[1])-1).add(new Node(Integer.parseInt(str[0])-1,Integer.parseInt(str[2])));
		}
		
		M1 = sc.nextInt();
		M2 = sc.nextInt();
		
		long sumM1ToM2 = sumDijkstra(0,M1-1,M2-1);
		long sumM2ToM1 = sumDijkstra(0,M2-1,M1-1);
		
		if (sumM1ToM2 == -1 && sumM2ToM1 == -1) {
			System.out.println(-1);
		} else if (sumM1ToM2 == -1) {
			System.out.println(sumM2ToM1);
		} else if (sumM2ToM1 == -1) {
			System.out.println(sumM2ToM1);
		} else {
			
			System.out.println((sumM1ToM2 <= sumM2ToM1) ? sumM1ToM2 : sumM2ToM1); 
		}
	}

	private static long sumDijkstra(int start, int m1, int m2) {

		System.out.println("==========================");
		long dist_1 = dijkstra(0,m1);
		long dist_2 = dijkstra(m1,m2);
		long dist_3 = dijkstra(m2,N-1);
		
		System.out.println("1_" + dist_1 + ", 2_" + dist_2 + ", 3_" +dist_3);
		
		System.out.println("==========================");
		
		return (dist_1 == INF || dist_2 == INF || dist_3 == INF) ? -1 : dist_1 + dist_2 + dist_3;
	}

	private static long dijkstra(int start, int end) {

		System.out.println("(" + start + ","+ end + ")");
		
		Arrays.fill(dist, INF);
		Arrays.fill(check, false);
		
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			
			int now = pq.poll().index;
			
			System.out.print(now + " ");
			
			if (now == end) {
				System.out.println("break");
				break;
			} 
			
			if (check[now]) continue;
			
			check[now] = true;
			
			for (Node node : list.get(now)) {
				
				if (dist[node.index] > dist[now] + node.weight) {
					dist[node.index] = dist[now] + node.weight;
					
					pq.offer(new Node(node.index,dist[node.index]));
				}
			}
		}
		
		return dist[end];
	}
}
