package algorithm.codility.level4;

public class MaxCounters {

    public static int[] solution(int N, int[] A) {

        int[] counter = new int[A.length];

        int max = 0;

        int cur = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] > N) {

                max = cur;

            } else {

                if (counter[A[i]-1] < max) {
                    counter[A[i]-1] = max;
                }

                counter[A[i]-1]++;

                if (counter[A[i]-1] > cur) {

                    cur = counter[A[i]-1];
                }
            }
        }

        if (max > 0) {

            for (int i = 0; i < counter.length; i++) {

                if (counter[i] < max) {

                    counter[i] = max;
                }
            }
        }

        return counter;

    }
}
