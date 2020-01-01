package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class Algorithm {
	public static int[][] map;

	public static void main(String[] args) throws Exception{
		
		int V = 5;
		int[][] bridge = {{1,2},{2,3},{4,5}};
		
		
		solution(V,bridge);
	}
	
	public static void solution(int V, int[][] bridge) {
		int answer = 0;
		
		map = new int[V+1][V+1];
		
		for (int i =0; i < bridge.length; i++) {
			map[bridge[i][0]][bridge[i][1]] = 1;
			map[bridge[i][1]][bridge[i][0]] = 1;
		}
		
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				if (i != j && map[i][j] == 0) {
					
					answer++;
					 map[i][j] = 1; map[j][i] = 1;
				}
			}
		}
		
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(answer);
		
	}
}
