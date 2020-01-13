package algorithm.bruteForce;

import java.util.LinkedList;
import java.util.Scanner;

public class Boj1966 {
	private static int test,n,m;
	private static LinkedList<Integer> queue;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		test 	= sc.nextInt();
		
		for (int i = 0; i < test; i++) {
			
			n		= sc.nextInt();
			m		= sc.nextInt();
			
			queue = new LinkedList();
			
			for (int j = 0; j < n; j++) {
				
				queue.add(sc.nextInt());
			}
			
			solve();
		}
		
	}

	private static void solve() {
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			boolean isPriority = true;
			
			for (int i = 1; i < queue.size(); i++) {
				
				if (queue.peek() < queue.get(i)) {
					isPriority = false;
					break;
				}
			}
			
			if (isPriority) {
				
				cnt++;
				queue.poll();
				
				if (m == 0) break;
				else m-=1;
				 
			} else {
				
				int temp = queue.poll();
				queue.add(temp);
				m = (m == 0) ? queue.size()-1: --m; 
				
			}
			
		}
		
		System.out.println(cnt);
	}
}
