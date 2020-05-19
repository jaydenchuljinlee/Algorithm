package algorithm.kakao;

import java.util.*;

/*
* 2020 īī�� ����ε� �ڵ��׽�Ʈ
* �ڹ���� ����
* */
public class Pro60059 {
    private static int n,m;

    public static boolean solution(int[][] key, int[][] lock) {

        n = lock.length;//Ű�� ����
        m = key.length;//�ڹ����� ����

        //�ڹ���� Ű�� ������ üũ
        int lockCnt = checkLen(lock);
        int keyCnt  = checkLen(key);

        if (lockCnt == n && keyCnt == 0) return true;//�ڹ����� ���Ⱑ ��� 1�̰� Ű�� ���Ⱑ ��� 0�� ���
        else if (lockCnt == n && keyCnt > 0) return false;//�ڹ����� ���Ⱑ ��� 1�̰� Ű�� ���Ⱑ �ϳ��� 1�� ���

        int[][] map = new int[n*3][n*3];//�ڹ����� ���̸�ŭ ���� �÷��ش�.

        for (int i = 0; i < n; i++) {//�÷��� ���� �߰��� �ڹ��踦 ��ġ�����ش�.

            for (int j = 0; j < n ;j++) {

                map[n+i][n+j] = lock[i][j];
            }
        }

        boolean flag = false;//����� ��ȯ�� ����

        int[][] rotateKey = new int[m][m];//Ű�� ȸ���� �迭

        outter : for (int dir = 0; dir < 4; dir++) {//ȸ�� �����

            if (dir == 0) rotateKey = key;//ù ȸ���� ��
            else rotateKey = rotate(rotateKey);//Ű�� ȸ��

            for (int i = 0; i < map.length - m; i++) {//0���� �ڹ������ ������

                for (int j = 0; j < map.length - m; j++) {

                    flag = checkLock(i,j,rotateKey,map);//ȸ���� Ű�� �ڹ���� ���纻��
                    if (flag) break outter;//�ڹ��踦 Ǯ �� ������ true ����

                }
            }
        }

        return flag;
    }

    //�ڹ��踦 Ǯ �� �ִ��� üũ
    private static boolean checkLock(int y, int x, int[][] key, int[][] lock) {

        int[][] clone = new int[lock.length][lock.length];//�÷��� �¹��踦 ����

        for (int i = 0; i < clone.length; i++) clone[i] = lock[i].clone();

        for (int i = 0; i < m; i++) {//Ű�� ���̸�ŭ �˻�

            for (int j = 0; j < m; j++) {

                if (key[i][j] == 1) {//Ű�� ���Ⱑ 1�̰�

                    if (lock[y+i][x+j] == 1) return false;//�ڹ����� ���⵵ 1�̸� false

                    clone[y+i][x+j] = key[i][j];//�ڹ����� ������ �κ��� üũ�ϱ� ����
                }
            }
        }

        if (check(clone)) return true;//�ڹ��踦 üũ

        return false;
    }

    //�ڹ��� üũ
    private static boolean check(int[][] lock) {

        for (int i = n; i < lock.length - n; i++) {

            for (int j = n; j < lock.length - n; j++) {

                if (lock[i][j] != 1) return false;//�ڹ��谡 �� ������ ���Ⱑ 1�� �ƴϸ� false
            }
        }

        return true;
    }

    //���� üũ
    private static int checkLen(int[][] item) {

        int cnt = 0;

        for (int i = 0; i < item.length; i++) {

            for (int j = 0; j < item.length; j++) {

                if (item[i][j] == 1) cnt++;
            }
        }

        return cnt;
    }

    //Ű ȸ��
    private static int[][] rotate(int[][] key) {

        int[][] clone = new int[m][m];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < m; j++) {

                clone[i][j] = key[(m-1)-j][i];//90�� �ð�������� ȸ������ �� ��ġ�� ��ǥ
            }
        }

        return clone;
    }
}
