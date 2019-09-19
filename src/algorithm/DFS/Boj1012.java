package algorithm.DFS;

import java.util.Scanner;

public class Boj1012 {
	public static int N;
	public static int M;
	public static int K;
	public static int[][] arr;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int count;
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][M]; 
		
		for (int i = 0; i < K; i++) {
			String[] s = sc.next().split(" ");
			arr[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
		}
		
		int total = 0;
		
		for (int i = 0; i < N; i++) {//for문을 두번 돌려서 (0,0)부터 (n,n)까지 dfs를 진행한다.
			for (int j = 0; j < M; j++) {
				
				if (arr[i][j] == 1) {
					
					dfs(i,j);
					total++;
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
			
			if(0 <= nx && nx <= N && 0 <= ny && ny < M) {//배열의 길이를 넘어가지 않고, 0보다 클 때
				
				if(arr[nx][ny] == 1) {
					dfs(nx,ny);
				}
			}
		}
	}
}
