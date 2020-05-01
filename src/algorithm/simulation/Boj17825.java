package algorithm.simulation;

import java.util.Scanner;

public class Boj17825 {
	// 1~33까지의 게임판, [0]은 value, [1~5]는 1~5에 해당하는 좌표
	private static int[][] board = {{0,1,2,3,4,5}
									,{2,2,3,4,5,9}
									,{4,3,4,5,9,10}
									,{6,4,5,9,10,11}
									,{8,}};
	
	
	private static int findMaxValue(int[] dice) {

		

		
		return 0;
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		String[] str = sc.nextLine().split(" ");
		
		int[] dice =  new int[str.length];
		
		for (int i = 0; i < str.length; i++) dice[i] = Integer.parseInt(str[i]);  
		
		
		
		
		int answer = findMaxValue(dice);
		
		System.out.println(answer);
	}

	
}
