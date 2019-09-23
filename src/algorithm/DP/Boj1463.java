package algorithm.DP;

import java.util.Scanner;

public class Boj1463 {
	public static int n;
	
	public void solution() {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int dp[] = new int[n+1];
		
		dp[0]=dp[1]=0;
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + 1;
			
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
		}
		System.out.println(dp[n]);
		sc.close();
	}
	
}
