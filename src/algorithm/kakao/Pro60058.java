package algorithm.kakao;

import java.util.*;

/*
 * 2020 īī�� ����ε� �ڵ��׽�Ʈ
 * ��ȣ ��ȯ
 * */
public class Pro60058 {

    public String solution(String p) {
        StringBuilder sb = solve(p);

        return sb.toString();
    }

    private StringBuilder solve(String str) {

        StringBuilder u = new StringBuilder("");
        StringBuilder v = new StringBuilder("");

        int open 	= 0;//���� ��ȣ
        int close	= 0;//�ݴ� ��ȣ

        //u�� v�� ����
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') open++;
            else close++;

            if (open == close) {//��ȣ�� ������ �������� ������ u�� v�� ������ ����
                u.append(str.substring(0,i+1));
                v.append(str.substring(i+1));
                break;
            }
        }

        //v�� ���ؼ� ��͸� ���� ��ȣ �˻�
        if (!"".equals(v.toString())) v = solve(v.toString());

        StringBuilder sb = new StringBuilder("");

        //�ùٸ��� ���� ���ڿ��� ��,
        if (!isCorrect(u)) {

            //v�� ��,�ڷ� ��ȣ �߰�
            sb.append("("+v.toString()+")");

            //u�� ��,�ڸ� �����ϰ� ��� ��ȣ�� �������ְ� v�� �ٿ��ش�.
            for (int i = 1; i < u.length()-1; i++) {

                if (u.charAt(i) == '(') sb.append(")");
                else sb.append("(");
            }

        }else {//�ùٸ� ��ȣ�� ��

            //u�� �ڿ� v�� �ٿ��ش�.
            sb.append(u.toString()+v.toString());
        }

        return sb;
    }

    //�ùٸ� ��ȣ üũ
    private boolean isCorrect(StringBuilder u) {

        //ù ��°�� �������� ���� �̷���� üũ
        return   u.charAt(0) == '(' && u.charAt(u.length()-1) == ')';
    }
}
