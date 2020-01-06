package algorithm.backTracking;

import java.util.Scanner;

public class Boj2661 {
	private static int N;
	private static String asnwer;
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		DFS("");
		
	}

	private static void DFS(String str) {
		
		if (str.length() == N) {
			
			System.out.println(str);
			
			return;
		}

		for (int i = 1; i <= 3; i++) {
			
			if (isAble(str+i)) {
				DFS(str+i);
			}
		}
		
		for (int i = 1; i <= 3; i++) {
			
			DFS(asnwer+i);
		}
		
	}

	private static boolean isAble(String str) {

		int len = str.length();
		
		for (int i = 0; i < len/2; i++) {
			
			String first	= str.substring(len -i -i, len -i);
			String second	=  str.substring(len -i, len);
			
			if (first.equals(second)) return false;
			
		}
		return true;
	}
}
