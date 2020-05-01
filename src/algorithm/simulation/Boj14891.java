package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14891 {
	private static int k,ans=0;
	private static int[][] gear = new int[4][8];
	
	public static void solution() throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			String str = reader.readLine();
			
			for (int j = 0; j < 8; j++) {
				gear[i][j] = str.charAt(j) - '0';
				
			}
		}
		
		k = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < k; i++) {
			
			String[] how = reader.readLine().split(" ");
 			
			int idx = Integer.parseInt(how[0]);
			int dir = Integer.parseInt(how[1]);
			
			solve(idx-1,dir);
		}
		
		for (int i = 0; i < 4; i++) {
			ans += gear[i][0] * 1<<i;
		}
		
		System.out.println(ans);
	}

	private static void solve(int idx, int dir) {
		
		left(idx-1,-dir);
		right(idx+1,-dir);
		rotate(idx,dir);
		
	}

	private static void rotate(int idx, int dir) {

		if (dir == 1) {
			
			int temp = gear[idx][7];
			
			for (int i = 7; i > 0; i--) {
				
				gear[idx][i] = gear[idx][i-1];
			}
			
			gear[idx][0] = temp;
			
		} else {
			
			int temp = gear[idx][0];
			
			for (int i = 0; i < 7; i++) {
				gear[idx][i] = gear[idx][i+1];
			}
			
			gear[idx][7] = temp;
		}
		
	}

	private static void right(int idx, int dir) {

		if (idx > 3) return;
		
		if (gear[idx][6] != gear[idx-1][2]) {
			right(idx+1,-dir);
			rotate(idx,dir);
		}
		
	}

	private static void left(int idx, int dir) {

		if (idx < 0) return;
		
		if (gear[idx][2] != gear[idx+1][6]) {
			left(idx-1,-dir);
			rotate(idx,dir);
		}
	}
}
