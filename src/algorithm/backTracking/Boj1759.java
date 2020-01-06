package algorithm.backTracking;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1759 {
	private static int L,C;
	private static char[] word;
	private static int[] result;
	

	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		word = new char[str.length()];
		result = new int[str.length()];
		
		Arrays.sort(word);
		
		DFS(0,0,0,0);
	}


	private static void DFS(int start, int depth, int ja, int mo) {
		
		if (depth == L && ja >=2 && mo >=1) {
			
			for (int i = 0; i < C; i++) {
				
				if (result[i] == 1)
					System.out.print(word[i]);
			}
			
			System.out.println();
		}
		
		for (int i = start; i < C; i++) {
			result[i] = 1;
			
			DFS(i+1,depth+1,ja+(!check(word[i])?1:0),mo+(!check(word[i])?0:1));
			
			result[i] = 0;
		}
		
	}


	private static boolean check(char word) {
	
		if (word == 'a' || word == 'e' || word == 'i' || word == 'o' || word == 'u')
			return true;
		else
			return false;
	}
}
