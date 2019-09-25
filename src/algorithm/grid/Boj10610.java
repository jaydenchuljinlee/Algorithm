package algorithm.grid;

import java.util.Scanner;

public class Boj10610 {
	public static int length;
	public static int[] arr;
	public static String str;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		str = sc.next();
		
		length = str.length();
		
		arr = new int[length];
		
		long total = 0;
		
		for (int i = 0; i < length; i++) {
			
			int unit = Integer.parseInt(str.substring(i,i+1));
			
			arr[unit]+=1;
			
			total += unit;
		}
		
		if (!str.contains("0") || total%3 != 0) {
			System.out.println(-1);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 9; i >= 0; i--) {
			while(arr[i] > 0) {
				sb.append(i);
				arr[i]--;
			}
		}
		
		System.out.println(sb.toString());
	}
	
}
