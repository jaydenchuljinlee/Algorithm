package algorithm.DP;

import java.util.Scanner;

public class Boj1932 {
	private static int n;
	private static int[][] dp;
	private static int max = 0;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		sc.nextLine();
		
		dp = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			
			String[] str = sc.nextLine().split(" ");
			
			for (int j = 0; j <= i; j++) {
				
				dp[i][j] = Integer.parseInt(str[j]);
				
				if (j == 0) dp[i][j] = dp[i-1][j] + dp[i][j];
				else if (i == j) dp[i][j] = dp[i-1][j-1] + dp[i][j];
				else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + dp[i][j];
				
				if (max < dp[i][j]) max = dp[i][j];
			}
			
			System.out.println(max);
			
			
		}
	}
}
