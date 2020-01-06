package algorithm.backTracking;

import java.util.LinkedList;
import java.util.Scanner;

public class Boj1248 {
	private static int N;
	private static LinkedList<Integer> list;
	private static char[][] cal;
	private static boolean[] check;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		cal = new char[N][N];
		check = new boolean[N];
		String str = sc.next();
		
		for (int i = 0; i < N; i++) {
			
			for (int j = i; j < N; j++) {
				cal[i][j] = str.charAt((i*4)+j);
			}
		}
				
		solve(0);
	}

	private static void solve(int idx) {
		
		if (idx == N) {
			
			for (int i = 0 ; i < list.size(); i++) {
				
				if (check[i]) {
					System.out.print(list.get(i) + " ");
				}
			}
		}
		
		for (int i = -10; i <=10; i++) {
			
			list.add(i);
			if (possible(i)) solve(idx+1);
			list.remove(i);
			
		}
	}

	private static boolean possible(int idx) {

		int sum =0;
		
		for (int i = idx; i>=0; i++) {
			
			sum+=list.get(i);
			
			if (cal[i][idx] == '+' && sum <= 0 ) return false;
			if (cal[i][idx] == '0' && sum != 0 ) return false;
			if (cal[i][idx] == '-' && sum >= 0 ) return false;
		}
		
		return true;
	}
}
