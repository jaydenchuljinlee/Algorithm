package algorithm.bruteForce;

import java.util.Scanner;

public class Boj1065 {
	private static int n;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		if (n < 100) {
			System.out.println(n);
		} else {
			
			int result = 99;
			
			for (int i = 100; i <= n; i++) {
				
				result += checkHanNumber(i);
			}
			
			System.out.println(result);
		}
	}

	private static int checkHanNumber(int i) {

		int num1 = (i / 100) %10;
		int num2 = (i / 10) %10;
		int num3 = i%10;
		
		if (num1+num2 == 2*num2) return 1;
		
		return 0;
	}
}
