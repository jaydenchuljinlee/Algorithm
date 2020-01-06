package algorithm.backTracking;

import java.util.Scanner;

public class Boj2580 {
	private static int[][] sdoku = new int[9][9];
	private static int currentRow;
	private static int currentCol;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
				sdoku[i][j] = sc.nextInt();
			}
		}
		
		DFS();
	}
	
	private static boolean DFS() {
		
		int r;
		int c;
		
		if (findEmpty()) {
			return true;
		}
		
		r = currentRow;
		c = currentCol;
		
		for (int i = 0; i < 9; i++) {

			if (isSafe(i,r,c)) {
				sdoku[r][c] = i;
				
				if (DFS()) {
					return true;
				}
				
				sdoku[r][c] = 0;
			}
		}
		
		return false;
	}
	private static boolean isSafe(int i, int r, int c) {

		if (checkRow(r,i) && checkCol(c,i) && checkBox(r,c,i)) {
			
			return true;
		}
		
		return false;
	}
	private static boolean checkBox(int r, int c, int i) {

		int row = (int)Math.ceil((r/3.0)-1) *3 +1;
		int col = (int)Math.ceil((c/3.0)-1) *3 +1;
		
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				
				if (sdoku[row+j][col+k] == i) return false;
			}
		}
		
		return true;
	}
	private static boolean checkCol(int c, int i) {

		for (int j = 1; j <= 9; j++) {
		      
			if (sdoku[j][c] == i) return false; 
	      }
		
		return true;
	}
	private static boolean checkRow(int r, int i) {

		for (int j = 1; j <= 9; j++) {
		      
			if (sdoku[r][j] == i) return false; 
	      }
		
		return true;
	}
	private static boolean findEmpty() {
		
		for (int i = 1; i <= 9; i++) {
		      for (int j = 1; j <= 9; j++) {
		        if (sdoku[i][j] == 0) {
		          currentRow = i;
		          currentCol = j;
		          return false;
		        }
		      }
		}
		return false;
	}
}
