package algorithm.simulation;

import java.util.LinkedList;
import java.util.Scanner;

public class Boj1966 {

	public static void solution() throws Exception {
		
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		for (int i = 0; i < test; i++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int cnt = 0;
			
			for (int j = 0; j < N; j++) q.add(sc.nextInt());
			
			while(true) {
				
				boolean isPriority = false;
				
				for (int k = 0; k < N; k++) {
					
					if (q.peek() < q.get(k)) {
						isPriority = false;
						break;
					}
				}
				
				if (isPriority) {
					cnt++;
					q.poll();
					
					if (M == 0) break;
					else --M;
					
				} else {
					
					int temp = q.poll();
					q.add(temp);
					
					if (M == 0) {
						M = q.size() -1;
					} else {
						--M;
					}
					
				}
			}
			System.out.println(cnt);
		}
	}
}
