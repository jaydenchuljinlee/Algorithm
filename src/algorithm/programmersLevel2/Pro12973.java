package algorithm.programmersLevel2;

import java.util.*;

/*
* ���α׷��ӽ�
* ¦���� �����ϱ�
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
