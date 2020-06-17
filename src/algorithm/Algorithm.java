package algorithm;

import algorithm.grid.Boj1343;

import java.io.*;
import java.util.*;

public class Algorithm {

    public static int solution(int[] A) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {

            map.put(A[i],map.getOrDefault(A[i],0)+1);
        }

        for (int key : map.keySet()) {

            if (map.get(key)%2 != 0) return key;
        }

        return -1;
    }



	public static void main(String[] args)throws Exception {

        int k = solution(new int[]{9,3,9,3,9,7,9});

        System.out.println(k);
    }

}
