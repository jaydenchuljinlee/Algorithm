package algorithm.backTracking;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1987 {
	private static int R,C;
	private static char[][] map;
	private static boolean[] visited = new boolean[26];
	private static int[] dx = {-1,0,1,0};
	private static int[] dy = {0,-1,0,1};
	private static int answer = 1;
	private static int cnt = 1;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		for (int i = 0; i < R; i++) {
			
			String row = sc.next();
			
			for (int j = 0; j < C; j++) {
				
				map[i][j] =(char)(row.charAt(j) -'A');
			}
		}
		
		Arrays.fill(visited, false);
		
		DFS(0,0);
		
		System.out.println(answer);
	}


	private static void DFS(int x, int y) {
		
		int idx = map[x][y];
		
		visited[idx] = true;
		
		int next_x;
		int next_y;
		
		for (int i = 0; i < 4; i++) {
			
			next_x = dx[i] + x; 
			next_y = dy[i] + y; 
			
			if (next_x < 0 || next_y < 0 || next_x >= R || next_y >= C) return;
			
			int next = map[next_x][next_y];
			
			if (!visited[next]) {
				answer = Math.max(answer, ++cnt);
				DFS(next_x,next_y);
			}
		}
		
		cnt--;
		visited[idx] = false;
	}
}
