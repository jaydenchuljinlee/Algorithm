package algorithm.grid;

import java.util.Scanner;

public class Boj1541 {
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		String[] ex = sc.next().split("\\-");
		
		int answer = 0;
		
		for (int i = 1; i < ex.length; i++) {
			
			answer -= plusCalc(ex[i]); 
		}
		
		answer += Integer.parseInt(ex[0]);
		
		System.out.println(answer);
	}

	private static int plusCalc(String expression) {

		String[] plus =  expression.split("\\+");
		
		int rtnVal = 0;
		
		for (String str : plus) {
			rtnVal += Integer.parseInt(str);
		}
		
		return rtnVal;
	}
}
