package algorithm.codility.level4;

import java.util.HashSet;

public class PermCheck {

    public static int solution(int[] A) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {

            if (A[i] > A.length) return 0;

            if (set.contains(A[i])) return 0;

            set.add(A[i]);
        }

        return 1;
    }
}
