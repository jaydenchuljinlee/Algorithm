package algorithm.programmers;

import java.util.*;

/*
 * 2018 summer/winter conding
 * 점프와 순간 이동
 * */
public class Pro12980 {
    public static int solution(int n) {
        int answer = 0;

        while(n != 0) {

            if (n%2 == 0) {//n이 2로 나눠 떨어지면 현재 n을 2로 나눔
                n/=2;
            } else {//나눠 떨어지지 않으면, 한칸 이동
                n-=1;
                answer++;
            }
        }

        return answer;
    }
}
