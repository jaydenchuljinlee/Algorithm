package algorithm.programmers;

import java.util.*;

/*
 * 2019 īī�� ����ε�
 * ��� ����
 *
 * */
public class Pro42894 {
    private static int[][] board;//���� ��
    private static int[] maxRow;//�ش� ������ ���� ���� �ִ� row ��
    private static int len;

    //����� ��ǥ
    private static class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static int solution(int[][] Board) {
        int answer = 0;

        board = Board;
        len = board.length;

        maxRow = new int[len];

        //�� column�� ���� ���� ���� ��´�.
        for (int i = 0; i < len; i++) setMaxRow(i);

        int cnt = 1;

        while(cnt>0) {//���� �� �ִ� ����� 1������ ���� ������

            cnt = 0;

            //�� column�� �������� ���������� ����������� �˻��Ѵ�.
            for (int i = 0; i < len; i++) {

                cnt += checkHorizon(i);
                cnt += checkVertical(i);
            }

            answer += cnt;//������ ����� ������ ��� ���� �߰�
        }

        return answer;
    }

    //�������� �� ����� �˻�
    private static int checkVertical(int col) {

        if (col+1 >= len) return 0;//���� �÷� ���� +1 ��ġ�� �� ���̶�� ����

        int maxR = Math.max(maxRow[col], maxRow[col+1]);//�����÷��� �����÷�+1��� �� ���� �����ִ� ���

        if (maxR-2<0 || maxR>=len) return 0;//��������̹Ƿ� row�� ������� -2���� �۰ų� maxR�� �� ���� �ۿ������� �ȵȴ�.

        int zero 	= 0;//����ִ� ����� �˻�
        int block	= board[maxR][col];//���� ���� �����ִ� ����� ��

        ArrayList<Dot> remove = new ArrayList<>();//������ ����Ʈ

        for (int i = maxR-2; i <= maxR; i++) {//��������� ���� 3���� �˻��ϹǷ�

            for (int j = col; j <= col+1; j++) {//��������� ������ 2���� �˻��ϹǷ�

                if (board[i][j] != 0 && board[i][j] != block) return 0;//0�� �ƴϸ鼭 ���� ��� ���� �ٸ� ��,

                if (board[i][j] == 0) zero++;//����ִ� ����� �߰�
                else remove.add(new Dot(i,j));//������ ����Ʈ�� ��� ��ġ �߰�
            }
        }

        if (zero != 2) return 0;//���� ����� ����ִ� ���� 2�� �� ��, ������ �� �ִ�.

        for (Dot d : remove) board[d.x][d.y] = 0;//���� �������� ��ϵ��� ��ġ�� 0���� �����.

        setMaxRow(col);//���� ��ϵ��� maxR�� �缳��
        setMaxRow(col+1);

        return 1;//�ϳ��� ����� �������Ƿ� 1 ����
    }

    //���� ���
    private static int checkHorizon(int col) {

        if (col+2 >= len) return 0;//���� ����� ������ 3���� �˻��ϹǷ�

        int row1 = maxRow[col];
        int row2 = maxRow[col+1];
        int row3 = maxRow[col+2];

        int maxR = Math.max(row1, Math.max(row2, row3));//3���� column�� ���� ���� �ִ� row�� Ȯ��

        int sameRow = 0;//���� ����� ���� row�� 2���� �����Ƿ� �̸� �˻��ϱ� ����

        if (row1 == maxR) sameRow++;
        if (row2 == maxR) sameRow++;
        if (row3 == maxR) sameRow++;

        if (sameRow != 2 || maxR-1 < 0 || maxR >= len) return 0;//���� ����� 2���� �ƴϰų�, maxR�� ���� ���� ��� ����

        int zero 	= 0;
        int block	= board[maxR][col];

        ArrayList<Dot> remove = new ArrayList<>();

        for (int i = maxR-1; i <= maxR; i++) {//�������� ���� 2���� �˻�

            for (int j = col; j <= col+2; j++) {//�������� ������ 3���� �˻�

                if (board[i][j] != 0 && board[i][j] != block) return 0;

                if (board[i][j] == 0) zero++;
                else remove.add(new Dot(i,j));
            }
        }

        if (zero != 2) return 0;

        for (Dot d : remove) board[d.x][d.y] = 0;

        setMaxRow(col);
        setMaxRow(col+1);
        setMaxRow(col+2);

        return 1;
    }

    //maxR�� ���ϴ� �޼���
    private static void setMaxRow(int col) {

        int i = 0;

        for (i = 0; i < len; i++) {//map�� �ش� �÷��� ���� ������ 0�� �ƴ� ���� ���� ������ �˻�

            if (board[i][col] != 0) break;
        }

        maxRow[col] = i;//0�� �ƴ� ���� ������ ��, �ش� �ε����� maxR�� ����
    }
}
