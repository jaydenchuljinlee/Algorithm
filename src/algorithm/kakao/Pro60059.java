package algorithm.kakao;

import java.util.*;

/*
* 2020 카카오 블라인드 코딩테스트
* 자물쇠와 열쇠
* */
public class Pro60059 {
    private static int n,m;

    public static boolean solution(int[][] key, int[][] lock) {

        n = lock.length;//키의 길이
        m = key.length;//자물쇠의 길이

        //자물쇠와 키의 갯수를 체크
        int lockCnt = checkLen(lock);
        int keyCnt  = checkLen(key);

        if (lockCnt == n && keyCnt == 0) return true;//자물쇠의 돌기가 모두 1이고 키의 돌기가 모두 0인 경우
        else if (lockCnt == n && keyCnt > 0) return false;//자물쇠의 돌기가 모두 1이고 키의 돌기가 하나라도 1인 경우

        int[][] map = new int[n*3][n*3];//자물쇠의 길이만큼 맵을 늘려준다.

        for (int i = 0; i < n; i++) {//늘려준 맵의 중간에 자물쇠를 위치시켜준다.

            for (int j = 0; j < n ;j++) {

                map[n+i][n+j] = lock[i][j];
            }
        }

        boolean flag = false;//결과를 반환할 변수

        int[][] rotateKey = new int[m][m];//키를 회전할 배열

        outter : for (int dir = 0; dir < 4; dir++) {//회전 방향수

            if (dir == 0) rotateKey = key;//첫 회전일 때
            else rotateKey = rotate(rotateKey);//키를 회전

            for (int i = 0; i < map.length - m; i++) {//0부터 자물쇠길이 전까지

                for (int j = 0; j < map.length - m; j++) {

                    flag = checkLock(i,j,rotateKey,map);//회전한 키를 자물쇠와 맞춰본다
                    if (flag) break outter;//자물쇠를 풀 수 있으면 true 리턴

                }
            }
        }

        return flag;
    }

    //자물쇠를 풀 수 있는지 체크
    private static boolean checkLock(int y, int x, int[][] key, int[][] lock) {

        int[][] clone = new int[lock.length][lock.length];//늘려준 좌물쇠를 복사

        for (int i = 0; i < clone.length; i++) clone[i] = lock[i].clone();

        for (int i = 0; i < m; i++) {//키의 길이만큼 검사

            for (int j = 0; j < m; j++) {

                if (key[i][j] == 1) {//키의 돌기가 1이고

                    if (lock[y+i][x+j] == 1) return false;//자물쇠의 돌기도 1이면 false

                    clone[y+i][x+j] = key[i][j];//자물쇠의 나머지 부분을 체크하기 위함
                }
            }
        }

        if (check(clone)) return true;//자물쇠를 체크

        return false;
    }

    //자물쇠 체크
    private static boolean check(int[][] lock) {

        for (int i = n; i < lock.length - n; i++) {

            for (int j = n; j < lock.length - n; j++) {

                if (lock[i][j] != 1) return false;//자물쇠가 한 군데라도 돌기가 1이 아니면 false
            }
        }

        return true;
    }

    //길이 체크
    private static int checkLen(int[][] item) {

        int cnt = 0;

        for (int i = 0; i < item.length; i++) {

            for (int j = 0; j < item.length; j++) {

                if (item[i][j] == 1) cnt++;
            }
        }

        return cnt;
    }

    //키 회전
    private static int[][] rotate(int[][] key) {

        int[][] clone = new int[m][m];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < m; j++) {

                clone[i][j] = key[(m-1)-j][i];//90도 시계방향으로 회전했을 때 위치할 좌표
            }
        }

        return clone;
    }
}
