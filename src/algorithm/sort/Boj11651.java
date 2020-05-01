package algorithm.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj11651 {
	private static int n;
	private static PriorityQueue<Dot> pq;
	
	private static class Dot{
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
		sc.nextLine();
		
		pq = new PriorityQueue(new Comparator<Dot>() {

			@Override
			public int compare(Dot o1, Dot o2) {

				if (o1.y < o2.y) {
					return -1;
				} else if (o1.y == o2.y) {
					
					if (o1.x < o2.x) {
						return -1;
					} else {
						return 1;
					}
				}
				
				return 1;
			}
		});
		
		for (int i = 0; i < n; i++) {
			
			String[] str = sc.nextLine().split(" ");
			
			Dot d = new Dot(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
			
			pq.add(d);
		}
		
		while(!pq.isEmpty()) {
			
			Dot d = pq.poll(); 
			
			System.out.println(d.x + " " + d.y);
		}
	}
}
