package algorithm.stringAlgorithm;

import java.util.Scanner;

public class Boj2908 {
	
	//���� �Ųٷ� ��ȯ�ؼ� ������ִ� �Լ�
	public static int reverse(int input) {
		String out = "";
		
		while(input != 0) {
			
			out += (input%10);//�������� ����Ͽ� �ǵ��ڸ����� ����
			input = (input/10);//���� �ǵ��ڸ����� ����
		}
		
		return Integer.parseInt(out);
	}

	public static void solution() {
		Scanner sc = new Scanner(System.in);
		
		int first = sc.nextInt();
		int second =  sc.nextInt();
		
		first = reverse(first);
		second = reverse(second);
		
		System.out.println(first>second ? first:second);
		
	}
}
