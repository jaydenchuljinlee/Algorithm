package algorithm.backTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj1339 {
	private static int N;
	private static String word[];
	private static ArrayList<Character> list = new ArrayList<>();
	private static int size,max=0;
	private static int[] value;
	private static boolean[] visited = new boolean[10];
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		word = new String[2]; 
		
		for (int i = 0; i < N; i++) {
			
			word[0] = sc.next();
			
			for (int j = 0; j < word[i].length(); j++) {
				
				if(!list.contains(word[i].charAt(j)))
					list.add(word[i].charAt(j));
			}
		}
		
		size = list.size();
		
		value = new int[size];
		
		DFS(0,0);
		
	}

	private static void DFS(int idx, int cnt) {

		if (cnt == size) {
			int sum = 0;
			
			for (int i = 0; i < N; i++ ) {
				int num = 0;
				for (int j = 0; j < word[i].length(); j++) {
					num *= 10;
					num += (value[list.indexOf(word[i].charAt(j))]);
				}
				
				sum += num;
			}
			
			max = Math.max(max, sum);
		}
		
		for (int i = 9; i >= 0; i--) {
			
			if (visited[i]) continue;
			
			visited[i] = true;
			value[idx] = i;
			DFS(idx+1,cnt+1);
			visited[i] = false;
			value[idx] = 0;
			
		}
	}
}
