package algorithm.stringAlgorithm;

import java.util.Scanner;

public class Boj2941 {
	private static String[] croatia = {"c=","c-","dz=","d-","lj","nj","s=","z="};

	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		
		for (int i = 0; i < croatia.length; i++) 
			word.replace(croatia[i], "a");
		
		System.out.println(word.length());
	}
}
