package algorithm.stringAlgorithm;

import java.util.Scanner;

public class Boj2902 {
	private static String[] str;
	private static String result;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		str = sc.next().split("-");
		result = "";
		for (int i = 0,loop = str.length; i < loop; i++) {
			result += str[i].charAt(0);
		}
		
		System.out.println(result);
	}
}
