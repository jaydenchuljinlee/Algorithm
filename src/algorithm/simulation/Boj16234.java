package algorithm.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj16234 {
	private static int n,l,r;
	private static int[] dx = {-1,0,1,0};
	private static int[] dy = {0,-1,0,1};
	private static int[][] world;

	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		
		sc.nextLine();
		
		world = new int[n][n];
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		for (int i = 0; i < n*n; i++) list.add(new ArrayList<>()); 
		
		for (int i = 0; i < n; i++) {
			
			String[] str = sc.nextLine().split(" ");
			
			for (int j = 0; j < n; j++) {
				
				world[j][i] = Integer.parseInt(str[j]);
			}
		}
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		boolean[] visited = new boolean[n*n];
		
		for (int i = 0; i < n*n; i++) {
			
			if (visited[i]) continue;
			
			int total = 0;
			int cnt = 0;
			
			Queue<Integer> q = new LinkedList<>();
			
			visited[i] = true;
			q.add(i);
			
			while(!q.isEmpty()) {
				
				int u = q.poll();
				
				int cx = u/n;
				int cy = u%n;
				
				total += world[cy][cx];
				cnt++;
				
				for (int dir = 0; dir < 4; dir++) {
					
					int nx = cx + dx[dir];
					int ny = cy + dy[dir];
					
					if (nx < 0 || ny < 0 || nx == n || ny == n) continue;
					
					int diff = Math.abs(world[cy][cx] - world[ny][nx]);
					
					int next = (nx*n)+ny;
					
					if (visited[next]) continue;
					
					if (l <= diff && diff <= r) {
						System.out.println(world[ny][nx]);
						visited[next] = true;
						q.add(next);
						
					}
				}
			}
			
			if (total != world[i%n][i/n]) {
				System.out.println(cnt);
				map.put(total/cnt, 1);
			}
			
		}
		
		int answer = map.size();		
		
		//영역 찾기
		for (int key : map.keySet()) {
			
			System.out.println(key + ":" + map.get(key));
			
		}
		
		answer = answer == n*n ? 0 : answer;
		
		System.out.println(answer);
	}
}
