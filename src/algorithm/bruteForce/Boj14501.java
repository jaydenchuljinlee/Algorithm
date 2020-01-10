package algorithm.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj14501 {
	private static int n;
	private static int[] t;
	private static int[] p;
	private static int[] dp;
	private static int max = 0;

	public static void solution() throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = reader.read();
		
		t	= new int[n+2];
		p	= new int[n+2];
		dp	= new int[n+2];
		
		for (int i = 0; i < n; i++) {
			
			String[] str = reader.readLine().split(" ");
			
			t[i]	= Integer.parseInt(str[0]);
			p[i]	= Integer.parseInt(str[1]);
			
		}
		
		for (int i = n; i > 0; i--) {
			int day = i + t[i];
			
			if (day <= n+1) {
				dp[t[i]+1] = Math.max(p[i] + dp[day], dp[i+1]);
			} else {
				dp[i] = dp[i+1];
			}
		}
		
		System.out.println(dp[1]);
		
	}
}
