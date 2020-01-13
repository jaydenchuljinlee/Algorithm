package algorithm.DP;

import java.util.Scanner;

public class Boj11052 {
	private static int n;
	private static int[] a;
	private static int[] dp;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		a	= new int[n+1];
		dp 	= new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			
			a[i] = sc.nextInt();
		}
		
		dp[1] = a[1];
		
		for (int i = 2; i <= n; i++ ) {
			
			for (int j = 1; j <= n; j++) {
				
				dp[i] = Math.max(dp[i], dp[i-j]+a[j]);
			}
		}
		
		System.out.println(dp[n]);
	}
}
