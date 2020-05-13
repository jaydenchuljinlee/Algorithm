package algorithm.programmers;

import java.util.*;

/*
 * 2018 KAKAO BLIND RECRUITMENT
 * [1��] ���� Ŭ�����͸�
 * */
public class Pro17678 {

    public static String solution(int n, int t, int m, String[] timetable) {

        String answer = "";

        //ũ�簡 �����ϴ� �ð��� ������������ ����
        PriorityQueue<Integer> crew = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {

                return o1-o2;
            }

        });

        for (String table : timetable) {

            //ũ���� �����ð��� ���ڿ�->Integer ���·� ��ȯ
            int time = Integer.parseInt(table.substring(0, 2))*60 + Integer.parseInt(table.substring(3));

            crew.add(time);
        }

        int busTime = 9*60;//������ ó�� �����ϴ� �ð� ����

        int last = 0;

        while(n-->0) {//

            int accept = m;//���� �ο��� �ʱ�ȭ

            int time = 0;//���������� ź ũ���� �ð��� �����ϱ� ����

            while(!crew.isEmpty()) {//��ٸ��� ũ�簡 �ִٸ�

                if (crew.peek() <= busTime && accept > 0) {//���� ������ �����ð����� ���������, �����ο��� ���� ��,

                    accept--;
                    time = crew.poll();
                } else break;
            }

            //������ ������ �ƴ�
            if (n > 0) {

                if (crew.isEmpty()) {//��ٸ��� ũ�簡 ���ٸ�

                    last = busTime +((n+1)*t);//������ ������ �����ð�
                    break;
                }

                busTime += t;//������ ���� �ð� ����

            } else {// ������ ����

                if (accept > 0) last = busTime;//�����ο��� �ִٸ�, ������ �����ð�����
                else last = time-1;//���ٸ�, ���������� ź ũ���� �ð����� 1�� ����

                break;

            }
        }

        answer = String.format("%02d",last/60) + ":" + String.format("%02d", last%60);

        return answer;
    }
}
