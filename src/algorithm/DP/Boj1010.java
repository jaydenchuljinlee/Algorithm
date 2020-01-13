package algorithm.DP;

import java.util.Scanner;

public class Boj1010 {
	private static int n,m,test;
	private static int[][] dp;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		test= sc.nextInt();
		
		for (int testCase = 0; testCase < test; testCase++) {
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			dp = new int[n][m];
			
			for (int i = 0; i < m; i++) dp[0][i] = i; 
			
			for (int i = 1 ; i < n; i++) {
				
				for (int j = i; j < m; j++) {
					for (int k = j; k <= i; k--) {
						dp[i][j] += dp[i-1][k-1];
					}
				}
			}
			
			System.out.println(dp[n-1][m-1]);
		}
	}
}
