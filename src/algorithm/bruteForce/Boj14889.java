package algorithm.bruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class Boj14889 {
	private static int n;
	private static int[][] arr;
	private static boolean[] team;
	private static int min = Integer.MAX_VALUE;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		sc.nextLine();
		arr = new int[n][n];
		team = new boolean[n];
		
		Arrays.fill(team, false);
		
		for (int i = 0; i < n; i++) {
			
			String[] str = sc.nextLine().split(" ");
			
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			
			System.out.println();
		}
		DFS(0,0);
		System.out.println(min);
	}

	private static void DFS(int start, int idx) {
		
		if (idx == n/2) {
			
			min = Math.min(min, getTeam());
			return;
			
		}
		
		for (int i = start; i < n; i++) {
			
			if (!team[i]) {
				
				team[i] = true;
				DFS(i+1,idx+1);
				team[i] = false;
			}
		}
	}

	private static int getTeam() {
		
		int startSum 	= 0;
		int linkSum		= 0;

		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				
				if (team[i] && team[j]) startSum += arr[i][j];
				
				if (!team[i] && !team[j]) linkSum += arr[i][j];
			}
		}
		
		return Math.abs(startSum - linkSum);
	}
}
