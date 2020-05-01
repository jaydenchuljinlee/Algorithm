package algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1026 {
	private static int n,s;
	private static int[] a,b;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		sc.nextLine();
		
		a = new int[n];
		b = new int[n];
		
		String[] strA = sc.nextLine().split(" ");
		String[] strB = sc.nextLine().split(" ");
		
		
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(strA[i]);
			b[i] = Integer.parseInt(strA[i]);
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		s = 0;
		
		for (int i = 0; i < n; i++) {
			s += (a[i] + b[n-i-1]);
		}
		
		System.out.println(s);
	}
}
