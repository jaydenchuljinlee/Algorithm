package algorithm.DP;

import java.util.Scanner;

public class Boj1003 {
	public static int one;
	public static int zero;
	public static int t;
	public static int[] arr;
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		
		t = sc.nextInt();
		arr = new int[t*2];
		
		for(int i = 0; i < t; i++) {
			one = 0;
			zero = 0;
			
			int a = sc.nextInt();
			
			fibonacci(a);
			
			arr[i*2] = zero;
			arr[i*2+1] = one;
			
		}
		
		for (int i = 0; i < t; i++) {
			System.out.println(arr[i*2] + " " + arr[i*2+1]);
		}
	}
	
	public static int fibonacci(int a) {
		
		if (a == 0) {
			zero++;
			return 0;
		} else if (a == 1) {
			one++;
			return 1;
		} else {
			return fibonacci(a-1) + fibonacci(a-2);
		}
	}
	
}
