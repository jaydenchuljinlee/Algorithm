package algorithm.programmers;

import java.util.*;

/*
 * 2018 summer/winter conding
 * 숫자 게임
 * */
public class Pro12987 {

    public static int solution(int[] A, int[] B) {

        Arrays.sort(A);//B가 승점을 얻는 대진표를 구하기 위해서 A와 B배열을 순차적으로 정렬
        Arrays.sort(B);

        int aidx = 0;//A의 인덱스 값
        int bidx = 0;//B의 인덱스 값
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
