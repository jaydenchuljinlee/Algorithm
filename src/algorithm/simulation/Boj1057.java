package algorithm.simulation;

import java.util.Scanner;

public class Boj1057 {
	private static int n,kim,im,cnt=0;
	
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n	= sc.nextInt();
		kim = sc.nextInt();
		im	= sc.nextInt();
		
		while(kim != im) {
			kim = kim/2 + kim%2;
			im	= im/2 + im%2;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
