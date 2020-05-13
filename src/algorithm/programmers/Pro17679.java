package algorithm.programmers;

import java.util.*;

/*
 * 2018 KAKAO BLIND RECRUITMENT
 * [1��] ������ 4���
 * */
public class Pro17679 {

    public int solution(int m, int n, String[] board) {
        char[][] map = new char[n][m];

        for (int i = 0; i < board.length; i++) {//String���� char �迭�� �ٲ���

            for (int j = 0; j < board[i].length(); j++) {

                map[j][i] = board[i].charAt(j);
            }
        }

        int answer = 0;

        boolean flag = true;

        while(flag) {

            flag = false;//������ ����� �ִ��� üũ�ϱ� ����

            int[][] visited = new int[n][m];//������ ����� ǥ������ �迭

            //����,�Ʒ�,������,������ �Ʒ� ����� �˻�
            //���翡�� +1ĭ�� �˻��ϱ� ������ ������ �迭 ����-1�� �����
            for (int i = 0; i < map.length-1; i++) {

                for (int j = 0; j < map[i].length-1; j++) {

                    if (map[i][j] == '0') continue;//����ִ� ���

                    //4��� �˻�
                    if (map[i][j] == map[i+1][j] && map[i+1][j] == map[i+1][j+1]
                            && map[i][j+1] == map[i+1][j+1] && map[i][j+1] == map[i][j]) {

                        //������ �迭�� ����
                        visited[i][j]		= 1;
                        visited[i+1][j]		= 1;
                        visited[i+1][j+1]	= 1;
                        visited[i][j+1]		= 1;

                        flag = true;//������ ����� �����Ƿ�,
                    }
                }
            }

            //����� �����, ����ִ� ���� ä���ִ� �۾�
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j< visited[i].length; j++) {

                    if (visited[i][j] == 1) {//������ ����̸�

                        answer++;

                        for (int k = j-1; k >= 0; k--) {//���� ����� ���� �ش��ϴ� �κ��� �ٽ� ����

                            map[i][k+1] = map[i][k];
                            map[i][k] = '0';//����ִ� ����� �ǹ�
                        }
                    }
                }
            }


        }
        return answer;
    }
}
