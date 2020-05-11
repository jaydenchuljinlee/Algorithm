package algorithm.programmers;

import java.util.*;

/*
 * 2018 summer/winter conding
 * �Ҽ� �����
 * */
public class Pro12977 {

    public static int solution(int[] nums) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {//�� ���� ���ڸ� ���� ����Ʈ�� ��´�.

            for (int j = i+1; j < nums.length-1; j++) {

                for (int k = j+1; k < nums.length; k++) {

                    list.add(nums[i]+nums[j]+nums[k]);
                }
            }
        }

        for (int prime : list) {

            boolean flag = true;

            for (int i = 2; i <= Math.sqrt(prime); i++) {//2���� ���񰪱��� ���������� ���� �ִ��� Ȯ��

                if (prime % i == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) answer++;//���������� ���� ������, �����+1
        }


        return answer;
    }
}
