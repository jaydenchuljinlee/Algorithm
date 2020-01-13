package algorithm.DP;

import java.util.Scanner;

public class Boj2163 {
	private static int n,m;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		System.out.println(n*m-1);
	}
}
