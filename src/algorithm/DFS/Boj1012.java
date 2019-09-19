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
		
		for (int i = 0; i < N; i++) {//for���� �ι� ������ (0,0)���� (n,n)���� dfs�� �����Ѵ�.
			for (int j = 0; j < M; j++) {
				
				if (arr[i][j] == 1) {
					
					dfs(i,j);
					total++;
				}
			}
		}
	}
	
	public static void dfs(int x, int y) {
		arr[x][y] = 0;// �湮�� 1 ������ 0���� �ٲ㼭 �޸������̼��� ����
		count++;
		
		for(int i = 0; i < 4; i++) {// ��,��,�翷���� �����س����� ����
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0 <= nx && nx <= N && 0 <= ny && ny < M) {//�迭�� ���̸� �Ѿ�� �ʰ�, 0���� Ŭ ��
				
				if(arr[nx][ny] == 1) {
					dfs(nx,ny);
				}
			}
		}
	}
}
