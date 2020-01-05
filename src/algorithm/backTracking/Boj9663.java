package algorithm.backTracking;

import java.util.Scanner;

public class Boj9663 {
	private static int N,ans;
	private static int[] col;
	
	private static void DFS(int row) {
		
		if (row == N) {
			ans++;
		} else {
			for (int i = 1; i <= N; i++) {
				
				col[row+i] = i;
				
				if (isPossible(row+1)) {
					DFS(row+1);
				} else {
					col[row+i] = 0;
				}
			}
		}
		
		col[row] = 0;
	}
	
	private static boolean isPossible(int c) {
		
		for (int i = 0 ;i < c; i++) {
			
			if (col[i] == col[c]) return false;
			
			if (Math.abs(col[i]-col[c]) == Math.abs(i-c)) return false;
		}
		
		return true;
	}

	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		col = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			col[1] = i;
			DFS(1);
		}
		
		System.out.println(ans);
	}
		
}
