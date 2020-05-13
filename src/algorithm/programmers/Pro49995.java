package algorithm.programmers;

/*
 * 2018 summer/winter conding
 * 쿠키 구입
 * */
public class Pro49995 {
    private static int max,len;
    private static int[] COOKIE;

    public static int solution(int[] cookie) {
        int answer = 0;

        COOKIE = cookie;

        max = 0;
        len = cookie.length;

        for (int i = 0; i < len-1; i++) {//첫 번째부터 마지막-1 요소까지 dfs 탐색
            dfs(COOKIE[i],COOKIE[i+1],i,i+1);
        }
        answer = max;
        return answer;
    }

    private static void dfs(int A,int B, int cnta, int cntb) {

        if (A == B) {//같으면 최댓값과 비교
            max = Math.max(max, A);
        }

        if (cnta > 0 && A <= B) {//왼쪽 구간을 늘리는 방식으로 DFS 탐색
            dfs(A+COOKIE[cnta-1],B,cnta-1,cntb);//cnta를 줄이는 이유는 처음 for문과 관계가 있다.
        } else if (cntb < len-1 && A >= B) {//오른쪽 구간을 늘리는 방식으로 DFS 탐색
            dfs(A,B+COOKIE[cntb+1],cnta,cntb+1);
        }

    }
}
