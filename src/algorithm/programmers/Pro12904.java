package algorithm.programmers;

/*
* 프로그래머스 레벨3
* 가장 긴 펠린드롬
* */
public class Pro12904 {

    public static int solution(String s) {

        int max = 1;
        int cnt = 1;
        int len = s.length();

        for (int i = 0; i < len-1; i++) {

            if (s.charAt(i) == s.charAt(i+1)) {
                cnt = 0;

                for (int j = i+1; j < len; j++) {

                    try {

                        char left = s.charAt(i+1-j+i);

                        char right = s.charAt(j);

                        if (left == right) cnt+=2;
                        else break;

                    } catch(Exception e) {
                        break;
                    }
                }
            }

            if (max < cnt) max = cnt;
        }

        for (int i = 0; i < len-1; i++) {

            cnt = 1;
            for (int j = i+1; j < len; j++) {

                try {

                    char left = s.charAt(i+i-j);
                    char right = s.charAt(j);

                    if (left == right) cnt+=2;
                    else break;

                } catch(Exception e) {
                    break;
                }
            }

            if (max < cnt) max = cnt;
        }

        return max;
    }
}
