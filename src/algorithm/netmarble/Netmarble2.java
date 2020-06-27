package algorithm.netmarble;

public class Netmarble2 {

    /*
    * int[] target = {2,2,2,2,2};

        int[][] positions = {{0,0},{0,1},{1,1},{-3,5},{7,5},{10,0},{-15,22},{-6,-5},{3,3},{5,-5}};
    * */

    public static int solution(int[] target, int[][] positions) {
        int answer = 0;

        for (int i = 1; i < target.length; i++) {

            target[i] += target[i-1];
        }

        int[][] board = new int[2*target[target.length-1]+1][2*target[target.length-1]+1];

        int len = board.length;

        int mid = target[target.length-1];

        int score = 10;

        for (int a : target) {

            for (int i = mid - a; i <= mid + a;i++) {

                for (int j = mid - a; j <= mid + a; j++) {

                    if (board[i][j] != 0) continue;

                    double d = Math.sqrt(Math.pow(mid-i,2) + Math.pow(mid-j,2));

                    if (d > a) continue;

                    board[i][j] = score;
                }
            }

            score -= 2;
        }

        for (int[] pos : positions) {

            int x = pos[0]+mid;
            int y = pos[1]+mid;

            if (x < 0 || y < 0 || x >= len || y >= len) continue;

            answer += board[x][y];
        }

        return answer;
    }
}
