package algorithm.programmers;

import java.util.*;

/*
 * 2018 summer/winter conding
 * ���� ����
 * */
public class Pro12987 {

    public static int solution(int[] A, int[] B) {

        Arrays.sort(A);//B�� ������ ��� ����ǥ�� ���ϱ� ���ؼ� A�� B�迭�� ���������� ����
        Arrays.sort(B);

        int aidx = 0;//A�� �ε��� ��
        int bidx = 0;//B�� �ε��� ��
        int len	 = A.length;
        int answer = 0;

        while(true) {

            if (bidx == len) break;

            if (B[bidx] > A[aidx]) {

                answer++;
                aidx++;
                bidx++;
            } else {

                bidx++;
            }
        }

        return answer;
    }
}
