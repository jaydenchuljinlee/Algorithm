package algorithm.programmers;

import java.util.*;

/*
 * 2019 카카오 블라인드
 * 블록 게임
 *
 * */
public class Pro42894 {
    private static int[][] board;//게임 맵
    private static int[] maxRow;//해당 구간중 가장 위에 있는 row 값
    private static int len;

    //블록의 좌표
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

        //각 column당 가장 높은 값을 담는다.
        for (int i = 0; i < len; i++) setMaxRow(i);

        int cnt = 1;

        while(cnt>0) {//지울 수 있는 블록이 1개보다 많을 때까지

            cnt = 0;

            //각 column을 기준으로 수평블록인지 수직블록인지 검사한다.
            for (int i = 0; i < len; i++) {

                cnt += checkHorizon(i);
                cnt += checkVertical(i);
            }

            answer += cnt;//지워준 블록의 갯수를 결과 값에 추가
        }

        return answer;
    }

    //수직으로 긴 블록을 검사
    private static int checkVertical(int col) {

        if (col+1 >= len) return 0;//현재 컬럼 기준 +1 위치가 맵 밖이라면 종료

        int maxR = Math.max(maxRow[col], maxRow[col+1]);//현재컬럼과 현재컬럼+1블록 중 가장 위에있는 블록

        if (maxR-2<0 || maxR>=len) return 0;//수직블록이므로 row가 현재기준 -2보다 작거나 maxR이 맵 범위 밖에있으면 안된다.

        int zero 	= 0;//비어있는 블록을 검사
        int block	= board[maxR][col];//현재 가장 위에있는 블록의 값

        ArrayList<Dot> remove = new ArrayList<>();//지워줄 리스트

        for (int i = maxR-2; i <= maxR; i++) {//수직블록은 위로 3개를 검사하므로

            for (int j = col; j <= col+1; j++) {//수직블록은 옆으로 2개를 검사하므로

                if (board[i][j] != 0 && board[i][j] != block) return 0;//0이 아니면서 현재 블록 값과 다를 때,

                if (board[i][j] == 0) zero++;//비어있는 블록을 추가
                else remove.add(new Dot(i,j));//지워줄 리스트에 블록 위치 추가
            }
        }

        if (zero != 2) return 0;//수직 블록의 비어있는 값이 2개 일 때, 지워줄 수 있다.

        for (Dot d : remove) board[d.x][d.y] = 0;//현재 지워지는 블록들의 위치를 0으로 만든다.

        setMaxRow(col);//현재 블록들의 maxR을 재설정
        setMaxRow(col+1);

        return 1;//하나의 블록을 지웠으므로 1 리턴
    }

    //수평 블록
    private static int checkHorizon(int col) {

        if (col+2 >= len) return 0;//수평 블록은 옆으로 3개를 검사하므로

        int row1 = maxRow[col];
        int row2 = maxRow[col+1];
        int row3 = maxRow[col+2];

        int maxR = Math.max(row1, Math.max(row2, row3));//3개의 column중 가장 위에 있는 row를 확인

        int sameRow = 0;//수평 블록은 같은 row가 2개가 있으므로 이를 검사하기 위함

        if (row1 == maxR) sameRow++;
        if (row2 == maxR) sameRow++;
        if (row3 == maxR) sameRow++;

        if (sameRow != 2 || maxR-1 < 0 || maxR >= len) return 0;//같은 블록이 2개가 아니거나, maxR이 범위 밖일 경우 종료

        int zero 	= 0;
        int block	= board[maxR][col];

        ArrayList<Dot> remove = new ArrayList<>();

        for (int i = maxR-1; i <= maxR; i++) {//수평블록은 위로 2개를 검사

            for (int j = col; j <= col+2; j++) {//수평블록은 옆으로 3개를 검사

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

    //maxR을 구하는 메서드
    private static void setMaxRow(int col) {

        int i = 0;

        for (i = 0; i < len; i++) {//map의 해당 컬럼의 제일 위부터 0이 아닌 값이 나올 때까지 검사

            if (board[i][col] != 0) break;
        }

        maxRow[col] = i;//0이 아닌 값이 나왔을 때, 해당 인덱스를 maxR에 저장
    }
}
