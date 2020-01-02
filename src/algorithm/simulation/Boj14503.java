package algorithm.simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj14503 {
	private static int[][] map;
	private static int N;
	private static int M;
	private static int direction;
	private static int[] mx = {-1,0,1,0};
	private static int[] my = {0,1,0,-1};
	private static int cnt=0;
	
	private static class Dot {
		private int x;
		private int y;
		private int dir;
		
		Dot(int x, int y,int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		Dot dot = new Dot(sc.nextInt(),sc.nextInt(),sc.nextInt());
		
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < M; j++) map[i][j] = sc.nextInt();
		}
		
		search(dot);
		check();
	}

	private static void check() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if (map[i][j] == 9) cnt++;
			}
		}
		
	}

	private static void search(Dot dot) {
		
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(dot);
		map[dot.x][dot.y] = 9;
		
		while(!q.isEmpty()) {
			
			Dot temp = q.poll();
			int cur_x = temp.x;
			int cur_y = temp.y;
			int cur_d = temp.dir;
			boolean flags = false;
			int next_x;
			int next_y;
			int next_d;
			
			for (int i = 0; i < 4; i++) {
				
				next_d = (cur_d+3)%4;
				next_x = dot.x + mx[direction];
				next_y = dot.y + my[direction];
				
				Dot next = new Dot(next_x,next_y,next_d);
				
				if (next_x<0 || next_y<0 || next_x>=N || next_y>=M) continue;
				
				if (map[next_x][next_y] == 0) {
					q.add(next);
					map[next_x][next_y] = 9;
					flags = true;
					break;
				}
			}
			
			if (!flags) {
				
				next_d = (cur_d+2)%4;
				next_x = dot.x + mx[direction];
				next_y = dot.y + my[direction];
				
				if (map[next_x][next_y] != 1) {
					map[next_x][next_y] = 9;
					q.add(new Dot(next_x,next_y,next_d));
					
				} 
				
			}
		}
	}


}
