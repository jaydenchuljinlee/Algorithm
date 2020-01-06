package algorithm.backTracking;

import java.util.Scanner;

public class Boj2023 {
	private static int N;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		DFS("");
	}

	private static void DFS(String str) {
		
		if (!isPrime(Integer.parseInt(str))) return;
		
		if (str.length() == 4) {
			
			System.out.println(str);
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			
			DFS(str+i);
		}
		
	}

	private static boolean isPrime(int value) {

		for (int i = 2; i < value; i++) {
			
			if (value%i==0) return false;
		}
		
		return true;
	}
}
