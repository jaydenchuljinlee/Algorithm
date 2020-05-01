package algorithm.bruteForce;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj12100 {
	private static int n;
	private static int[][] map;
	private static int max = 0;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		sc.nextLine();
		
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		DFS(0);
		System.out.println(max);
	}

	private static void DFS(int depth) {

		int[][] testMap = new int[n][n];
		copy(testMap,map);
		
		if (depth == 5) {
			findMaxValue();
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			merge(i);
			DFS(depth+1);
			copy(map,testMap);
		}
		
	}

	private static void findMaxValue() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				max = Math.max(max, map[i][j]);
			}
		}
		
	}

	private static void merge(int dir) {

		Queue<Integer> q = new LinkedList();
		int[][] newMap = new int[n][n];
		
		//╩С
		if (dir == 0) {
			
			for (int x = 0; x < n; x++) {
				
				for (int y = 0; y < n; y++) {
					
					if (map[y][x] != 0) {
						q.add(map[y][x]);
					}
				}
				
				int idx = 0;
				
				while(!q.isEmpty()) {
					
					int value = q.peek();
					
					if (newMap[idx][x] == value) {
						newMap[idx][x] += q.poll();
						idx++;
					} else if (newMap[idx][x] == 0) {
						newMap[idx][x] = q.poll();
					} else {
						idx++;
						newMap[idx][x] = q.poll();
					}
				}
			}
		} 
		
		//го
		if (dir == 1) {
			
			for (int x = 0; x < n; x++) {
				
				for (int y = n-1; y >= 0; y--) {
					
					if (map[y][x] != 0) {
						q.add(map[y][x]);
					}
				}
				
				int idx = n-1;
				
				while(!q.isEmpty()) {
					
					int value = q.peek();
					
					if (newMap[idx][x] == value) {
						newMap[idx][x] += q.poll();
						idx--;
					} else if (newMap[idx][x] == 0) {
						newMap[idx][x] = q.poll();
					} else {
						idx--;
						newMap[idx][x] = q.poll();
					}
				}
			}
		} 
		
		//аб
		if (dir == 2) {
			
			for (int y = 0; y < n; y++) {
				
				for (int x = 0; x < n; x++) {
					
					if (map[y][x] != 0) {
						q.add(map[y][x]);
					}
				}
				
				int idx = 0;
				
				while(!q.isEmpty()) {
					
					int value = q.peek();
					
					if (newMap[y][idx] == value) {
						newMap[y][idx] += q.poll();
						idx++;
					} else if (newMap[y][idx] == 0) {
						newMap[y][idx] = q.poll();
					} else {
						idx++;
						newMap[y][idx] = q.poll();
					}
				}
			}
		} 
		
		//©Л
		if (dir == 3) {
			
			for (int y = 0; y < n; y++) {
				
				for (int x = n-1; x >= 0; x--) {
					
					if (map[y][x] != 0) {
						q.add(map[y][x]);
					}
				}
				
				int idx = n-1;
				
				while(!q.isEmpty()) {
					
					int value = q.peek();
					
					if (newMap[y][idx] == value) {
						newMap[y][idx] += q.poll();
						idx--;
					} else if (newMap[y][idx] == 0) {
						newMap[y][idx] = q.poll();
					} else {
						idx--;
						newMap[y][idx] = q.poll();
					}
				}
			}
		} 
		copy(map,newMap);
	}

	private static void copy(int[][] testMap, int[][] map) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j< n; j++) {
			
				testMap[i][j] = map[i][j];
			}
		}
		
	}
}
