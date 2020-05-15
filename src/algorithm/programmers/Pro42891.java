package algorithm.programmers;

import java.util.*;

/*
 * 2019 īī�� ����ε�
 * ������ �Թ� ���̺�
 * */
public class Pro42891 {

    //������ ��ȣ�� �Դµ� �ɸ��� �ð��� ���� Ŭ����
    private static class Food {
        int idx;
        int time;

        public Food(int idx, int time) {
            this.idx	= idx;
            this.time	= time;
        }
    }

    public static int solution(int[] food_times, long k) {

        int len = food_times.length;

        ArrayList<Food> list = new ArrayList<>();//���Ŀ� ���� ������ ������ ����Ʈ

        //���Ŀ� ���� ������ ����Ʈ�� ����
        for (int i = 0; i < food_times.length; i++) {

            list.add(new Food(i+1,food_times[i]));
        }

        //������ �Դµ� �ɸ��� �ð��� ������������ ����
        Collections.sort(list,new Comparator<Food>() {

            @Override
            public int compare(Food o1, Food o2) {

                return o1.time - o2.time;
            }
        });

        int prev = 0;//���� ������ �ð�
        int idx = 0;//���� ��ȣ

        for (Food food : list) {

            long diff = food.time - prev;//���� ���� �ð����� ����

            long spen = diff * len;//���� ���� �ð��� �ɸ��� ������ �������� ��ü ������ �Դµ� �ɸ��� �ð�

            if (k >= spen) {//k�� ���� ���� �ð��� �ɸ��� ������ �� �Դµ� �ð����� Ŭ ����

                k -= spen;// �� �ð���ŭ k���� ���ְ�,
                prev = food.time;//���� ���� �ð� üũ�� ���� ���� ������ �ð��� ����

            } else {

                k %= len;//�� ��° ���� ���������� ������

                List<Food> sub = list.subList(idx, list.size());//���� ���� ���ĵ��� ��ȣ�� ����Ʈ�� �籸��

                Collections.sort(sub, new Comparator<Food>() {//����Ʈ�� ���� ��ȣ�� �������� �������� ����

                    @Override
                    public int compare(Food o1, Food o2) {

                        return o1.idx - o2.idx;
                    }
                });

                return sub.get((int)k).idx;//����Ʈ���� k�� �ش��ϴ� ���� ��ȣ�� ��ȯ
            }

            idx++;//���� ���� �ð��� ���� ������ �� �Ծ��� ������ ���� ������ ��ȣ�� ����Ų��.
            len--;//�� ������ ������ �ٸԾ��� ������ ���̸� ����
        }

        return -1;//������ �� �Ծ��ٸ�, -1�� ��ȯ
    }
}
