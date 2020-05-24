package algorithm.programmersLevel2;

import java.util.*;

/*
* ���α׷��ӽ�
* ���� ū ��
* */
public class Pro42746 {

    public String solution(int[] numbers) {

        String answer ="";

        int len = numbers.length;

        String[] nums = new String[len];

        for (int i = 0; i < len; i++) {

            nums[i] = "" + numbers[i];
        }

        //�� ���� ��,�ڷ� ������ ��
        Arrays.sort(nums,new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {

                return (o2+o1).compareTo(o1+o2);
            }
        });

        //��� �迭�� 0�� ���
        if (nums[0].equals("0")) return "0";

        //������������ ���ĵ� �迭�� ������
        for (int i = 0; i < len; i++) {

            answer += nums[i];
        }

        return answer;
    }
}
