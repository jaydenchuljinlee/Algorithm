package algorithm.DP;

import java.util.Scanner;

public class Boj2156 {
	private static int n;
	private static int[] a;
	private static int[] dp;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		a = new int[n];
		dp = new int[n];
		
		for (int i = 0; i < n; i++) {
			
			a[i] = sc.nextInt();
		}
		
		if (n == 1) {
			dp[n-1] = a[n-1];
		}
		
		if (n == 2) {
			
			dp[n-1] = a[n-2] + a[n-1];
		}
		
		if (n >= 3) {
			
			dp[2] = Math.max(dp[1], Math.max(dp[0]+a[2], a[1]+a[2])); 
		}
		
		for (int i = 3; i < n; i++) {
			
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+a[i],dp[i-3]+ a[i-1]+a[i])); 
		}
		
		System.out.println(dp[n-1]);
	}
}
