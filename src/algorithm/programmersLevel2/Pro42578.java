package algorithm.programmersLevel2;

import java.util.*;

/*
* 프로그래머스
* 위장
* */
public class Pro42578 {

    public int solution(String[][] clothes) {

        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for (String[] pair : clothes) {

            map.put(pair[1], map.getOrDefault(pair[1],0)+1);
        }

        for (int sum : map.values()) {

            answer *= (sum+1);
        }

        return answer-1;
    }
}
