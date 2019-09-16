package algorithm.stringAlgorithm;

import java.util.Scanner;

public class Boj10809 {
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
	    String input = sc.next();
	    
	    // indexOf() 함수를 사용하여 스캐너로 받은 스트링 값에 a~z가 있는지 검사
	    for (char c = 'a' ; c <= 'z' ; c++)
	           System.out.print(input.indexOf(c) + " ");
	}
	
	
}
