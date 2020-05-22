package algorithm.programmersLevel2;

import java.util.*;

/*
* 프로그래머스
* 큰 수 만들기
* */
public class Pro42883 {

    public static String solution(String number, int k) {

        StringBuilder sb = new StringBuilder("");

        int max = 0;
        int idx = 0;

        for (int i = 0; i < number.length() - k; i++) {

            max = 0;

            for (int j = idx; j <= i + k; j++) {

                int cur = number.charAt(j) - '0';

                if (cur > max) {

                    max = cur;
                    idx = j+1;
                }
            }

            sb.append(max);
        }



        return sb.toString();
    }
}
