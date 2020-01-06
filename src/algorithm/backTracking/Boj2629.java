package algorithm.backTracking;

import java.util.Scanner;

public class Boj2629 {
	private static int C,G;
	private static boolean[][] visited;
	private static int[] weight;
	private static int[] goosle;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		C = sc.nextInt();
		weight = new int[C];
		for (int i = 0; i < C; i++) {
			weight[i] = sc.nextInt();
		}
		
		G = sc.nextInt();
		goosle = new int[C];
		for (int i = 0; i < G; i++) {
			goosle[i] = sc.nextInt();			
		}
		
		visited = new boolean[C][C*500];
		
		solve(0,0);
		
		find();
	}

	private static void find() {

		for (int i = 0; i < G; i++) {
			
			if (goosle[i] > 500*C) System.out.print("N ");
			if (visited[C-1][goosle[i]]) {
				System.out.print("Y ");
			} else {
				System.out.print("N ");
			}
		}
		
	}

	private static void solve(int cnt,int result) {
		
		if (cnt > C) return;
		if (visited[cnt][result] = true) return;
		
		visited[cnt][result] = true;

		solve(cnt+1,result+weight[cnt]);
		solve(cnt+1,result);
		solve(cnt+1,Math.abs(result-weight[cnt]));
		
	}
}
