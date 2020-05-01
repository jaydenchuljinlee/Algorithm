package algorithm.stringAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Boj1764 {
	private static int n,m;
	private static HashMap<String,Integer> map;
	private static ArrayList<String> result;
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		map = new HashMap();
		
		for (int i = 0; i < n; i++) {
			
			String str = sc.nextLine();
			
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		
		for (int i = 0; i < m; i++) {
			
			String str = sc.nextLine();
			
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		
		result = new ArrayList();
		
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()) {
			
			String key = it.next();
			
			if (map.get(key) > 1) result.add(key);
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for (String str : result) {
			System.out.println(str);
		}
	}
}
