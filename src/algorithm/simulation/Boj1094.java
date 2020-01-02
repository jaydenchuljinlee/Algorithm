package algorithm.simulation;

public class Boj1094 {

	public static void solution(int X) {
		
		int original = 64;
		int answer = 0;
		
		while (true) {
			
			if (original == X) {
				answer += 1;
				break;
			}
			
			if (original > X) {
				
				original /=2;
				continue;
			} 

			original /=2;
			answer += 1;
		}
		
		System.out.println(answer);
	}
}
