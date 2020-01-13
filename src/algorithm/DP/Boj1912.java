package algorithm.DP;

import java.util.Scanner;

public class Boj1912 {
	private static int n;
	private static int[] a;
	private static int[] dp;
	private static int max;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		a = new int[n];
		
		for (int i = 0; i < n; i++) {
			
			a[i] = sc.nextInt();
		}
		
		dp[0] = a[0];
		
		max = dp[0];
		
		for (int i = 1; i < n; i++) {
			
			dp[i] = Math.max(dp[i-1]+a[i], a[i]);
			
			max = Math.max(dp[i], max);
		}
	}
}
