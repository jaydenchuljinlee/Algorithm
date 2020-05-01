package algorithm.bruteForce;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj15686 {
	private static int n,m;
	private static ArrayList<Dot> house,chicken;
	private static int[][] map;
	private static boolean[] visited;
	private static int[] choice;
	private static int result = Integer.MAX_VALUE;
	
	private static class Dot {
		int x;
		int y;
		
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		map		= new int[n][n];
		house	= new ArrayList();
		chicken = new ArrayList();
		
		for (int i = 0; i < n; i++) {
			
			String[] str = sc.nextLine().split(" ");
			
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				
				if (map[i][j] == 1) house.add(new Dot(i,j));
				
				if (map[i][j] == 2) chicken.add(new Dot(i,j));
			}
		}
		
		visited	= new boolean[chicken.size()];
		choice	= new int[chicken.size()]; 
		
		for (int i = 0; i < chicken.size(); i++) {
			visited[i] = true;
			solve(i,0);
			visited[i] = false;
		}
		
		System.out.println(result);
	}

	private static void solve(int idx,int cnt) {
		choice[cnt]	= idx;
		
		if (cnt == m-1) {
			
			int sum = 0;
			int currentM = 0;
			
			for (int i = 0; i < house.size(); i++) {
				
				int min = Integer.MAX_VALUE;
				
				for (int j = 0; j < m; j++) {
					
					currentM = calc(house.get(i),chicken.get(choice[j]));
					min = Math.min(min, currentM);
				}
				
				sum += min;
			}
			
			result = Math.min(result, sum);
			return;
		}
		
		for (int i = idx+1; i < chicken.size(); i++) {
			
			if (visited[i]) continue;
			
			visited[i] = true;
			solve(i,cnt+1);
			visited[i] = false;
		}
		
	}

	private static int calc(Dot house, Dot chicken) {
		
		return Math.abs(house.x-chicken.x) + Math.abs(house.y-chicken.y);
	}
}
