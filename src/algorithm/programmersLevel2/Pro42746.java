package algorithm.programmersLevel2;

import java.util.*;

/*
* 프로그래머스
* 가장 큰 수
* */
public class Pro42746 {

    public String solution(int[] numbers) {

        String answer ="";

        int len = numbers.length;

        String[] nums = new String[len];

        for (int i = 0; i < len; i++) {

            nums[i] = "" + numbers[i];
        }

        //두 수를 앞,뒤로 더한후 비교
        Arrays.sort(nums,new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {

                return (o2+o1).compareTo(o1+o2);
            }
        });

        //모든 배열이 0일 경우
        if (nums[0].equals("0")) return "0";

        //내림차순으로 정렬된 배열을 더해줌
        for (int i = 0; i < len; i++) {

            answer += nums[i];
        }

        return answer;
    }
}
