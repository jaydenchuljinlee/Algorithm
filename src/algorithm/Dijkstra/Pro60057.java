package algorithm.Dijkstra;

import java.util.*;

/*
* 2020 īī�� ����ε� �ڵ��׽�Ʈ
* ���ڿ� ����
* */
public class Pro60057 {

    public int solution(String s) {
        //�ִ� ������ ������ ���̴� �����̴�.
        int len = s.length()%2 == 0 ? s.length()/2 : (s.length()/2)+1;

        int min = Integer.MAX_VALUE;

        //���� ����
        for (int i = 1; i <= len; i++) {

            StringBuilder sb = new StringBuilder("");//����� ���ڿ��� ������ ��ü

            int left	= 0;//���� ����
            int right 	= left+i;//������ ����
            int cnt 	= 1;//���� �ߺ� ���ڿ��� �� ������

            String s1 = s.substring(left,left+i);//left���� i������ ���ڿ�
            sb.append(s1);//���� ���ڿ��� �߰�

            while(right+i <= s.length()) {//������ ���� �˻� ���� ��ü ���ڿ��� ���̺��� �۰ų� ���ƾ��Ѵ�.

                String s2 = s.substring(right,right+i);//������ ������ ���� ���ڿ� ����
                if (!s1.equals(s2)) {//���ʰ� �������� ���� ���� ��,

                    left = right;//���ʿ� �������� �籸��
                    s1 = s2;

                    if (cnt > 1) sb.insert(sb.length()-i, cnt);//�ߺ��� ���� �ִٸ�, ���� ���ڿ� �տ� ������ �߰�

                    sb.append(s1);//���� ���ڿ��� ������� ������� ���ڿ��� ����

                    cnt = 1;//�ߺ����� �ٽ� 1�� ������ش�.
                } else {//���ʰ� �������� ���� ��,
                    cnt++;//�ߺ����� �����ش�.
                }

                right += i;//�������� i��ŭ ����

            }

            //������ ������ ���� ���� ���ڿ��� �߰����ִ� ����
            if (cnt > 1) sb.insert(sb.length()-i, cnt);

            sb.append(s.substring(right));
            min = Math.min(sb.length(), min);//���� ������� ���ڿ� ���̿� �ּڰ��� ��
        }

        return min;
    }
}
