package algorithm.DP;

import java.util.Scanner;

public class Boj9095 {
	public static int t;
	public static int n;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		t = sc.nextInt();
		
		int[] answer = new int[11];
		answer[1] = 1;
		answer[2] = 2;
		answer[3] = 4;
		
		for (int i = 0; i < t; i++) {
			n = sc.nextInt();
			
			for (int j = 4; j <=n; j++) {
				answer[j] = answer[j-1] + answer[j-2] + answer[j-3];
			}
			System.out.println(answer[n]);
		}
	} 
	
}
