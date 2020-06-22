package algorithm.codility.level5;

public class PassingCars {

    public static int solution(int[] A) {

        int sum = 0;
        int result = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] == 0) sum++;
            else result += sum;
        }

        if (result > 1000000000 || result < 0) return -1;

        return result;
    }
}
