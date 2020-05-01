package algorithm.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Boj17822 {
	private static int[][] oneboard;
	private static int[] dn = {-1,1,0,0};
	private static int[] dm = {0,0,1,-1};
	private static int n,m,t;
	
	private static class Dot {
		int n;
		int m;
		int value;
		
		public Dot(int n, int m, int value) {
			this.n = n;
			this.m = m;
			this.value = value;
		}
	}
	
	private static boolean check(ArrayList<Dot> list) {

		boolean flag = false;
		
		// ���� ���ڸ� ���� ����Ʈ�� �߰�
		for (Dot dot : list) {
			
			//�����¿� ���� Ȯ��
			for (int i = 0; i < 4; i++) {
				
				int nn = dot.n + dn[i];
				int nm = dot.m + dm[i];
				
				//���� ���� or �� �Ʒ� ����
				if (nn < 0 || nn == n) continue;
				
				//ó�� or ��
				if (nm < 0) nm = m-1;
				if (nm == m) nm = 0;
				
				//���ڰ� �����鼭 �ߺ��� �ƴϸ� �߰�
				if (dot.value == oneboard[nn][nm]) {
					//System.out.println(dot.n + "," + dot.m);
					
					oneboard[dot.n][dot.m] = 0;
					oneboard[nn][nm] = 0;
					
					flag = true;
				}
				
			}
		}
		
		return flag;
	}

	private static void rotate(int idx, int dir, int k) {

		//���� ��ȣ�� �����ŭ
		
		for (int i = idx; i <= n; i += idx) {
			int n = i-1;
			
			if (dir == 1) {
		        int[] a = Arrays.copyOfRange(oneboard[n], 0, k);
		        int[] b = Arrays.copyOfRange(oneboard[n], k, m);

		        System.arraycopy(b, 0, oneboard[n], 0, b.length);
		        System.arraycopy(a, 0, oneboard[n], b.length, a.length);
		      } else {
		        int[] a = Arrays.copyOfRange(oneboard[n], 0, m - k);
		        int[] b = Arrays.copyOfRange(oneboard[n], m - k, m);

		        System.arraycopy(b, 0, oneboard[n], 0, b.length);
		        System.arraycopy(a, 0, oneboard[n], b.length, a.length);
		      }
		}
		
	}

	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		
		oneboard = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < m; j++) {
				
				oneboard[i][j] = sc.nextInt();
			}
		}
		
		int answer = 0;
		
		for (int i = 0; i < t; i++) {
			
			int idx = sc.nextInt();
			int dir = sc.nextInt();
			int k = sc.nextInt()%m;			
			
			rotate(idx,dir,k);
			
			ArrayList<Dot> list = new ArrayList<>();
			
			double sum = 0;
			int cnt = 0;
			
			// ������ ���� Ȯ��
			for (int ni = 0; ni < n; ni++) {
				
				for (int nj = 0; nj < m; nj++) {
					
					if (oneboard[ni][nj] > 0) {
						cnt++;
						sum += oneboard[ni][nj];
						list.add(new Dot(ni,nj,oneboard[ni][nj]));
					}
					
				}
			}
			
			
			//������ ���� ������
			if (!check(list)) {
				
				double ave = sum*1.0/cnt;
				
				for (int ni = 0; ni < n; ni++) {
					
					for (int nj = 0; nj < m; nj++) {
						
						if (oneboard[ni][nj] > 0) {

							if (ave > oneboard[ni][nj]) oneboard[ni][nj]++;
							else if (ave < oneboard[ni][nj]) oneboard[ni][nj]--;
						}
						
					}
					
				}
			}
			
		}
		
		//��� ����
		for (int i = 0; i < oneboard.length; i++) {
			
			for (int j = 0; j < oneboard[i].length; j++) {
				
				answer += oneboard[i][j];
			}
		}
		
		System.out.println(answer);
	}

	
}
