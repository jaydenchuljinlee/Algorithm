package algorithm.stringAlgorithm;

import java.util.Scanner;

public class Boj1100 {
	private static int result;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 8; i++) {
			
			String str = sc.nextLine();
			
			for (int j = 0; j < 8; j++) {
				
				if (str.charAt(j) == 'F' && (i+j)%2 == 0) result++;
				
			}
		}
		
		System.out.println(result);
	}
}
