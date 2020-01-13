package algorithm.DP;

import java.util.Scanner;

public class Boj10844 {
	private static int n;
	private static long[][] dp;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		dp = new long[n][11];
		
		for (int i = 1; i<=9; i++) {
			dp[0][i] = 1;
		}
		
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i-1][1];
			for (int j = 1; j<=9; j++) {
				
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
			}
		}
		
		long sum = 0;
		
		for (int i = 0; i <= 9; i++) {
			
			sum += dp[n-1][i];
		}
		
		System.out.println(sum%1000000000);
	}
}
