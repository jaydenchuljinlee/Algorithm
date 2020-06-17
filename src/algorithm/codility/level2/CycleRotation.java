package algorithm.codility.level2;

public class CycleRotation {

    public static int[] solution(int[] A, int K) {

        int[] arr = new int[A.length];

        for (int i = 0; i < A.length; i++) {

            arr[(i+K) % A.length] = A[i];
        }

        for (int i = 0; i < A.length; i++) {

            System.out.print(arr[i] + " ");
        }

        return arr;
    }
}
