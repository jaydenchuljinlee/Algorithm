package algorithm.programmers;

/*
 * 2018 summer/winter conding
 * ��Ű ����
 * */
public class Pro49995 {
    private static int max,len;
    private static int[] COOKIE;

    public static int solution(int[] cookie) {
        int answer = 0;

        COOKIE = cookie;

        max = 0;
        len = cookie.length;

        for (int i = 0; i < len-1; i++) {//ù ��°���� ������-1 ��ұ��� dfs Ž��
            dfs(COOKIE[i],COOKIE[i+1],i,i+1);
        }
        answer = max;
        return answer;
    }

    private static void dfs(int A,int B, int cnta, int cntb) {

        if (A == B) {//������ �ִ񰪰� ��
            max = Math.max(max, A);
        }

        if (cnta > 0 && A <= B) {//���� ������ �ø��� ������� DFS Ž��
            dfs(A+COOKIE[cnta-1],B,cnta-1,cntb);//cnta�� ���̴� ������ ó�� for���� ���谡 �ִ�.
        } else if (cntb < len-1 && A >= B) {//������ ������ �ø��� ������� DFS Ž��
            dfs(A,B+COOKIE[cntb+1],cnta,cntb+1);
        }

    }
}
