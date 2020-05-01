package algorithm.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Boj1342 {
	private static String s;
	private static boolean[] visited;
	private static ArrayList<String> list;
	
	public static void solution() {
	
		Scanner sc = new Scanner(System.in);
		
		s = sc.nextLine();
		
		visited = new boolean[s.length()];
		
		Arrays.fill(visited, false);
		
		list = new ArrayList();
		
		for (int i = 0,loop = s.length(); i < loop; i++) {
			visited[i] = true;
			solve(i,""+s.charAt(i));
			visited[i] = false;
		}
		
		System.out.println(list.size());
	}


	private static void solve(int idx, String str) {

		int len = str.length();
		
		if (str.length() == s.length()) {
			
			if (list.contains(str)) return;
			
			list.add(str);
			return;
		}
		
		for (int i = 0,loop = s.length(); i < loop; i++) {
			
			if (str.charAt(len-1) == s.charAt(i)) continue;
			
			if (visited[i]) continue;
			
			visited[i] = true;
			solve(i,str+s.charAt(i));
			visited[i] = false;
				
		}
		
		
		
	}


	
}
