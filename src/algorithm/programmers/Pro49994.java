package algorithm.programmers;



/*
 * 2018 summer/winter conding
 * �湮 ����
 * */
public class Pro49994 {

    private static char[] dir;//�̵��� ���⿡ ���� �迭
    private static boolean[][][][] visited = new boolean[11][11][11][11];//�̵��ϴ� �� ��ġ�� ������ �迭
    private static int x,y;

    public static int solution(String dirs) {

        int answer = 0;

        dir = new char[dirs.length()];

        for (int i = 0; i < dirs.length(); i++) dir[i] = dirs.charAt(i);

        x = 5;//������ �߰����� ��ġ
        y = 5;

        for (int i = 0; i < dir.length; i++) {

            if (isPossible(dir[i])) {//�̵��� �������� üũ

                int cx = x;
                int cy = y;

                move(dir[i]);//�̵��� �������� �̵�

                //System.out.println(cx + "," + cy + "->" + x + "," + y);
                visited[y][x][cy][cx] = true;//����->���� ��ġ�� �湮 üũ
                visited[cy][cx][y][x] = true;//����->���� ��ġ�� �湮 üũ

                answer++;
            } else {//�̹� �湮

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
