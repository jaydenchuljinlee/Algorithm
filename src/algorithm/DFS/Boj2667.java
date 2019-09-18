package algorithm.DFS;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj2667 {
	public static int n;
	public static int[][] arr;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int count;
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		
		n = Integer.parseInt(sc.next());
		
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			
			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		int total = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int i = 0; i < n; i++) {//for문을 두번 돌려서 (0,0)부터 (n,n)까지 dfs를 진행한다.
			for (int j = 0; j < n; j++) {
				
				if (arr[i][j] == 1) {
					count = 0;//한번 돌때매다 count를 0으로 만들어줘서 블록을 형성
					total++;
					
					dfs(i,j);
					
					pq.add(count);
				}
			}
		}
	}
	
	public static void dfs(int x, int y) {
		arr[x][y] = 0;// 방문한 1 지점을 0으로 바꿔서 메모이제이션을 진행
		count++;
		
		for(int i = 0; i < 4; i++) {// 앞,뒤,양옆으로 진행해나가는 과정
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0 <= nx && nx <= n && 0 <= ny && ny < n) {//배열의 길이를 넘어가지 않고, 0보다 클 때
				
				if(arr[nx][ny] == 1) {
					dfs(nx,ny);
				}
			}
		}
	}
}
