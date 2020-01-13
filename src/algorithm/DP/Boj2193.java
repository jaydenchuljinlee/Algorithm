package algorithm.DP;

import java.util.Scanner;

public class Boj2193 {
	private static int n;
	private static int[] dp;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		dp = new int[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		
		for (int i = 3; i <= n; i++) {
			
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[n]);
	}
}
