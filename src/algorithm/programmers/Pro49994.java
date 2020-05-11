package algorithm.programmers;



/*
 * 2018 summer/winter conding
 * 방문 길이
 * */
public class Pro49994 {

    private static char[] dir;//이동할 방향에 대한 배열
    private static boolean[][][][] visited = new boolean[11][11][11][11];//이동하는 두 위치를 저장할 배열
    private static int x,y;

    public static int solution(String dirs) {

        int answer = 0;

        dir = new char[dirs.length()];

        for (int i = 0; i < dirs.length(); i++) dir[i] = dirs.charAt(i);

        x = 5;//지도의 중간으로 위치
        y = 5;

        for (int i = 0; i < dir.length; i++) {

            if (isPossible(dir[i])) {//이동이 가능한지 체크

                int cx = x;
                int cy = y;

                move(dir[i]);//이동할 방향으로 이동

                //System.out.println(cx + "," + cy + "->" + x + "," + y);
                visited[y][x][cy][cx] = true;//현재->다음 위치의 방문 체크
                visited[cy][cx][y][x] = true;//다음->현재 위치의 방문 체크

                answer++;
            } else {//이미 방문

                move(dir[i]);
            }

        }

        return answer;
    }

    private static void move(char dir) {

        switch(dir) {

            case 'U' :

                if (y-1 < 0) break;

                y-=1;

                break;
            case 'D' :

                if (y+1 == 11) break;

                y+=1;

                break;
            case 'R' :

                if (x+1 == 11) break;

                x+=1;

                break;
            case 'L' :

                if (x-1 < 0) break;

                x-=1;

                break;

        }
    }

    private static boolean isPossible(char dir) {

        switch(dir) {

            case 'U' :

                if (y-1 < 0 || visited[y][x][y-1][x]) return false;

                break;

            case 'D' :

                if (y+1 == 11 || visited[y][x][y+1][x]) return false;

                break;

            case 'R' :

                if (x+1 == 11 || visited[y][x][y][x+1]) return false;

                break;

            case 'L' :

                if (x-1 < 0 || visited[y][x][y][x-1]) return false;

                break;

        }

        return true;
    }
}
