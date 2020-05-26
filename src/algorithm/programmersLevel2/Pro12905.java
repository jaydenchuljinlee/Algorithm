package algorithm.programmersLevel2;

/*
* 프로그래머스
* 가장 큰 정사각형 찾기
* */
public class Pro12905 {

    public int solution(int [][]board) {

        int width  = board[0].length;
        int height = board.length;

        int max = 0;

        if (width == 1 || height == 1) return 1;

        for (int i = 1; i < height; i++) {

            for (int j = 1; j < width; j++) {

                if (board[i][j] == 1) {

                    int min = Math.min(Math.min(board[i-1][j-1],board[i][j-1]),board[i-1][j]);
                    min++;

                    board[i][j] = min;

                    if (max < min*min) max = min*min;


                }
            }
        }

        return max;
    }
}
