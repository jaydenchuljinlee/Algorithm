package algorithm.DP;

import java.util.Scanner;

public class Boj2579 {
	public static int n;
	public static int[] dp;
	public static int[] a;
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		for (int i = 0 ; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		dp[1] = a[1];
		
		if (n >= 2) dp[2] = dp[1] + a[1];
		
		for(int i = 3; i <=n; i++) {
			dp[i] = Math.max(dp[i-2]+a[i], dp[i-3]+a[i-1]+a[i]);
		}
		System.out.println(dp[n]);
	}
}
