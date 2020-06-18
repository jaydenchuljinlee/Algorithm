package algorithm.codility.level4;

import java.util.HashSet;

public class MissingInteger {

    public static int solution(int[] A) {

        HashSet<Integer> set = new HashSet<>();

        for (int a : A) set.add(a);

        for (int i = 1; i <= Integer.MAX_VALUE; i++) {

            if (!set.contains(i)) return i;
        }

        return -1;
    }
}
