package algorithm.stringAlgorithm;

import java.util.Scanner;

public class Boj10809 {
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
	    String input = sc.next();
	    
	    // indexOf() �Լ��� ����Ͽ� ��ĳ�ʷ� ���� ��Ʈ�� ���� a~z�� �ִ��� �˻�
	    for (char c = 'a' ; c <= 'z' ; c++)
	           System.out.print(input.indexOf(c) + " ");
	}
	
	
}
