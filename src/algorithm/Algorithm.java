package algorithm;

import algorithm.programmers.Pro64061;
import algorithm.programmers.Pro64065;

import java.util.*;
import java.io.*;

public class Algorithm {


	public static void main(String[] args) throws Exception {

		Pro64065 programers = new Pro64065();

		String[] s = {"{{2},{2,1},{2,1,3},{2,1,3,4}}"
		            ,"{{1,2,3},{2,1},{1,2,4,3},{2}}"
		            ,"{{20,111},{111}}"
                    ,"{{123}}"
                    ,"{{4,2,3},{3},{2,3,4,1},{2,3}}"};

		for (String str : s) {

            System.out.println(programers.solution(str));
        }





	}
}
