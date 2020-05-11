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

        if (cnta > 0 && A <= B) {//왼쪽 구간 합이 오른쪽 구간합보다 작으면 왼쪽 요소를 증가
            dfs(A+COOKIE[cnta-1],B,cnta-1,cntb);//왼쪽의 합계에 쿠키 갑과
        } else if (cntb < len-1 && A >= B) {//반대의 경우라면 오른쪽 요소를 증가
            dfs(A,B+COOKIE[cntb+1],cnta,cntb+1);
        }

    }
}
