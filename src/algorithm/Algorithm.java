package algorithm;

import algorithm.grid.Boj1343;

import java.io.*;
import java.util.*;

public class Algorithm {

    public int solution(int[] A) {

        Arrays.sort(A);

        for (int i = 0; i < A.length-2; i++) {

            if (A[i+1] > A[i+2] - A[i]) return 1;
        }

        return 0;
    }



	public static void main(String[] args)throws Exception {




    }

}
