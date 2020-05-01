package algorithm.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Boj1248 {
	private static int N;
	private static ArrayList<Integer> list;
	private static char[][] cal;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.nextLine();
		
		cal = new char[N][N];
		String str = sc.nextLine();
		
		int idx = 0;
		
		for (int i = 0; i < N; i++) {
			
			for (int j = i; j < N; j++) {
				cal[i][j] = str.charAt(idx);
				idx++;
			}
		}
		
		list = new ArrayList();
		
		solve(0);
	}

	private static void solve(int idx) {
		
		if (idx == N) {
			
			for (int i = 0 ; i < list.size(); i++) {
				
				System.out.print(list.get(i) + " ");
			}
			System.exit(1);
		}
		
		for (int i = -10; i <=10; i++) {
			
			list.add(i);
			if (possible(idx)) {
				
				solve(idx+1);
			} 
			list.remove(list.size()-1);
			
		}
	}

	private static boolean possible(int idx) {

		int sum =0;
		
		for (int i = idx; i>=0; i--) {
			
			sum+=list.get(i);
			
			if (cal[i][idx] == '+' && sum <= 0 ) return false;
			if (cal[i][idx] == '0' && sum != 0 ) return false;
			if (cal[i][idx] == '-' && sum >= 0 ) return false;
		}
		
		return true;
	}
}
