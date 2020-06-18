package algorithm.codility.level4;

import java.util.*;

public class FrogRiverOne {

    public static int solution(int X, int[] A) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {

            if (X >= A[i]) set.add(A[i]);

            if (set.size() == X) return i;
        }

        return -1;

    }
}
