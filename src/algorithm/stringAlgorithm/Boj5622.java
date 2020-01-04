package algorithm.stringAlgorithm;

import java.util.Scanner;

public class Boj5622 {

	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		
		int answer = 0;
		
		int[] dial = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9};
		
		for (int i = 0; i < word.length(); i++) {
			
			answer += (dial[word.charAt(i) - 65]+1);
		}
		
		System.out.println(answer);
	}
}
