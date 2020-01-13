package algorithm.bruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Boj14888 {
	private static int n;
	private static int[] a;
	private static int[] operation = new int[4];
	private static List<Integer> list = new ArrayList(); ;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		a = new int[n];
		
		for (int i = 0; i < n; i++) {
			
			a[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 4; i++) {
			
			operation[i] = sc.nextInt();
		}
		
		DFS(1,a[0]);
		
		Collections.sort(list);
		
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
		
	}

	private static void DFS(int cnt, int sum) {

		for (int i = 0; i < 4; i++) {
			
			if (operation[i] != 0) {
				operation[i] -= 1;
				switch(operation[i]) {
					case 0 :
						DFS(cnt+1,sum+a[cnt]);
						break;
					case 1 :
						DFS(cnt+1,sum-a[cnt]);
						break;
					case 2 :
						DFS(cnt+1,sum*a[cnt]);
						break;
					case 3 :
						DFS(cnt+1,sum%a[cnt]);
						break;
				}
				operation[i] += 1;
			}
		}
		
		if (cnt == n) list.add(sum);
		
	}
	
	
}
