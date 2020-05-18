package algorithm.kakao;

import java.util.*;

public class Pro60057 {

    public int solution(String s) {
        int len = s.length()%2 == 0 ? s.length()/2 : (s.length()/2)+1;

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= len; i++) {

            StringBuilder sb = new StringBuilder("");

            int left	= 0;
            int right 	= left+i;
            int cnt 	= 1;

            String s1 = s.substring(left,left+i);
            sb.append(s1);

            while(right+i <= s.length()) {

                String s2 = s.substring(right,right+i);
                if (!s1.equals(s2)) {

                    left = right;
                    s1 = s2;

                    if (cnt > 1) sb.insert(sb.length()-i, cnt);

                    sb.append(s1);

                    cnt = 1;
                } else {
                    cnt++;
                }

                right += i;

            }

            if (cnt > 1) sb.insert(sb.length()-i, cnt);

            sb.append(s.substring(right));
            min = Math.min(sb.length(), min);
        }

        return min;
    }
}
