package algorithm.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Boj2211 {
	private static int n,m;
	private static ArrayList<Dot>[] vertextList;
	private static int[] dist;
	private static List<Integer>[] result;
	
	private static class Dot {
		int pos;
		int dist;
		
		public Dot (int pos, int dist) {
			this.pos 	= pos;
			this.dist	= dist;
		}
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		vertextList = new ArrayList[n];
		result		= new ArrayList[n];
		dist		= new int[n];
		
		for (int i = 0; i < n; i++) {
			
			vertextList[i]	= new ArrayList();
			result[i]		= new ArrayList();
			dist[i]			= Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < m; i++) {
			
			int u		= sc.nextInt() -1;
			int v		= sc.nextInt() -1;
			int dist	= sc.nextInt();
			
			vertextList[u].add(new Dot(v,dist));
			vertextList[v].add(new Dot(u,dist));
		}
		
		dijkstra();
		findLan();
	}

	private static void findLan() {
		
		boolean[] visited = new boolean[n];
		ArrayList<String> rtnList = new ArrayList<String>(); 
		
		Arrays.fill(visited, false);
		
		int cnt	= 0;
		int min = 0;
		
		while(true) {

			if (cnt == n-1) break;
			
			for (int i = 1; i < n; i++) {
				
				if (!visited[i]) {
					min = i;
					break;
				}
			}
			
			for (int i = 1; i < n; i++) {
				
				if (dist[min] > dist[i] && !visited[i]) {
					
					min = i;
				}
			}
			
			visited[min] = true; 
			
			int u = result[min].get(result[min].size()-1);
			
			String str = (min+1) + " " + (u+1) + " ";
			
			rtnList.add(str);
			
			cnt++;
			
		}
		
		System.out.println(cnt);
		
		for (String str : rtnList) {
			System.out.println(str);
		}
		
	}

	private static void dijkstra() {

		Queue<Dot> q = new LinkedList();
		
		q.add(new Dot(0,dist[0]=0));
		
		while(!q.isEmpty()) {
			
			Dot d = q.poll();
			
			int curPos	= d.pos;
			int curDist	= d.dist;
			
			for (Dot next : vertextList[curPos]) {
				
				if (dist[next.pos] <= next.dist + curDist) continue;
				
				q.add(new Dot(next.pos,dist[next.pos]= next.dist + curDist));
				result[next.pos].add(curPos);
			}
		}
	}
}
