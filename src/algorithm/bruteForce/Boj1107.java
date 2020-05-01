package algorithm.bruteForce;

import java.util.Scanner;

public class Boj1107 {
	private static int n,m;
	private static boolean[] broken = new boolean[10];
	private static int min,limit;
	
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int i = 0; i < m; i++) {
			broken[sc.nextInt()] = true;
		}
		
		limit = (n+"").length()+1;
		min = Math.abs(n-100);
		
		for (int i = 0; i < 10; i++) {
			
			if (broken[i]) continue;
			solve(1,i);
		}
		
		System.out.println(min);
	}

	private static void solve(int cnt, int ch) {

		if (limit < cnt) return;
		
		min = Math.min(min, cnt + Math.abs(ch-n));
		
		for (int i = 0; i < 10; i++) {
			
			if (broken[i]) continue;
			solve(cnt+1,(ch*10) +i);
		}
		
	}
}
