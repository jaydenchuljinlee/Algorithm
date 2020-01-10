package algorithm.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj14502 {
	private static int n,m;
	private static int[][] map,copy;
	private static List<Dot> virusList;
	private static int max = 0;
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {1,-1,0,0};
	
	private static class Dot {
		int x;
		int y;
		
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		} 
		
	}
	
	
	private static void solution() throws IOException{
		
		BufferedReader reader	= new BufferedReader(new InputStreamReader(System.in));
		
		n = reader.read();
		m = reader.read();
		
		map		= new int[n][m];
		copy	= new int[n][m];
		virusList = new ArrayList();
		
		for (int i = 0; i < n; i++) {
			
			String[] str = reader.readLine().split(" ");
			
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				
				if (map[i][j] == 2) {
					virusList.add(new Dot(i,j));
				}
			}
		}
		
		setWall(0,0);
		System.out.println(max);
	}


	private static void setWall(int start, int depth) {
		
		if (depth == 3) {
			
			copyMap();
			
			for (Dot d : virusList) {
				
				spreadVirus(d.x,d.y);
			}
			
			max = Math.max(max, getSafeArea());
			return;
		}
		
		
		for (int i = start; i <n*m; i++) {
			
			int nx = i/m;
			int ny = i%m;
			
			if (map[nx][ny] == 0) {
				
				map[nx][ny] = 1;
				setWall(start+1,depth+1);
				map[nx][ny] = 0;
			}
		}
	}


	private static int getSafeArea() {
		int sum = 0;
		for (int i = 0 ; i < n; i++) {
			
			for (int j =0; j < m; j++) {
				
				if (copy[i][j] == 0) sum++;
			}
		}
		
		return sum;
	}


	private static void spreadVirus(int x, int y) {

		for (int i=0; i < 4; i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			
			if (copy[nx][ny] == 0) {
				copy[nx][ny] = 2;
				spreadVirus(nx,ny);
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
}
