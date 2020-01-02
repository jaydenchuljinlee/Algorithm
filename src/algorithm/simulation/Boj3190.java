package algorithm.simulation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj3190 {
	private static int N,K,L;
	private static int[][] map;
	private static char direction[] = new char[10000];
	private static int[] dx = {-1,0,1,0};//ºÏµ¿³²¼­
	private static int[] dy = {0,1,0,-1};
	
	private static class Dot {
		private static int x;
		private static int y;
		
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void solution() {
	
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) Arrays.fill(map[i], 0);
		
		K = sc.nextInt();
		
		for (int i = 0; i < K; i++) map[sc.nextInt()][sc.nextInt()] = 1;
		
		L = sc.nextInt();
		
		Arrays.fill(direction, ' ');
		
		for (int i = 0; i < L; i++) direction[sc.nextInt()] = sc.next().charAt(0);
		
		int next_x;
		int next_y;
		
		int time = 0;
		int dir = 1;
		
		Dot cur = new Dot(0,0);
		Queue<Dot> q= new LinkedList<Dot>();
		q.offer(cur);
		map[cur.x][cur.y] = 2;
		
		while(true) {
			time++;
			
			cur.x += dx[dir];
			cur.y += + dy[dir];
			
			if (cur.x < 0 || cur.y < 0 || cur.x >= N || cur.y >=N ) break;
			
			if (map[cur.x][cur.y] == 2) break;
			
			if (map[cur.x][cur.y] == 0) {
				Dot retail = q.poll();
				map[retail.x][retail.y] = 0;
			}
			
			q.offer(cur);
			map[cur.x][cur.y] = 2;
			
			if (direction[time] == 'L' || direction[time] == 'D') {
				
				dir = changeDir(dir,direction[time]);
			}
			
		}
		
		System.out.println(time);
	}

	private static int changeDir(int dir, char change_dir) {
		
		int next_dir;
		
		if (change_dir == 'D') {
			
			next_dir = (dir == 3) ? 0 : ++dir;
		} else {
			next_dir = (dir == 3) ? 0 : --dir;
		}
		
		return next_dir;
	}

	
}
