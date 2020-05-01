package algorithm.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj10814 {
	private static int n;
	private static PriorityQueue<Member> pq;
	
	private static class Member {
		int age;
		int idx;
		String name;
		
		
		public Member(int age,int idx, String name) {
			this.age	= age;
			this.idx	= idx;
			this.name	= name;
		}
	}
	
	
	public static void solution() throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		
		pq = new PriorityQueue( new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				
				if (o1.age < o2.age) {
					
					return -1;
				} else if (o1.age == o2.age) {
					
					if (o1.idx < o2.idx) {
						return -1;
					} else {
						return 1;
					}
				}
				return 1;
			}
		});
		
		for (int i = 0; i < n; i++) {
			
			String[] str = reader.readLine().split(" ");
			
			Member m = new Member(Integer.parseInt(str[0]),i,str[1]);
			
			pq.add(m);
		}
		
		while(!pq.isEmpty()) {
			
			Member m = pq.poll();
			
			System.out.println(m.age + " " + m.name);
		}
		
		
	}
}
