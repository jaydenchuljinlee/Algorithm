package algorithm.simulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Boj1021 {
	private static int n,m;
	private static List<Integer> list;
	private static int ans,half,input; 
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		
		list = new ArrayList();
		
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		for (int i = 0; i < m; i++) {
			input = sc.nextInt();
			System.out.println("==============");
			while(true) {
				
				if (list.get(0) == input) {
					list.remove(0);
					System.out.println("list 출력"+list);
					break;
				}
				
				if (list.size() % 2 == 0) half = list.size()/2 -1;
				else half = list.size()/2;
				
				if (half - list.indexOf(input) >= 0) {
					System.out.print("왼쪽"+list.get(0)+" ");
					list.add(list.size()-1,list.remove(0));
					
				} else {
					System.out.print("오른쪽"+list.get(0)+" ");
					list.add(0,list.remove(list.size()-1));
					;
				}
				
				ans++;
			}
			System.out.println(ans);
		}
		
		
	}
}
