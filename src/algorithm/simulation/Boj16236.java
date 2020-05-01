package algorithm.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Boj16236 {
	private static int n;
	private static int[][] map;
	private static int[] dx = {-1,0,0,1};
	private static int[] dy = {0,-1,1,0};
	private static Shark shark;

	private static class Fish {
		int x;
		int y;
		int size;
		int dist;
		
		public Fish(int x, int y, int size, int dist) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.dist = dist;
		}
	}
	
	private static class Shark extends Fish {

		int cnt;
		
		public Shark(int x, int y, int size, int dist,int cnt) {
			super(x, y, size, dist);
			this.cnt = cnt;
		}
		
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		sc.nextLine();
		
		map = new int[n][n];
		
		int x = 0;
		int y = 0;
				
		
		for (int i = 0; i < n ;i++) {
			
			String[] str = sc.nextLine().split(" ");
			
			for (int j = 0; j < n; j++) {
				
				map[j][i] = Integer.parseInt(str[j]);
				
				if (map[j][i] == 9) {
					
					map[j][i] = 0;
					shark = new Shark(i,j,2,0,0);
				}
			}
		}
		
		int answer = solve();
		
		System.out.println(answer);
	}

	private static int solve() {

		int time = 0;
		
		//���� �� �ִ� ����Ⱑ ���� �� ����
		while(true) {
			
			ArrayList<Fish> fishes = new ArrayList<>();
			
			boolean flag = false;
			
			boolean[][] visited = new boolean[n][n];
			
			visited[shark.y][shark.x] = true;
			
			Queue<Shark> q = new LinkedList<>();
			
			q.add(shark);
			
			int dist = -1;
			
			while(!q.isEmpty()) {
				
				Shark s = q.poll();
				
				int move = s.dist;
				
				if (move == dist) break;
				
				for (int i = 0; i < 4; i++) {
					
					int nx = s.x + dx[i];
					int ny = s.y + dy[i];
					
					if (nx < 0 || ny < 0 || nx == n || ny == n) continue;
					
					if (map[ny][nx] < s.size && map[ny][nx] > 0) {
						
						fishes.add(new Fish(nx,ny,map[ny][nx],s.dist));
						
						dist = s.dist+1;
						
						flag = true;
						
						continue;
					}
					
					//�湮������ ������
					if (visited[ny][nx]) continue;
					
					//���� �� �ִ� ���̰ų� ������
					if (map[ny][nx] == 0 || map[ny][nx] == s.size) {
						
						visited[ny][nx] = true;
						
						q.add(new Shark(nx,ny,s.size,s.dist+1,shark.cnt));
					}
				}
			}
			
			if (!flag) break;
			
			Collections.sort(fishes,new Comparator<Fish>() {

				@Override
				public int compare(Fish o1, Fish o2) {

					if (o1.x == o2.x) {
						
						if (o1.y < o2.y) return -1;
						else return 1;
						
					} else if (o1.x < o2.x) {
						return -1;
					} else {
						return 1;
					}
				}
				
				
			});
			
			Fish fish = fishes.get(0);
									
			//���� ������ ���� ����� ������ ������ ����
			if (shark.cnt+1 == shark.size) {
				shark = new Shark(fish.x,fish.y,shark.size+1,0,0);
			} else {
				shark = new Shark(fish.x,fish.y,shark.size,0,shark.cnt+1);
			}
			
			//�ش� ����� ����
			map[fish.y][fish.x] = 0;
			
			//System.out.println("��ǥ : (" +fish.x + "," + fish.y + "), ũ�� : " + map[fish.y][fish.x]);
			//System.out.println("��� ũ�� : " + shark.size + ", ���� ���� :" + shark.cnt);
			//System.out.println("�ð� :"+time + ", �Ÿ� :" + (fish.dist+1));
			
			//�̵��� �Ÿ���ŭ �ð� ����
			time+=(fish.dist+1);
			//print();
			
		}
		
		return time;
	}

	private static void print() {
		
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				
				System.out.print(map[j][i] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
