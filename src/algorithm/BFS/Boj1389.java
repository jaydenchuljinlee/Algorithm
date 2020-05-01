package algorithm.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1389 {
	private static int n,m;
	private static int[][] map;
	private static int min = Integer.MAX_VALUE;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) Arrays.fill(map, -1);
		
		for (int i = 0; i < m; i++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		for (int i = 1; i <=n; i++) BFS(i);
		
		System.out.println(min);
	}

	private static void BFS(int start) {
		
		Queue<Integer> list = new LinkedList();
		
		list.offer(start);
		
		map[start][start] = 0;
		
		while(!list.isEmpty()) {
			
			int cur = list.poll();
			
			for (int i = 1; i <= n; i++) {
				
				if (map[start][i] >=0 ) {
					
					map[start][i] = map[start][cur]+1;
					list.offer(i);
				}
			}
		}
		
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += map[start][i];
		}
		
		min = Math.min(sum, min);
	}
}
