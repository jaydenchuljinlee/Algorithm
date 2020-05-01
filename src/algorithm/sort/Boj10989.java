package algorithm.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj10989 {
	private static int n;
	private static PriorityQueue<Integer> pq;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		pq = new PriorityQueue();
		
		for (int i = 0; i < n; i++) {
			pq.add(sc.nextInt());
		}
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
