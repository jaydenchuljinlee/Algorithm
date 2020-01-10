package algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Boj1916 {
	private static int N,M,start,end;
	private static int[][] map;
	private static int[] dist;
	private static int INF = 100000;
	
	
	public static void solution() throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		N = reader.read();
		M = reader.read();
		
		map = new int[N][N];
		
		Arrays.fill(dist, INF);
		
		for (int i = 0; i < M; i++) {
			
			Arrays.fill(map[i], INF);
		}

		for (int i = 0; i < M; i++) {
			
			String[] str = reader.readLine().split(" ");
			
			int from	= Integer.parseInt(str[0])-1;
			int to		= Integer.parseInt(str[1])-1;
			int price	= Integer.parseInt(str[2])-1;
			
			if (map[from][to] > price) {
				map[from][to] = price;
			}
		}
		
		start	= reader.read()-1;
		end		= reader.read()-1;
		
		Dijkstra();
	}

	private static void Dijkstra() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(start);
		
		map[start][start] = 0;
		dist[start] = 0;
		
		int i,before;
		
		while(!pq.isEmpty()) {
			
			before = pq.poll();
			
			for (i = 0; i < N; i++) {
				
				if (dist[i] > map[before][i] + dist[before]) {
					dist[i] = map[before][i] + dist[before];
					pq.offer(i);
				}
			}
		}
	}
}
