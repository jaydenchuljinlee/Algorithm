package algorithm.grid;

import java.util.Scanner;

public class Boj1120 {
	private static String[] str;
	private static int min = Integer.MAX_VALUE;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		str = sc.nextLine().split(" ");
		
		for (int i = 0; i <= str[1].length()-str[0].length(); i++) {
			String temp = str[1].substring(i,str[0].length()+i);
			
			int sum = 0;
			
			for (int j = 0; j < temp.length(); j++) {
				
				if (str[0].charAt(j) != temp.charAt(j)) sum++;
			}
			
			min = Math.min(sum, min);
		}
		
		System.out.println(min);
	}
}
