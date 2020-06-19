package algorithm.codility.level5;

public class MinAvgTwoSlice {

    public static int solution(int[] A) {

        int idx = 0;
        double min = (A[0] + A[1])/2.0;

        for (int i = 2; i < A.length; i++) {

            double avg = (A[i-2] + A[i-1] + A[i])/3.0;

            if (min > avg) {

                min = avg;
                idx = i-2;
            }

            avg = (A[i-1] + A[i])/2.0;

            if (min > avg) {

                min = avg;
                idx = i-1;
            }
        }

        return idx;
    }
}
