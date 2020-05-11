package algorithm.programmers;

import java.util.*;

/*
 * 2018 summer/winter conding
 * ���� �����ձ�
 * */
public class Pro12981 {

    public static int[] solution(int n, String[] words) {
        ArrayList<String> list = new ArrayList<>();

        int i;//�� ������ ����Ǵ� Ƚ��

        list.add(words[0]);
        for (i = 1; i < words.length; i++) {

            char prev = words[i-1].charAt(words[i-1].length()-1);//�� �ܾ�
            char curr = words[i].charAt(0);//���� ó�� �ܾ�

            if (list.contains(words[i])) break;//���ԵǾ� �ִٸ� ����

            if (prev != curr) break;//���� ó���� ���� ���� �ٸ��� ����

            list.add(words[i]);//���� �ܾ �ߺ� ����Ʈ�� ��´�.
        }

        int[] answer = new int[2];//��� �迭 ����

        if (i == words.length) {//Ż���ڰ� ������ ���� ��,

            answer[0] = 0;
            answer[1] = 0;

        } else {//Ż���ڰ� ������ ��,

            answer[0] = i%n + 1;//�� Ƚ���� n������ ���� ������ +1�� ���� Ż������ ��ȣ
            answer[1] = i/n + 1;//��+1�� �� ���������� �˷���
        }

        return answer;
    }
}
