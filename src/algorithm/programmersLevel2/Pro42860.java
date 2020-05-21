package algorithm.programmersLevel2;

import java.util.*;

/*
* ���α׷��ӽ�
* ���̽�ƽ
* */
public class Pro42860 {
    public static int solution(String name) {

        int answer = 0;

        StringBuilder nameBuilder = new StringBuilder(name);//name

        StringBuilder aBuilder = new StringBuilder("");//A���ڿ�

        //A���ڿ� ����
        for (int i = 0, loop = name.length(); i < loop; i++) aBuilder.append('A');

        int start = 0;//���ڿ��� A�� Ž���ϱ� ���� �ε���

        while(true) {

            int left  = start;
            int right = start;

            //A�� �ƴ� ������ ��,
            if (nameBuilder.charAt(start) != 'A') {

                answer += getMin(nameBuilder.charAt(start));//��,�Ʒ��� �� ���� �̵��� ã�´�.
                nameBuilder.setCharAt(start,'A');//name�� ���ڸ� A�� �ٲ��ش�.
            }

            //name�� ��� ���ڰ� A�� �ٲ��� �� �����Ѵ�.
            if (aBuilder.toString().equals(nameBuilder.toString())) break;

            //�̵� Ƚ��
            int move = 0;

            while(true) {

                left--;
                right++;
                move++;

                //������ ������ �Ѿ�� ������ ������ �������
                if (left < 0) left = nameBuilder.length()-1;

                //�������� ������ �Ѿ�� ���� ������ �������
                if (right == nameBuilder.length()) right = 0;

                //���� ��Ұ� A�� �ƴ϶��
                if (nameBuilder.charAt(right) != 'A') {

                    answer += move;//��� ���� �̵� Ƚ�� �߰�
                    start = right;//���� Ž�� �ε����� ����
                    break;
                }

                //���� ��Ұ� A�� �ƴ϶��
                if (nameBuilder.charAt(left) != 'A') {

                    answer += move;
                    start = left;
                    break;
                }


            }
        }


        return answer;
    }

    //��,�Ʒ� �̵� �ּڰ�
    public static int getMin(char ch) {

        return Math.abs(ch - 'A') < Math.abs('Z' - ch)+1 ? Math.abs(ch - 'A') : Math.abs('Z' - ch)+1;
    }
}
