package algorithm.stringAlgorithm;

import java.util.Scanner;

public class Boj1316 {
	private static int N;
	private static String[] word;

	public static void solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		word = new String[N];
		
		int answer = N;
		
		for(int i = 0; i < N; i++) {
			
			word[i] = sc.next();
			boolean[] checker = new boolean[26]; 
			
			for (int j = 1; j < word[i].length(); j++) {
				
				if (word[i].charAt(j-1) != word[i].charAt(j)) {
					
					if (checker[word[i].charAt(j)-97]) {
						answer--;
						break;
					}
					
					checker[word[i].charAt(j)-97] = true;
				}
			}
		}
		
		System.out.println(answer);
	}
}
