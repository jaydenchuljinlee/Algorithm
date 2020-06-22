package algorithm;

import algorithm.grid.Boj1343;

import java.io.*;
import java.util.*;

public class Algorithm {

    public static int solution(int[] A) {

        HashSet<Integer> set = new HashSet<>();

        for (int a : A) set.add(a);

        return set.size();
    }



	public static void main(String[] args)throws Exception {




    }

}
