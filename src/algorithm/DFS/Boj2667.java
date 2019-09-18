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
		
		for (int i = 0; i < n; i++) {//for���� �ι� ������ (0,0)���� (n,n)���� dfs�� �����Ѵ�.
			for (int j = 0; j < n; j++) {
				
				if (arr[i][j] == 1) {
					count = 0;//�ѹ� �����Ŵ� count�� 0���� ������༭ ����� ����
					total++;
					
					dfs(i,j);
					
					pq.add(count);
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
			
			if(0 <= nx && nx <= n && 0 <= ny && ny < n) {//�迭�� ���̸� �Ѿ�� �ʰ�, 0���� Ŭ ��
				
				if(arr[nx][ny] == 1) {
					dfs(nx,ny);
				}
			}
		}
	}
}
