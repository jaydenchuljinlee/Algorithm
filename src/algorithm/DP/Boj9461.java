package algorithm.DP;

import java.util.Scanner;

public class Boj9461 {
	private static int n,test;
	private static int[] dp;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		test = sc.nextInt();
		
		for (int testCase = 0; testCase < test; testCase++) {
			
			n = sc.nextInt();
			
			dp = new int[n+1];
			
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;
			dp[5] = 2;
			
			for (int i = 6; i <= n; i++) {
				
				dp[i] = dp[i-5] + dp[i-1];
			}
			
			System.out.println(dp[n]);
		}
		
		
		
		
	}
}
