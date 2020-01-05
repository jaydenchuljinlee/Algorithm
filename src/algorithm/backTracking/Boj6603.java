package algorithm.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Boj6603 {
	private static int N;
	private static int[] arr;
	private static boolean[] result;

	public static void solution() throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			
			if (N == 0) break;
			
			arr = new int[N];
			result = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			
			
			for (int i = (1<<N)-1; i>=0;i--) {
				
				int bit = i;
				int cnt = 0;
				
				Arrays.fill(result, false);
				
				for (int j = 0; bit != 0; j++ ,j <<= 1) {
					
					if ((bit&1) == 0) continue;
					
					cnt++;
					result[(N-1)-j] = true;
				}
				
				if (cnt == 6) {
					
					for (int j = 0; j < result.length; j++) {
						
						if (result[j]) 
							System.out.print(arr[j] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
		} 
	}
}
