package algorithm.programmers;

import java.util.*;

/*
 * 2019 īī�� ����ε�
 * ������
 * */
public class Pro42889 {

    //���������� ���� �ε����� �������� ������ Ŭ����
    private static class Stage {
        int idx;
        double percent;

        public Stage(int idx, double percent) {
            this.idx		= idx;
            this.percent	= percent;
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] fail = new int[N];//���������� ���� ���� Ƚ���� ������ �迭
        int[] ans = new int[N];//�������� ������������ ������ ��� �迭
        int total = stages.length;//�������� ���ϱ� ���� �ʱⰪ

        for (int stage : stages) {

            if (stage > N) continue;//��� ���������� �����ߴٸ� ���� �б⹮����
            fail[stage-1]++;//���� Ƚ���� ����
        }

        //�켱����ť�� ������-�ε����� ������������ �����Ѵ�.
        PriorityQueue<Stage> pq = new PriorityQueue<Stage>(new Comparator<Stage>() {

            @Override
            public int compare(Stage o1, Stage o2) {

                if (o1.percent - o2.percent < 0) return 1;
                else if (o1.percent - o2.percent == 0) {

                    if (o1.idx < o2.idx) return -1;
                    else return 1;
                }
                else return -1;
            }
        });

        for (int i = 0,loop = fail.length; i < loop; i++) {

            Stage s = new Stage(i,(double)fail[i]/total);//�������� ���õ� ������ ������ ���� �������� �����ش�.

            pq.add(s);//�������� �������� �켱����ť�� �ش� ��ü�� ����
            total = (total - fail[i] == 0) ? 1 : total - fail[i];//���� ������������ ���� ���������� ����Ƚ���� ���ش�.

        }

        for (int i = 0,loop = ans.length; i < loop; i++) {

            ans[i] = pq.poll().idx+1;//��� �迭�� ������������ ���ĵ� �������� �������ش�.

        }

        return ans;
    }
}
