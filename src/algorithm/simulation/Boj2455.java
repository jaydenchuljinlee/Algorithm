package algorithm.simulation;

import java.util.Scanner;

public class Boj2455 {
	
	public static void solution(Scanner sc) {
		
		int cnt = 0;
		int max = 0;
		
		for (int i = 0; i < 4; i++) {
			
			cnt -= sc.nextInt();
			cnt += sc.nextInt();
			
			if (cnt > max) max = cnt;
		}
		
		System.out.println(max);
	}
	
}
