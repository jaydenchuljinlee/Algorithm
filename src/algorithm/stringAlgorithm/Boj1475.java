package algorithm.stringAlgorithm;

import java.util.Scanner;

public class Boj1475 {
	private static String n;
	private static int[] set = new int[10]; 
	private static int max = 0; 
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextLine();
		
		for (int i = 0,loop=n.length(); i < loop; i++) {
			
			char num = n.charAt(i);
			
			set[num-'0']++;
		}
		
		int sum = set[6] + set[9];
		
		if (sum%2 == 0) {
			set[6] = sum/2; 
			set[9] = sum/2; 
		} else {
			set[6] = sum/2 +1; 
			set[9] = sum/2 +1; 
		}
		
		for (int i = 0; i < set.length; i++) {
			
			max = Math.max(max, set[i]);
		}
		
		System.out.println(max);
	}
}
