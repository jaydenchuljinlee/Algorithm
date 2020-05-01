package algorithm.programmers;

import java.util.*;
import java.io.*;


/*
* ���α׷��ӽ� 2019 īī�� ������ �ܿ� ���Ͻ�
* ũ���� ���� �̱� ����
* */
public class Pro64061 {

    private static int[][] board;

    public static int findMaxRow(int move,int col) {

        for (int row = col+1; row < board.length; row++) {//���� ����� �Ʒ��� Ž��

           if (board[row][move] != 0) return row;//�ش� ���� ��ȯ

        }

        return board.length;//���ٸ�, ������ ���̸� ��ȯ
    }

    public static int solution(int[][] Board, int[] moves) {
        int answer = 0;

        board = Board;

        Stack<Integer> s = new Stack<>();

        int len = board.length;

        int[] col = new int[len];//0�� �ƴ� ���� ���� ĭ�� ������ �迭

        for (int i = 0; i < len; i++) {

            col[i] = findMaxRow(i,-1);//���� ���� ĭ ã��
            //System.out.println(col[i]);
        }

        for (int move : moves) {//�̵��� ��

            if (col[move-1] == len) continue;//�ش� ĭ�� ��� 0���� ������ ���̷� ǥ��

            if (board[col[move-1]][move-1] == 0 && col[move-1]+1 == len) continue;// ���� ������ ĭ�̰�, 0�� ��

            if (board[col[move-1]][move-1] != 0) {// ���� ĭ�� 0�� �ƴ� ���� ������ �ִٸ�

                //System.out.println(board[col[move-1]][move-1]);
                //System.out.println(s);
                //System.out.println();

                if (!s.empty() && s.peek() == board[col[move-1]][move-1]) {//������ ������� �ʰ�, ���� ������ �� �� ���� ���� ��

                    s.pop();//���� �� ���� ������ �̰�
                    answer+=2;//��� ���� ������ ������ ������ ����, �� 2���� �߰�

                    board[col[move-1]][move-1] = 0;//���� ������ ���� �ڸ��� 0���� ����� �ش�.
                } else {//������ ����ְų� ������ ���� ������ �ٸ� ���

                    s.push(board[col[move-1]][move-1]);//���ÿ� ������ �߰�
                }
            }

           int row = findMaxRow(move-1,col[move-1]);//���� �����ִ� ���� ã��

            col[move-1] = row;//�ش� ������ �ִ� ���� �ٽ� ĭ �迭�� �������� ���ش�.
        }

        return answer;
    }

    public static void print() {

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {

                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
