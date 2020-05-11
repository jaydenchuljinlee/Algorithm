package algorithm.programmers;

import java.util.*;

/*
 * 2018 summer/winter conding
 * 소수 만들기
 * */
public class Pro12977 {

    public static int solution(int[] nums) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {//세 개의 숫자를 더해 리스트에 담는다.

            for (int j = i+1; j < nums.length-1; j++) {

                for (int k = j+1; k < nums.length; k++) {

                    list.add(nums[i]+nums[j]+nums[k]);
                }
            }
        }

        for (int prime : list) {

            boolean flag = true;

            for (int i = 2; i <= Math.sqrt(prime); i++) {//2부터 절댓값까지 나누어지는 수가 있는지 확인

                if (prime % i == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) answer++;//나누어지는 수가 없으면, 결과값+1
        }


        return answer;
    }
}
