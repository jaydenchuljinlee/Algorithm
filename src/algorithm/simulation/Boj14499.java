package algorithm.simulation;

import java.util.Scanner;

public class Boj14499 {
	private static int N,M,x,y,k;
	private static int[][] map;
	private static int[] dir;
	private static int[] mx = {1,-1,0,0};
	private static int[] my = {0,0,1,-1};

	private static class Dice {
		private int top = 0;
		private int bottom = 0;
		private int east = 0;
		private int west = 0;
		private int south = 0;
		private int north = 0;
		
		public void moveEast() {
			int temp = east;
			east = top;
			top = west;
			west = bottom;
			bottom = temp;
		}
		
		public void moveWest() {
			int temp = west;
			west = top;
			top = east;
			east = bottom;
			bottom = temp;
		}
		
		public void moveSouth() {
			int temp = south;
			south = top;
			top = north;
			north = bottom;
			bottom = temp;
		}
		
		public void moveNorth() {
			int temp = north;
			north = top;
			top = south;
			south = bottom;
			bottom = temp;
		}
		
		public void printTopNumber() {
			
			System.out.println(top);
		}
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		k = sc.nextInt();
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < M; j++) {
				
				map[i][j] = sc.nextInt();
			}
		}
		
		dir = new int[k];
		
		for (int i = 0; i < k; i++) dir[i] = sc.nextInt();
		
		Dice dice = new Dice();
		
		int next_x = x;
		int next_y = y;
		
		for (int i = 0; i < k; i++) {
			
			next_x += + mx[dir[k]-1];
			next_y += + my[dir[k]-1];
			
			if (next_x >=0 && next_y >=0 && next_x < N && next_y <M) {
				
				switch(dir[k]) {
				
					case 1 :
						dice.moveEast();
						break;
					case 2 :
						dice.moveWest();
						break;
					case 3 :
						dice.moveNorth();
						break;
					case 4 :
						dice.moveSouth();
						break;
				}
			}
			
			if (map[next_x][next_y] == 0) {
				map[next_x][next_y] = dice.bottom;
			} else {
				dice.bottom = map[next_x][next_y];
				map[next_x][next_y] = 0;
			}
			
			dice.printTopNumber();
			
		}
		
		
	}
}
