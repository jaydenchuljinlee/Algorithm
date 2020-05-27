package algorithm.programmersLevel2;

import java.util.*;

/*
* 프로그래머스
* 짝지어 제거하기
* */
public class Pro12973 {

    public int solution(String s){

        Stack<Character> st = new Stack<>();

        for (int i = 0, loop = s.length(); i < loop; i++) {

            char c = s.charAt(i);

            if (!st.isEmpty() && st.peek() == c) st.pop();
            else st.push(c);
        }

        if (st.isEmpty()) return 1;
        else return 0;
    }
}
