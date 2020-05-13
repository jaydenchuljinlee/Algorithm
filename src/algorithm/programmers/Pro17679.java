package algorithm.programmers;

import java.util.*;

/*
 * 2018 KAKAO BLIND RECRUITMENT
 * [1차] 프렌즈 4블록
 * */
public class Pro17679 {

    public int solution(int m, int n, String[] board) {
        char[][] map = new char[n][m];

        for (int i = 0; i < board.length; i++) {//String에서 char 배열로 바꿔줌

            for (int j = 0; j < board[i].length(); j++) {

                map[j][i] = board[i].charAt(j);
            }
        }

        int answer = 0;

        boolean flag = true;

        while(flag) {

            flag = false;//지워줄 블록이 있는지 체크하기 위함

            int[][] visited = new int[n][m];//지워줄 블록을 표시해줄 배열

            //현재,아래,오른쪽,오른쪽 아래 블록을 검사
            //현재에서 +1칸을 검사하기 때문에 범위를 배열 길이-1로 잡아줌
            for (int i = 0; i < map.length-1; i++) {

                for (int j = 0; j < map[i].length-1; j++) {

                    if (map[i][j] == '0') continue;//비어있는 블록

                    //4블록 검사
                    if (map[i][j] == map[i+1][j] && map[i+1][j] == map[i+1][j+1]
                            && map[i][j+1] == map[i+1][j+1] && map[i][j+1] == map[i][j]) {

                        //지워줄 배열을 셋팅
                        visited[i][j]		= 1;
                        visited[i+1][j]		= 1;
                        visited[i+1][j+1]	= 1;
                        visited[i][j+1]		= 1;

                        flag = true;//지워줄 블록이 있으므로,
                    }
                }
            }

            //블록을 지우고, 비어있는 곳을 채워주는 작업
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j< visited[i].length; j++) {

                    if (visited[i][j] == 1) {//지워줄 블록이면

                        answer++;

                        for (int k = j-1; k >= 0; k--) {//현재 블록의 열에 해당하는 부분을 다시 셋팅

                            map[i][k+1] = map[i][k];
                            map[i][k] = '0';//비어있는 블록을 의미
                        }
                    }
                }
            }


        }
        return answer;
    }
}
