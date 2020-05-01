package algorithm.bruteForce;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj15683 {
	private static int n,m;
	private static int[][] map,temp;
	private static ArrayList<Dot> list = new ArrayList();
	private static int[] output;
	private static int result,count,size;
	
	private static class Dot {
		int x;
		int y;
		
		public Dot (int x, int y) {
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
		temp	= new int[n][m];
		
		for (int i = 0; i < n; i++) {
			
			String[] str = sc.next().split(" ");
			
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str[j]); 
				temp[i][j] = map[i][j];
				if (map[i][j] != 6 && map[i][j] != 0) list.add(new Dot(j,i));
				
			}
		}
		
		size = list.size();
		output = new int[size]; 
		
		if (size == 0) {
			check();
			result = count;
		} else {
			
			for (int i = 0; i < 4; i++) {
				
				output[0] = i;
				allCase(i,0);
			}
		}
		
	}

	private static void allCase(int start, int depth) {

		if (depth == size-1) {
			
			for (int i = 0; i < size; i++) {
				
				Dot d = list.get(i);
				
				watch(d,map[d.y][d.x],output[i]);
			}
			
			check();
			
			result = Math.min(count, result);
			reset();
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			
			output[depth+1] = i;
			allCase(i,depth+1);
		}
		
	}

	private static void reset() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				
				map[i][j] = temp[i][j];
			}
			
		}
		
	}

	private static void check() {

		count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) count++;
			}
		}
		
	}

	private static void watch(Dot d, int cctv, int dir) {

		if (cctv == 1) {
			
			if (dir == 0) {
				move(d,0);
			} else if (dir == 1) {
				move(d,1);
			} else if (dir == 2) {
				move(d,2);
			} else if (dir == 3) {
				move(d,3);
			}
			
		} else if (cctv == 2) {
			if (dir == 0) {
				move(d,0);
				move(d,2);
			} else if (dir == 1) {
				move(d,1);
				move(d,3);
			} else if (dir == 2) {
				move(d,2);
				move(d,0);
			} else if (dir == 3) {
				move(d,3);
				move(d,1);
			}
		} else if (cctv == 3) {
			
			if (dir == 0) {
				move(d,0);
				move(d,1);
			} else if (dir == 1) {
				move(d,1);
				move(d,2);
			} else if (dir == 2) {
				move(d,2);
				move(d,3);
			} else if (dir == 3) {
				move(d,3);
				move(d,0);
			}
		} else if (cctv == 4) {
			
			if (dir == 0) {
				move(d,0);
				move(d,1);
				move(d,2);
			} else if (dir == 1) {
				move(d,1);
				move(d,2);
				move(d,3);
			} else if (dir == 2) {
				move(d,2);
				move(d,3);
				move(d,1);
			} else if (dir == 3) {
				move(d,3);
				move(d,0);
				move(d,1);
			}
		} else if (cctv == 5) {
			move(d,0);
			move(d,1);
			move(d,2);
			move(d,3);
		}
		
	}

	private static void move(Dot d, int dir) {

		int curx = d.x;
		int cury = d.y;
		
		int nx = curx;
		int ny = cury;
		
		if (dir == 0) {
			nx = curx -1;
			ny = cury;
		} else if (dir == 1) {
			nx = curx;
			ny = cury + 1;
		} else if (dir == 2) {
			nx = curx+1;
			ny = cury;
		} else if (dir == 3) {
			nx = curx;
			ny = cury - 1;
		} 
		
		if (nx < 0 || ny < 0 || nx >= m || ny >= n) return;
		
		if (map[ny][nx] == 6) return;
		
		if (map[ny][nx] == 0) {
			map[ny][nx] = 1;
		}
		
		move(new Dot(nx,ny),dir);
		
	}
}
