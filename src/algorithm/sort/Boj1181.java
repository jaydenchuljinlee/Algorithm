package algorithm.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj1181 {
	private static int n;
	private static PriorityQueue<String> pq;
		
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		pq = new PriorityQueue(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				if (o1.length() < o2.length()) {
					return -1;
				} else if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				
				return 1;
			}
		});
		
		for (int i = 0; i < n; i++) {
			
			String str = sc.next();
			
			if (pq.contains(str)) continue;
			
			pq.add(str);
		}
		
		
		while(!pq.isEmpty()) {
			
			System.out.println(pq.poll());
		}
	}
}
