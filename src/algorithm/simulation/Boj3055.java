package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj3055 {
	private static int r,c;
	private static char[][] map;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static Queue<Dot> water = new LinkedList();
	private static Queue<Dot> move	= new LinkedList();
	private static int cnt = 0;
	
	private static class Dot {
		int x;
		int y;
		
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void solution() throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] procession = reader.readLine().split(" ");
		
		r = Integer.parseInt(procession[0]); 
		c = Integer.parseInt(procession[1]);
		
		map = new char[r][c];
		
		for (int i = 0; i < r; i++ ) {
			
			String str = reader.readLine();
			
			for (int j = 0; j < c; j++) {
				
				map[i][j] = str.charAt(j);
					
				if (map[i][j] == 'S') move.offer(new Dot(j,i));
				
				if (map[i][j] == '*') water.offer(new Dot(j,i));
				
			}
		}
		
		BFS();
		
		System.out.println(cnt);
	}

	private static void BFS() {

		while(true) {
			System.out.println("========================");
			for (int i = 0; i < r; i++ ) {
				
				for (int j = 0; j < c; j++) {
					
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
			
			cnt++;
			
			int water_len	= water.size();
			int move_len	= move.size();
			
			for (int i = 0; i < water_len; i++) {
				Dot d = water.poll();
				
				for (int j = 0; j < 4; j++) {
					int nx = d.x + dx[j];
					int ny = d.y + dy[j];
					
					if (nx >= 0 && ny >= 0 && ny < r && nx < c) {
					
						if (map[ny][nx] == '.') {
							map[ny][nx] = '*';
							water.offer(new Dot(nx,ny));
						}
					}
				}
			}
			
			if (move_len <= 0) {
				System.out.println("KAKTUS");
				System.exit(0);
			}
			
			for (int i = 0; i < move_len; i++) {
				
				Dot d = move.poll();
				
				for (int j = 0; j < 4; j++) {
					
					int nx = d.x + dx[j];
					int ny = d.y + dy[j];
					
					if (nx >= 0 && ny >= 0 && ny < r && nx < c) {
						
						if (map[ny][nx] == 'D') return;
						
						if (map[ny][nx] == '.') {
							
							map[ny][nx] = 'S';
							move.offer(new Dot(nx,ny));
						}
					}
					
				}
			}
		}
		
	}

	
}
