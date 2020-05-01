package algorithm.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj14502 {
	private static int n,m;
	private static int[][] map,copy;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static ArrayList<Dot> virus;
	private static int max = 0;
	
	private static class Dot {
		int x;
		int y;
		
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		map		= new int[n][m];
		copy	= new int[n][m];
		
		virus = new ArrayList(); 
		
		for (int i = 0; i < n; i++) {
			
			String[] str = sc.nextLine().split(" ");
			
			for (int j = 0; j < m; j++) {
				
				map[i][j] = Integer.parseInt(str[j]);
				
				if (map[i][j] == 2) virus.add(new Dot(j,i));
			}
		}
		
		DFS(0,0);
		System.out.println(max);
	}

	private static void DFS(int start, int depth) {

		if (depth == 3) {
			
			copyMap();
			
			for (Dot d : virus) {
				spreadVirus(d.x,d.y);
			}
			
			fineSafeArea();
			return;
		}
		
		for (int i = start; i < n*m; i++) {
			
			int nx = i%m;
			int ny = i/m;
			
			if (map[ny][nx] == 0) {
				map[ny][nx] = 1;
				DFS(start+1,depth+1);
				map[ny][nx] = 0;
			}
		}
		
	}

	private static void copyMap() {

		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < m; j++) {
				
				copy[i][j] = map[i][j];
			}
		}
		
	}

	private static void fineSafeArea() {

		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < m; j++) {
				
				if (copy[i][j] == 0) cnt++;
			}
		}
		
		max = Math.max(max, cnt);
	}

	private static void spreadVirus(int x, int y) {
		
		for (int i =0; i < 4; i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
			
			if (copy[ny][nx] == 0) {
				
				copy[ny][nx] = 2;
				spreadVirus(nx,ny);
			}
			
			
		}
		
	}
}
