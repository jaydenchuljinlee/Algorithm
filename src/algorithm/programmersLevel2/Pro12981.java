package algorithm.programmersLevel2;

import java.util.*;

/*
* 프로그래머스
* 영어 끝말잇기
* */
public class Pro12981 {

    public int[] solution(int n, String[] words) {
        ArrayList<String> list = new ArrayList<>();

        int i;

        list.add(words[0]);
        for (i = 1; i < words.length; i++) {

            char prev = words[i-1].charAt(words[i-1].length()-1);
            char curr = words[i].charAt(0);

            if (list.contains(words[i])) break;

            if (prev != curr) break;

            list.add(words[i]);
        }

        int[] answer = new int[2];

        if (i == words.length) {

            answer[0] = 0;
            answer[1] = 0;

        } else {

            answer[0] = i%n + 1;
            answer[1] = i/n + 1;
        }

        return answer;
    }
}
