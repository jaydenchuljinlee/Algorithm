package algorithm.codility.level1;

public class BinaryGap {

    public static int solution(int N) {

        int max = 0;
        int gap = 0;
        boolean isTrue = false;

        while(true) {

            if ((N & 1) == 1) {

                if (!isTrue) {

                    isTrue = true;
                } else {

                    if (gap > max) {

                        max = gap;
                    }
                }

                gap = 0;

            } else {

                gap++;
            }

            N >>= 1;

            if (N == 0) break;
        }

        return max;
    }
}
