package algorithm.codility.level6;

import java.util.HashSet;

public class Distinct {

    public static int solution(int[] A) {

        HashSet<Integer> set = new HashSet<>();

        for (int a : A) set.add(a);

        return set.size();
    }

}
