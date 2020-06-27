package algorithm;

import java.util.*;

public class Algorithm {

    private static int[] dx = {-1,0,1,-1,1,-1,0,1};
    private static int[] dy = {-1,-1,-1,0,0,1,1,1};

    private static class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    public static String[] solution(String[] board, int y, int x) {

        int yLen = board.length;
        int xLen = board[0].length();

        char[][] Board = new char[xLen][yLen];
        boolean[][] actived = new boolean[xLen][yLen];

        for (int i = 0; i < yLen; i++) {

            for (int j = 0; j < xLen; j++) {

                Board[j][i] = board[i].charAt(j);
            }
        }

        Queue<Dot> q = new LinkedList<>();

        ((LinkedList<Dot>) q).add(new Dot(x,y));

        while (!q.isEmpty()) {

            Dot d = q.poll();

            int mcnt = 0;

            Queue<Dot> sub = new LinkedList<>();

            for (int i = 0; i < 8; i++) {

                int nx = d.x + dx[i];
                int ny = d.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= xLen || ny >= yLen) continue;

                if (Board[nx][ny] != 'E') {

                    if (Board[nx][ny] == 'M') mcnt++;

                    actived[d.x][d.y] = true;
                    Board[d.x][d.y] = 'B';
                    continue;
                }

                ((LinkedList<Dot>) sub).add(new Dot(nx,ny));
            }

            if (mcnt > 0) Board[d.x][d.y] = (char)(mcnt + '0');
            else {

                while (!sub.isEmpty()) ((LinkedList<Dot>) q).add(sub.poll());
            }

        }

        String[] answer = new String[yLen];

        Arrays.fill(answer,"");

        for (int i = 0; i < yLen; i++) {

            for (int j = 0; j < xLen; j++) {

                if (!actived[j][i]) answer[i] += 'E';
                else answer[i] += Board[j][i];
            }

            System.out.println(answer[i]);
        }

        return answer;
    }


    public static void main(String[] args)throws Exception {

        String[] board = new String[] {"EEEEE","EEMEE","EEEEE","EEEEE"};



        solution(board,2,0);

        //System.out.println(solution(25));

    }

}
