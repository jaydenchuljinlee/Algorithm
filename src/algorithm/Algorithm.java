package algorithm;

import algorithm.grid.Boj1343;

import java.io.*;
import java.util.*;

public class Algorithm {

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



	public static void main(String[] args)throws Exception {

        solution(new int[] {4,2,2,5,1,5,8});


    }

}
