package algorithm.DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj11403 {
	public static int N;
	public static int[][] arr;
	public static Queue<Integer> queue = new LinkedList<>();
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] str = sc.next().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		int temp;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					queue.add(j);
				}
			}
			
			while(!queue.isEmpty()) {
				temp = queue.poll();
				BFS(i,temp);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void BFS(int i, int j) {
		arr[i][j] = 1;
		
		for (int k = 0; k < arr[0].length; k++) {
			if (arr[j][k] == 1 && arr[i][k] != 1) {
				queue.add(k);
			}
		}
		
	}
	
}
