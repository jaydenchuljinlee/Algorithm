package algorithm.DP;

import java.util.Scanner;

public class Boj1149 {
	private static int n;
	private static int[][] rgb;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		rgb = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			
			String[] str = sc.nextLine().split(" ");
			
			for (int j = 0; j < 3; j++) {
				
				rgb[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for (int i = 1; i < n; i++) {
			
			rgb[i][0] = Math.min(rgb[i-1][1], rgb[i-1][2]);
			rgb[i][1] = Math.min(rgb[i-1][0], rgb[i-1][2]);
			rgb[i][2] = Math.min(rgb[i-1][0], rgb[i-1][1]);
		}
	}
}
