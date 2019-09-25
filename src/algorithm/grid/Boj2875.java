package algorithm.grid;

import java.util.Scanner;

public class Boj2875 {
	public static int n;
	public static int m;
	public static int k;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		int team = 0;
		
		if (n + m > k) {
			team = n/2 < m ? n/2 : m;
			k -= (n+m) - team*3;
			if (k > 0) team -= (k+2)/3;
		}
		System.out.println(team);
	}
	
	
}
