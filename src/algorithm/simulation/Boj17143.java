package algorithm.simulation;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj17143 {
	private static int R,C;
	private static int[] d = {-1,1,1,-1};
	
	private static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		@Override
		public boolean equals(Object obj) {
			
			Shark s = (Shark) obj;
			
			if (this.r == s.r && this.c == s.c) return true;
			
			return false;
		}
		
	}
	
	public static int find(int r, int c, int m, int[][] shark) {
		
		int answer = 0;
		
		R = r;
		C = c;
		
		ArrayList<Shark> list = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			
			Shark s = new Shark(shark[0][i],shark[1][i],shark[2][i],shark[3][i]-1,shark[4][i]);
			
			list.add(s);
			
			
		}
		
		for (int i = 1; i <= c; i++) {
			
			int near = -1;
			
			for (int l = 0; l < list.size(); l++) {
				
				Shark s = list.get(l);
				
				if (s.c == i) {
					
					if (near >= 0) {
						
						if (s.r < list.get(near).r) near = l;
						
					} else {
						
						near = l;
					}
					
				} 
			}
			
			if (near >= 0) {
				
				answer += list.get(near).z;
				list.remove(near);
				
			}
			
			for (Shark s : list) s = move(s);
			
			while(true) {
				
				ArrayList<Integer> removeList = new ArrayList<>();
				
				boolean flag = false;
				
				for (int j = 0; j < list.size(); j++) {
					
					Shark cur = list.get(j);
					
					int idx = j;
					
					for (int k = 0; k < list.size(); k++) {
						
						Shark com = list.get(k);
						
						if (j == k) continue;
						
						if (cur.r == com.r && cur.c == com.c) {
							
							if (cur.z < com.z) {
								
								removeList.add(idx);
								cur = com;
								idx = k;
							} else {
								
								removeList.add(k);
							}
							
							flag = true;
						}
					}
					
					if (flag) break;
				}
				
				if (!flag) break;
				
				for (int idx : removeList) list.remove(idx);
			}
			
			//System.out.print(i + "번째 " );
			//print(list,answer);
		}
		
		return answer;
	}

	private static void print(ArrayList<Shark> list, int answer) {
		
		for (Shark s : list) {
			
			System.out.println("(" + s.r + "," + s.c + ") , 방향 :" + s.d + " , 속력 : " + s.s + " , 크기 :" + s.z);
		}
		
	}

	private static Shark move(Shark s) {
		
		if (s.s == 0) return s;
		
		int move = s.s;
		
		switch(s.d) {
		
			case 0 :
			case 1 :
				
				while(move > 0) {
					
					if (s.r == 1) s.d = 1;
					
					if (s.r == R) s.d = 0;
					
					s.r += d[s.d];
					
					move--;
				}
				
				break;
				
			case 2 :
			case 3 :
				
				while(move > 0) {
					
					if (s.c == 1) s.d = 2;
					
					if (s.c == C) s.d = 3;
					
					s.c += d[s.d];
					
					move--;
				}
				
				break;
		}
		
		return s;
	}

	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int m = sc.nextInt();
		
		sc.nextLine();
		
		int[][] shark = new int[5][m];
		
		for (int i = 0; i < m; i++) {
			
			String[] str = sc.nextLine().split(" ");
			
			for (int j = 0; j < str.length; j++) {
				
				shark[j][i] = Integer.parseInt(str[j]);
			}
		}
		
		System.out.println(find(r,c,m,shark));
	}
}
