package algorithm.simulation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj17142 {
	private static int n,m;
	private static ArrayList<Dot> area;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static int min;
	
	private static class Dot {
		int x;
		int y;
		int t;
		
		public Dot(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		sc.nextLine();
		
		int[][] board = new int[n][n];
		
		area = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			
			String[] str = sc.nextLine().split(" ");
			
			for (int j = 0; j < n; j++) {
				
				board[j][i] = Integer.parseInt(str[j]);
				
				if (board[j][i] == 1) board[j][i] = -2;
				
				if (board[j][i] == 2) {
					
					board[j][i] = -1;
					
					area.add(new Dot(i,j,1));
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < area.size(); i++) {
			
			Dot d = area.get(i);
			
			board[d.y][d.x] = 1;
			dfs(board,i,0);
			board[d.y][d.x] = -1;
			
		}
		
		int answer = min == Integer.MAX_VALUE ? -1 : min;
		
		System.out.println(answer);
	}

	private static void dfs(int[][] board,int idx,int cnt) {

		int[][] copyBoard = copyBoard(board);
		
		if (cnt < m-1) {
			
			for (int i = idx+1; i < area.size(); i++) {
				
				Dot d = area.get(i);
				
				copyBoard[d.y][d.x] = 1;
				dfs(copyBoard,i,cnt+1);
				copyBoard[d.y][d.x] = -1;
			}
			
			return;
		}
		
		//System.out.println("===========");
		//print(copyBoard);
		
		int time = 0;
		
		// 퍼져있는 바이러스 확인
		PriorityQueue<Dot> birus = new PriorityQueue<>(new Comparator<Dot>() {

			@Override
			public int compare(Dot o1, Dot o2) {
				// TODO Auto-generated method stub
				return o1.t - o2.t;
			}
		});
		
		for (int i = 0; i < n ; i++) {
			
			for (int j = 0; j < n ;j++) {
				
				if (board[j][i] > 0) birus.add(new Dot(i,j,board[j][i]));
			}
		}
		
		//바이러스 탐색
		while(!birus.isEmpty()) {
			//System.out.println("-");
			Dot cur = birus.poll();
			
			//상하좌우 확인
			for (int i = 0; i < 4; i++) {
				
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx == n || ny == n) continue;
				
				//빈칸일 때
				if (copyBoard[ny][nx] == 0) {
					
					copyBoard[ny][nx] = cur.t+1;
					birus.add(new Dot(nx,ny,cur.t+1));
				} 
				
			}
			
			
			time = Math.max(time, cur.t);
		}
		
		
		//System.out.println(time);
		//System.out.println();
		if (isCompleted(copyBoard)) {
			
			min = Math.min(min, time-1);
			return;
		}
	}

	private static boolean isCompleted(int[][] board) {

		for (int i = 0; i < n ; i++) {
			
			for (int j = 0; j < n ;j++) {
				
				if (board[j][i] == 0) return false;
			}
		}
		
		return true;
	}
	
	private static int[][] copyBoard(int[][] board) {
		int[][] copyBoard = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < board[i].length; j++) {
				
				copyBoard[j][i] = board[j][i];
			}	
		}
		
		return copyBoard;
	}
	
	private static void print(int[][] board) {

		for (int i = 0; i < board.length; i++) {
			
			for (int j = 0; j < board[i].length; j++) {
				
				System.out.print(board[j][i] + " ");
			}
			System.out.println();
		}
		
	}
}
