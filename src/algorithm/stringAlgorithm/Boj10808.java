package algorithm.stringAlgorithm;

import java.util.Scanner;

public class Boj10808 {
	private static String str;
	private static int[] a = new int[26]; 
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		str = sc.next();
		
		for (int i = 0,loop = str.length(); i < loop; i++) {
			
			a[str.charAt(i)-'a']++;
		}
		
		for (int i = 0,loop = a.length; i < loop; i++) {
			
			System.out.print(a[i] + " ");
		}
	}
}
