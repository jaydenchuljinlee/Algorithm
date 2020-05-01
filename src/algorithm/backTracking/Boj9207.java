package algorithm.backTracking;

import java.util.Scanner;

public class Boj9207 {
	private static int test;
	private static char[][] map;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static int min,cnt;
	private static final int INF = Integer.MAX_VALUE;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		test = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < test; i++) {
			
			map	= new char[9][5];
			
			for (int j = 0; j < 5; j++) {
				
				String str = sc.nextLine();
				
				for (int k = 0; k < 9; k++) {
					
					map[k][j] = str.charAt(k);
					
				}
			}
			
			min = INF;
			cnt = 0;
			
			solve(map,0);
			System.out.println(min + " " + cnt);
			sc.nextLine();
		}
	}

	private static void solve(char [][] newMap,int depth) {
		
		int pin = 0;
		
		for (int i = 0; i < 9; i++) {
			
			for (int j = 0; j < 5; j++) {
				
				if (newMap[i][j] == 'o') pin++;
			}
		}
		
		if (min > pin) {
			
			min = pin;
			cnt = depth;
		}
		
		for (int y = 0; y < 9; y++) {
			
			for (int x = 0; x < 5; x++) {
				
				if (newMap[y][x] == 'o') {
					
					for (int dir = 0; dir < 4; dir++) {
						
						int nx 	= x + dx[dir];
						int ny 	= y + dy[dir];
						int nnx	= x + (dx[dir]*2);
						int nny = y + (dy[dir]*2);
						
						if (nx < 0 || ny < 0 || nx >= 5 || ny >= 9) continue;
						if (nnx < 0 || nny < 0 || nnx >= 5 || nny >= 9) continue;
						
						if (newMap[ny][nx] == 'o' && newMap[nny][nnx] == '.') {
							
							newMap[nny][nnx]	= 'o';
							newMap[ny][nx]		= '.';
							newMap[y][x]	 	= '.';
							solve(newMap,depth+1);
							newMap[nny][nnx]	= '.';
							newMap[ny][nx]		= 'o';
							newMap[y][x]	 	= 'o';
						}
					}
				}
			}
		}
	}
}
