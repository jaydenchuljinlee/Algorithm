package algorithm.DFS;

import java.util.Scanner;

public class Boj2468 {
	private static int n,water;
	private static int[][] map,copy;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static int min=Integer.MAX_VALUE,max=0;
	private static int result = 0;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		sc.nextLine();
		
		map		= new int[n][n];
		copy	= new int[n][n]; 
		
		for (int i = 0; i < n; i++) {
			
			String[] str = sc.nextLine().split(" ");
			
			for (int j = 0; j < n; j++) {
				
				map[i][j] = Integer.parseInt(str[j]);
				
				min = Math.min(min, map[i][j]);
				max = Math.max(max,map[i][j]);
			}
		}
		
		for (int i = min-1; i <= max; i++) {
			water = i;
			solve();
		}
		
		System.out.println(result);
		
	}

	private static void solve() {
		
		copyMap();
		
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0 ; j < n; j++) {
				
				if (copy[i][j] > water) {
					
					copy[i][j] = -1;
					sink(i,j);
					cnt++;
				}
			}
		}
		result = Math.max(result, cnt);
	}

	private static void sink(int y, int x) {
		
		
		for (int i = 0 ; i < 4; i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
			
			if (copy[ny][nx] <= water) continue;
			
			copy[ny][nx] = -1;
			sink(ny,nx);
			
		}
	}

	private static void copyMap() {

		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				
				copy[i][j] = map[i][j];
			}
		}
		
	}
}
