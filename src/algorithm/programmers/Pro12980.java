package algorithm.programmers;

import java.util.*;

/*
 * 2018 summer/winter conding
 * ������ ���� �̵�
 * */
public class Pro12980 {
    public static int solution(int n) {
        int answer = 0;

        while(n != 0) {

            if (n%2 == 0) {//n�� 2�� ���� �������� ���� n�� 2�� ����
                n/=2;
            } else {//���� �������� ������, ��ĭ �̵�
                n-=1;
                answer++;
            }
        }

        return answer;
    }
}
