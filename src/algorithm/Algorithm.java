package algorithm;

import algorithm.grid.Boj1343;

import java.io.*;
import java.util.*;

public class Algorithm {

    public static int solution(int[] A) {

        int sum  = 0;
        int diff = 0;

        for (int i = 0; i < A.length; i++) sum += A[i];

        int min = Integer.MAX_VALUE;

        int trans = 0;

        for (int i = 0; i < A.length-1; i++) {

            trans += A[i];
            sum -= A[i];

            diff = Math.abs(trans - sum);

            min = Math.min(min,diff);
        }

        return min;
    }



	public static void main(String[] args)throws Exception {

        int k = solution(new int[] {3,1,2,4,3});

        System.out.println(k);
    }

}
