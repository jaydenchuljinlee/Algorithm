package algorithm.simulation;

import java.util.Scanner;

public class Boj15684 {
	private static int n,m,h,added,min;
	private static int[] d = {-1,0};
	private static boolean[][] connected;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		h = sc.nextInt();
		
		sc.nextLine();
		
		connected = new boolean[n][h];
		
		for (int i = 0; i < m; i++) {
			
			String[] str = sc.nextLine().split(" ");
			
			int a = Integer.parseInt(str[0])-1;//가로선
			int b = Integer.parseInt(str[1])-1;//세로선
			
			connected[b][a] = true;
		}
		
		if (m == 0) {
			
			System.out.println(0);
			return;
		}
		
		added = 0;
		min = Integer.MAX_VALUE;
		
		while(added++ <= 3) {
			
			if(dfs(0)) break;
			
		}
		
		min = min == Integer.MAX_VALUE ? -1 : min;
		
		System.out.println(min);
	}

	private static boolean dfs(int cnt) {

		//사다리 갯수 추가
		if (cnt < added) {
			
			for (int i = 0; i < n-1; i++) {
				
				for (int j = 0; j < h; j++) {
					
					//이미 연결된 곳이거나 옆에 사다리가 연결이 되있을 떄
					if (connected[i][j]) continue;
					
					if ((i-1 >= 0 && connected[i-1][j]) && connected[i+1][j]) continue;
					
					connected[i][j] = true;
					if (dfs(cnt+1)) return true;
					connected[i][j] = false;
					
				}
			}
		}
		
		//System.out.println("만든 갯수 :" + cnt);
		//print();
		
		//i번째 사다리 값 체크
		for (int i = 0; i < n; i++) {
			
			int nn = i;
			
			//i번째 사다리 탐색
			for (int move = 0; move < h; move++) {
				
				if (connected[nn][move]) nn++; 
				else if (nn-1>=0 && connected[nn-1][move]) nn--;
			}
			
			if (nn != i) return false;
		}
		
		if (cnt < min) min = cnt;
		
		return true;
	}

	private static void print() {

		for (int i = 0; i < h; i++) {
			
			for (int j = 0; j < n; j++) {
				
				System.out.print(connected[j][i] + " ");
			}
			
			System.out.println();
		}
		System.out.println();
	}
}
