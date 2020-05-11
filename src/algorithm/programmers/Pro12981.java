package algorithm.programmers;

import java.util.*;

/*
 * 2018 summer/winter conding
 * 영어 끝말잇기
 * */
public class Pro12981 {

    public static int[] solution(int n, String[] words) {
        ArrayList<String> list = new ArrayList<>();

        int i;//총 게임이 진행되는 횟수

        list.add(words[0]);
        for (i = 1; i < words.length; i++) {

            char prev = words[i-1].charAt(words[i-1].length()-1);//끝 단어
            char curr = words[i].charAt(0);//현재 처음 단어

            if (list.contains(words[i])) break;//포함되어 있다면 종료

            if (prev != curr) break;//현재 처음과 이전 끝이 다르면 종료

            list.add(words[i]);//현재 단어를 중복 리스트에 담는다.
        }

        int[] answer = new int[2];//결과 배열 셋팅

        if (i == words.length) {//탈락자가 생기지 않을 때,

            answer[0] = 0;
            answer[1] = 0;

        } else {//탈락자가 나왔을 때,

            answer[0] = i%n + 1;//총 횟수를 n명으로 나눈 나머지 +1이 현재 탈락자의 번호
            answer[1] = i/n + 1;//몫+1은 몇 차례인지를 알려줌
        }

        return answer;
    }
}
