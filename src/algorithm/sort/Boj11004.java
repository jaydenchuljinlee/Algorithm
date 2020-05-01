package algorithm.sort;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj11004 {
	private static int n,k;
	private static PriorityQueue<Integer> pq;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		pq = new PriorityQueue();
		
		for (int i = 0; i < n; i++) {
			pq.add(sc.nextInt());
		}
		
		int cnt = 1;
		while(!pq.isEmpty()) {
			
			if (cnt == k) {
				System.out.println(pq.poll());
				return;
			}
			
			cnt++;
			pq.poll();
		}
	}
}
