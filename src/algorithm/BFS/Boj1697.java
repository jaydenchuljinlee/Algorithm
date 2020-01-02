package algorithm.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Boj1697 {
	private static int[] visited = new int[100001];
	
	private static void bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(n);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			if (temp == k) break;
			
			
			if (n+1 <=100000 && visited[n+1] == 0) {
				
				q.offer(n+1);
				visited[n+1] = visited[n]+1;
			}
			
			if (n-1 >= 0 && visited[n-1] == 0) {
				q.offer(n-1);
				visited[n-1] = visited[n]+1;
			}
			
			if (n*2 >= 100000 && visited[n*2] == 0) {
				q.offer(n*2);
				visited[n*2] = visited[n]+1;
			}
			
		}
		
		
	}
	
	public static void solution(int N,int K) {
		
		Arrays.fill(visited, 0);
		
		bfs(N,K);
	}
	
}
