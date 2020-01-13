package algorithm.grid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj1946 {
	private static int t,n;
	private static ArrayList<Applicant> list;
	
	private static class Applicant {
		int paper;
		int interview;
		
		public Applicant(int paper, int interview) {
			this.paper = paper;
			this.interview = interview;
		}
	}
		
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		t = sc.nextInt();
		
		for (int test = 0; test < t; test++ ) {
			
			n = sc.nextInt();
			
			list = new ArrayList();
			
			for (int i = 0; i < n; i++) {
				
				list.add(new Applicant(sc.nextInt(),sc.nextInt()));
				
			}
			
			Collections.sort(list,
					(Applicant o1,Applicant o2) -> o1.paper < o2.paper ? -1 : 1);
			
			int ans = n;
			
			int in = list.get(0).interview; 
			
			for (int i = 1; i < n; i++) {
				
				int cur = list.get(i).interview;
				
				if (in < cur) ans--;
				
				if (cur < in) in = cur;
			}
			
			System.out.println(ans);
		}
	}
}
