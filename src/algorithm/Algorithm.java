package algorithm;

import java.util.*;

public class Algorithm {
    private static int R,C;
    private static char[][] map;
    private static int[] dir = {-1,0,1};//������ ������ �˻����ֱ� ����
    private static int width,answer;

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        sc.nextLine();

        map = new char[R][C];

        for (int i = 0; i < R; i++) {

            map[i] = sc.nextLine().toCharArray();

        }

        width = C;
        answer = 0;

        //���ٺ��� R��° �ٱ��� ���� �˻�
        for (int i = 0; i < R; i++) dfs(i,0);

        System.out.println(answer);

	}

    //���� �˻�
	public static boolean dfs(int x, int y) {

	    //�� ���α��� ���� ��
        if (y == width-1) {

            answer++;//���� ������ �߰�
            return true;
        }

        //������ ������ �밢�� ��, ��,�밢�� �Ʒ��� �˻�
        for (int i = 0; i < 3; i++) {

            int nx = x + dir[i];
            int ny = y + 1;

            //���� ��
            if (nx < 0 || ny < 0 || nx == R || ny == C) continue;

            //�������� ��
            if (map[nx][ny] == 'x') continue;

            //�湮������ ǥ��
            map[nx][ny] = 'x';

            //���� ���� �˻�
            //������ ����ġ�⸦ �����ϱ� ���� true�� �����Ѵ�.
            //true�� �����ϸ� ���� �б⹮���� �Ѿ�� �ʴ´�.
            if (dfs(nx,ny)) return true;

        }

        return false;
    }
}
