package algorithm.simulation;

import java.util.Scanner;

public class Boj5537 {
	private static char[][][] early = {{{'w','w','w'},{'w','w','w'},{'w','w','w'}},//U
									{{'y','y','y'},{'y','y','y'},{'y','y','y'}},//D
									{{'r','r','r'},{'r','r','r'},{'r','r','r'}},//F
									{{'o','o','o'},{'o','o','o'},{'o','o','o'}},//B
									{{'g','g','g'},{'g','g','g'},{'g','g','g'}},//L
									{{'b','b','b'},{'b','b','b'},{'b','b','b'}}};//R
	
	private static char[][][] cube = {};
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		cube = new char[3][3][3];
		
		while(t > 0) {
			
			int count = sc.nextInt();
			
			sc.nextLine();
			
			String[] str = sc.nextLine().split(" ");
			
			char[] part = new char[count];//��,�Ʒ�,��,��,����,������ 
			char[] dir  = new char[count];//�ð�,�ݽð�
			
			//part,dir�� �̵��� ���� �߰� 
			for (int i = 0; i < count; i++) {
				
				part[i] = str[i].charAt(0);
				dir[i] = str[i].charAt(1);
			}
			
			//ť�� �ʱ�ȭ
			cube = init();
			
			//�̵� Ƚ����ŭ �̵�
			for (int i = 0; i < count; i++) {
				
				//rotate(part[i],dir[i]);
			}
			
			t--;
		}
		
	}

	private static char[][][] init() {
		
		char[][][] copyCube = new char[3][3][3];
		
		for (int i = 0; i < 3; i++) {
			
			for (int j = 0; j < 3; j++) {
				
				for (int k = 0; k < 3; k++) {
					
					copyCube[k][j][i] = early[k][j][i];
				}
			}
		}
		
		return null;
	}
}
