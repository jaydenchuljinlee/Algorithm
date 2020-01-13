package algorithm.DP;

import java.util.Scanner;

public class Boj11727 {
	private static int n;
	private static int[] dp;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		dp = new int[n];
		
		dp[0] = 1;
		dp[1] = 3;

		for (int i = 2; i < n; i++) {
			
			dp[n] = dp[n-1] + (dp[n-2]*2);
			dp[n] = dp[n]%10007;
		}
		
		System.out.println(dp[n-1]);
	}
}
