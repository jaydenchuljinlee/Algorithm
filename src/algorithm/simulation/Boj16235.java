package algorithm.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Boj16235 {
	private static int[] dr = {-1,-1,-1,0,0,1,1,1};
	private static int[] dc = {-1,0,1,-1,1,-1,0,1};
	
	private static class Tree {
		int r;
		int c;
		int age;
		
		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		} 
		
	}
	
	private static String treeJaeTech(int n, int m, int k, int[][] food, int[][] treesInfo) {

		int answer = 0;
		
		int[][] land = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				
				land[i][j] = 5;
			}
		}
		
		ArrayList<Tree> list = new ArrayList<>();
		
		for (int i = 0; i < treesInfo.length; i++) {
			
			int r = treesInfo[i][0]-1;
			int c = treesInfo[i][1]-1;
			int z = treesInfo[i][2];
			
			list.add(new Tree(r,c,z));
		}
		
		for (int year = 0; year < k; year++) {
			//System.out.println((year+1)+"년째 =============");
			ArrayList<Tree> diedTree  = new ArrayList<>();
			ArrayList<Tree> breedTree = new ArrayList<>();
			
			//봄
			
			Iterator<Tree> it = list.iterator();
			
			int idx = -1;
			
			while(it.hasNext()) {
				
				idx++;
				
				Tree tree = it.next();
				
				if (land[tree.c][tree.r] < tree.age) {
					
					diedTree.add(tree);
					it.remove();
					idx--;
					continue;
				} 
				
				land[tree.c][tree.r] -= tree.age;
				
				tree.age++;
				//System.out.print("나무 나이 " + tree.age);
				if (tree.age%5 == 0) breedTree.add(tree);
				
				list.get(idx).age = tree.age;
			}
			
			//System.out.println();
			
			//여름
			for (int i = 0; i < diedTree.size(); i++) {
				
				Tree died = diedTree.get(i);
				
				land[died.c][died.r] += (died.age/2);
			}
			
			//가을
			for (int i = 0; i < breedTree.size(); i++) {
				
				Tree breeding = breedTree.get(i);
				
				int cr = breeding.r;
				int cc = breeding.c;
				//System.out.println("현재 : (" + cr + "," + cc + ")");
				for (int j = 0; j < 8; j++) {
					
					int nr = cr + dr[j];
					int nc = cc + dc[j];
					
					if (nr < 0 || nc < 0 || nr == n || nc == n) continue;
					
					int loc = nr*5 + nc;
					
					list.add(new Tree(nr,nc,1));
				}
				
			}
			
			Collections.sort(list, new Comparator<Tree>() {

				@Override
				public int compare(Tree o1, Tree o2) {
					
					return o1.age - o2.age;
				}
				
				
			});
			
			//겨울
			for (int i = 0; i < n; i++) {
				
				for (int j = 0; j < n; j++) {
					
					land[i][j] += food[i][j];
				}
			}
			
		}
		
		
		
		return String.valueOf(list.size());
	}

	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		sc.nextLine();
		
		int[][] food = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			
			String[] str = sc.nextLine().split(" ");
			
			for (int j = 0; j < n; j++) {
				
				food[j][i] = Integer.parseInt(str[j]);
			}
		}
		
		int[][] treesInfo = new int[m][3];
		
		for (int i = 0; i < m; i++) {
			
			String[] str = sc.nextLine().split(" ");
			
			for (int j = 0; j < 3; j++) {
				
				treesInfo[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		System.out.println(treeJaeTech(n,m,k,food,treesInfo));
	}

	
}
