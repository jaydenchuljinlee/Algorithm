package algorithm.programmers;

import java.util.*;

/*
 * 2018 KAKAO BLIND RECRUITMENT
 * [1��] ĳ��
 * */
public class Pro17680 {

    public int solution(int cacheSize, String[] cities) {
        ArrayList<String> lru = new ArrayList<>();

        int answer = 0;

        if (cacheSize == 0) {//ĳ�� ����� 0�̸�, �迭 ����*5�� ��ȯ
            answer = cities.length*5;
            return answer;
        }

        for (String city : cities) {

            String temp = city.toUpperCase();//���� �̸��� �빮�ڷ� ����

            if (lru.contains(temp)) {//LRU ĳ�ÿ� ���ԵǾ� �ִٸ�,

                lru.remove(temp);//���� �̸��� ���������Ƿ�, �ٽ� �ǵڷ� ������.
                lru.add(temp);
                answer++;//�ð��� 1����

            } else {

                //LRU ĳ�� ����� �����ִٸ�, ���� ������ ĳ�ø� ����
                if (lru.size() == cacheSize) lru.remove(0);

                lru.add(temp);//ĳ�ÿ� ���ο� ���� �̸��� �߰�

                answer+=5;//���ο� ĳ�ø� ���������Ƿ�, +5�� ���ش�.
            }
        }

        return answer;
    }
}
