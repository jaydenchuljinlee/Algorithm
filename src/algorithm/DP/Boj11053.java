package algorithm.DP;

import java.util.Arrays;
import java.util.Scanner;

public class Boj11053 {
	private static int n;
	private static int[] a;
	private static int[] dp;
	private static int max = 0;
	
	public static void solution() {
		
		Scanner sc= new Scanner(System.in);
		
		n = sc.nextInt();
		
		a		= new int[n];
		
		for (int i = 0; i < n; i++) {
			
			a[i] = sc.nextInt();
		}
		
		dp[0] = 1;
		
		for (int i = 1; i < n; i++) {
			
			for (int j = 0; j < i; j++) {
				
				if (a[i] > a[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j]+1;
				} else if (a[i] == a[j]) {
					dp[i] = dp[j];
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

	
}
