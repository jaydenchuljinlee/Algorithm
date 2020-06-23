package algorithm.codility.level6;

import java.util.Arrays;

public class MaxProductOfThree {

    public static int solution(int[] A) {

        Arrays.sort(A);

        int len = A.length-1;

        int answer = A[len-1] * A[len-2] * A[len];

        if (A[0] < 0 && A[1] < 0 && A[len] > 0) {

            int answer2 = A[0] * A[1] * A[len];

            if (answer2 > answer) answer = answer2;
        }

        return answer;
    }
}
