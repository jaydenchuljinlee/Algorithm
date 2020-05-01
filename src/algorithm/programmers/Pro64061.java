package algorithm.programmers;

import java.util.*;
import java.io.*;


/*
* 프로그래머스 2019 카카오 개발자 겨울 인턴십
* 크레인 인형 뽑기 문제
* */
public class Pro64061 {

    private static int[][] board;

    public static int findMaxRow(int move,int col) {

        for (int row = col+1; row < board.length; row++) {//현재 행부터 아래로 탐색

           if (board[row][move] != 0) return row;//해당 행을 반환

        }

        return board.length;//없다면, 보드의 길이를 반환
    }

    public static int solution(int[][] Board, int[] moves) {
        int answer = 0;

        board = Board;

        Stack<Integer> s = new Stack<>();

        int len = board.length;

        int[] col = new int[len];//0이 아닌 가장 높은 칸을 저장할 배열

        for (int i = 0; i < len; i++) {

            col[i] = findMaxRow(i,-1);//가장 높은 칸 찾기
            //System.out.println(col[i]);
        }

        for (int move : moves) {//이동할 행

            if (col[move-1] == len) continue;//해당 칸이 모두 0임을 보드의 길이로 표현

            if (board[col[move-1]][move-1] == 0 && col[move-1]+1 == len) continue;// 현재 마지막 칸이고, 0일 때

            if (board[col[move-1]][move-1] != 0) {// 현재 칸이 0이 아닌 값을 가지고 있다면

                //System.out.println(board[col[move-1]][move-1]);
                //System.out.println(s);
                //System.out.println();

                if (!s.empty() && s.peek() == board[col[move-1]][move-1]) {//스택이 비어있지 않고, 현재 스택의 맨 위 값과 같을 때

                    s.pop();//스택 맨 위에 인형을 뽑고
                    answer+=2;//결과 값에 보드의 인형과 스택의 인형, 총 2개를 추가

                    board[col[move-1]][move-1] = 0;//현재 인형을 뽑은 자리를 0으로 만들어 준다.
                } else {//스택이 비어있거나 스택의 맨위 인형과 다를 경우

                    s.push(board[col[move-1]][move-1]);//스택에 인형을 추가
                }
            }

           int row = findMaxRow(move-1,col[move-1]);//가장 위에있는 인형 찾기

            col[move-1] = row;//해당 인형이 있는 행을 다시 칸 배열에 리프레시 해준다.
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
