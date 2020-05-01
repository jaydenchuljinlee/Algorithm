package algorithm.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2644 {
	private static int n,m,x,y;
	private static int[][] arr;
	private static boolean[] visited;
	private static int[] total;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n][2];
		visited = new boolean[n];
		total = new int[n];
		
		x = sc.nextInt();
		y = sc.nextInt();
		
		m = sc.nextInt();
		
		for (int i = 0; i < m; i++) {
			
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		System.out.println(bfs(x));
		
	}

	private static int bfs(int x) {

		Queue<Integer> q = new LinkedList();
		
		
		q.offer(x);
		
		while(!q.isEmpty()) {
			
			int temp = q.poll();
			
			visited[temp] = true;
			
			for (int i = 0; i < n; i++) {
				
				if (arr[i][0] == temp && !visited[arr[i][0]]) {
					
					q.offer(arr[i][0]);
					total[arr[i][1]] = total[arr[i][0]] +1;
				} else if (arr[i][1] == temp && !visited[arr[i][1]]) {
					
					q.offer(arr[i][1]);
					total[arr[i][0]] = total[arr[i][1]] +1;
				}
			}
			
			if (!q.isEmpty() || q.peek() == y) {
				return total[y];
			}
			
		}
		
		return -1;
	}
}
