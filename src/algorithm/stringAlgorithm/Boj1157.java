package algorithm.stringAlgorithm;

import java.util.Scanner;

public class Boj1157 {

	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		int [] cnt = new int[26];
		
		int max = 0;
		char answer = '?';
		
		String word = sc.next().toUpperCase();// 단어 입력 후 대문자로 바꿈
		
		for(int i = 0; i < word.length(); i++) {
			cnt[word.charAt(i)-65]++;
			
			if(max < cnt[word.charAt(i)-65]) {
				answer = word.charAt(i);
				max = cnt[word.charAt(i) -65];
				
			} else if(max == word.charAt(i)-65){//max가 현재 문자열의 갯수와 같다면
				answer = '?';
			}
		}
		
		System.out.println(answer);
	}
}
