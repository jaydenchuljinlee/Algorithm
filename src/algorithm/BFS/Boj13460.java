package algorithm.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj13460 {
	private static int n,m;
	private static char[][] map;
	private static boolean[][][][] visited;
	private static int[] dx = {0,0,-1,1};//동서남북
	private static int[] dy = {1,-1,0,0};
	
	public static class Node {
		int rRow;
		int rCol;
		int bRow;
		int bCol;
		int cnt;
		
		public Node(int rRow,int rCol,int bRow,int bCol,int cnt) {
			this.rRow = rRow;
			this.rCol = rCol;
			this.bRow = bRow;
			this.bCol = bCol;
			this.cnt = cnt;
		}
		
		public Node() {}
		
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new char[n][m];
		visited = new boolean[n][m][n][m];
		
		Node node = new Node();
		node.cnt = 0;
		
		for (int i = 0; i < n; i++) {
			
			String str = sc.next();
			
			for (int j = 0; j < m; j++) {
				
				map[i][j] = str.charAt(j);
				
				if (map[i][j] == 'R') {
					node.rRow = i;
					node.rCol = j;
				}
				
				if (map[i][j] == 'B') {
					node.bRow = i;
					node.bCol = j;
				}
			}
		}
		
		bfs(node);
	}

	private static void bfs(Node ball) {


		Queue<Node> list = new LinkedList();
		list.offer(ball);
		
		while(!list.isEmpty()) {
			
			Node node = list.poll();
			visited[node.rRow][node.rCol][node.bRow][node.bCol] = true;
			
			if (node.cnt >= 10) {
				
				System.out.println(-1);
				return;
			}
			
			for (int dir = 0; dir < 4; dir++) {
				
				//파란색
				int bnRow = node.bRow;
				int bnCol = node.bCol;
				while(map[bnRow+dx[dir]][bnCol+dy[dir]] != '#') {
					bnRow += dx[dir];
					bnCol += dy[dir];
					
					if (map[bnRow+dx[dir]][bnCol+dy[dir]] == 'O') break;
				}
				
				int rnRow = node.rRow;
				int rnCol = node.rCol;
				while(map[rnRow+dx[dir]][rnCol+dy[dir]] != '#') {
					rnRow += dx[dir];
					rnCol += dy[dir];
					
					if (map[rnRow+dx[dir]][rnCol+dy[dir]] == 'O') break;
				}
				
				if (map[bnRow][bnCol] == 'O') continue;
				
				if (map[rnRow][rnCol] == 'O') {
					System.out.println(node.cnt+1);
					return;
				} 
				
				if (bnRow == rnRow && bnCol == rnCol) {
					
					switch(dir) {
						case 0 :
							if (node.bCol > node.rCol) {
								rnCol -= 1;
							} else {
								bnCol -= 1;
							}
							break;
						case 1 :
							if (node.bCol > node.rCol) {
								bnCol += 1;
							} else {
								rnCol += 1;
							}
							break;
						case 2 :
							if (node.rRow > node.bRow) {
								rnRow -= 1;
							} else {
								bnRow -= 1;
							}
							break;
						case 3 :
							if (node.rRow > node.bRow) {
								rnRow += 1;
							} else {
								bnRow += 1;
							}
							break;
					}
				}
				
				if (!visited[rnRow][rnCol][bnRow][bnCol]) {
					
					list.offer(new Node(rnRow,rnCol,bnRow,bnCol,node.cnt+1));
				}
			}
		}
		
	}
}
