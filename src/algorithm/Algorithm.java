package algorithm;

import java.util.*;

public class Algorithm {
    private static int R,C;
    private static char[][] map;
    private static int[] dir = {-1,0,1};//오른쪽 라인을 검사해주기 위함
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

        //윗줄부터 R번째 줄까지 라인 검사
        for (int i = 0; i < R; i++) dfs(i,0);

        System.out.println(answer);

	}

    //라인 검사
	public static boolean dfs(int x, int y) {

	    //끝 라인까지 왔을 때
        if (y == width-1) {

            answer++;//연결 갯수를 추가
            return true;
        }

        //오른쪽 라인의 대각선 위, 옆,대각선 아래를 검사
        for (int i = 0; i < 3; i++) {

            int nx = x + dir[i];
            int ny = y + 1;

            //범위 밖
            if (nx < 0 || ny < 0 || nx == R || ny == C) continue;

            //못지나는 곳
            if (map[nx][ny] == 'x') continue;

            //방문했음을 표시
            map[nx][ny] = 'x';

            //다음 라인 검사
            //라인의 가지치기를 방지하기 위해 true를 리턴한다.
            //true를 리턴하면 다음 분기문으로 넘어가지 않는다.
            if (dfs(nx,ny)) return true;

        }

        return false;
    }
}
