package algorithm.stringAlgorithm;

import java.util.Scanner;

public class Boj2908 {
	
	//값을 거꾸로 변환해서 출력해주는 함수
	public static int reverse(int input) {
		String out = "";
		
		while(input != 0) {
			
			out += (input%10);//나머지를 사용하여 맨뒷자리부터 구함
			input = (input/10);//몫은 맨뒷자리부터 제거
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
