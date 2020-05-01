package algorithm.stringAlgorithm;

import java.util.Scanner;

public class Boj1032 {
	private static int n;
	private static String[] file;
	private static boolean[] check;
	private static String result;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		sc.nextLine();
		
		file	= new String[n];
		
		for (int i = 0; i < n; i++) {
		
			file[i] = sc.nextLine();
		}
		
		check	= new boolean[file[0].length()];
		
		for (int i = 0,outter_loop = file[0].length(); i < outter_loop; i++) {
			
			for (int j = 1,inner_loop = n; j < inner_loop; j++) {
				
				if (file[0].charAt(i) != file[j].charAt(i)) {
					check[i] = true;
					break;
				}
			}
		}
		result = "";
		for (int i = 0,loop = check.length; i < loop; i++) {
			
			if (!check[i]) {
				result+=file[0].charAt(i);
			} else {
				result+="?";
			}
		}
		
		System.out.println(result);
	}
}
