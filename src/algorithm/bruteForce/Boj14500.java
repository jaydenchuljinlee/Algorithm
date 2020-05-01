package algorithm.bruteForce;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj14500 {
	private static int n,m;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static int max = 0;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		map		= new int[n][m];
		visited	= new boolean[n][m];	
		
		for (int i = 0; i < n; i++) {
			
			String[] str = sc.nextLine().split(" ");
			for (int j = 0; j < m; j++) {
				
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		sc.nextLine();
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < m; j++) {
				
				DFS(i,j,0,0);
				exception(i,j);
			}
		}
		
		System.out.println(max);
	}

	private static void exception(int y, int x) {

		int wing	= 4;
		int min		= Integer.MAX_VALUE;
		int sum 	= map[y][x];
		
		for (int i = 0; i < 4; i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (wing <= 2) return;
			
			if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
				wing--;
				continue;
			} 
			
			min = Math.min(min, map[ny][nx]);
			sum += map[ny][nx];
		}
		
		if (wing == 4) {
			sum -= min;
		}
		
		max = Math.max(max, sum);
		
	}

	private static void DFS(int y, int x, int cnt, int sum) {
		
		if (cnt == 4) {
			
			max = Math.max(max, sum);
			return;
		}
		
		for (int k = 0; k < 4; k++) {
			
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
			
			if (visited[ny][nx]) continue;
			
			visited[ny][nx] = true;
			DFS(ny,nx,cnt+1,sum+map[ny][nx]);
			visited[ny][nx] = false;
		}
	}
}
