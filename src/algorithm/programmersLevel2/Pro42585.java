package algorithm.programmersLevel2;

import java.util.*;

/*
* ���α׷��ӽ�
* �踷���
* */
public class Pro42585 {

    public int solution(String arrangement) {
        int answer = 0;
        int n = 0;
        int cnt = 0;

        String str = arrangement.replaceAll("\\(\\)"," ");

        while (cnt < str.length()) {

            switch(str.charAt(cnt)) {
                case ' ' : answer += n;
                    break;
                case '(' : n++;answer++;
                    break;
                case ')' : n--;
                    break;
            }

            cnt++;
        }
        return answer;
    }
}
