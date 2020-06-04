package algorithm.grid;

import java.util.*;

/*
* ����
* ���� ����
* */
public class Boj1202 {

    //������ ������ �������� Ŭ����
    private static class Jewelry {
        int weight;
        int value;

        public Jewelry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

    }

    public static void solution() {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        ArrayList<Jewelry> jewelries = new ArrayList<>();
        ArrayList<Integer> bagList = new ArrayList<>();

        for (int i = 0; i < n; i++) jewelries.add(new Jewelry(sc.nextInt(),sc.nextInt()));
        for (int i = 0; i < k; i++) bagList.add(sc.nextInt());

        //�������� �������� ����
        Collections.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {

                if (o1.weight <= o2.weight) return -1;
                else return 1;

            }
        });

        //������ �������� ����
        Collections.sort(bagList);

        long answer = 0;
        int idx = 0;//������ �ε���

        for (int bag : bagList) {

            //�������� ���̸�ŭ �ݺ�
            while(idx < n) {

                //������ ���԰� ���� �������� ���Ժ��� ũ�ų� ���� ��
                if (bag >= jewelries.get(idx).weight) {

                    //�������� ������ �켱���� ť�� ���� ���·� ��´�.(�������� �����̱� ������)
                    pq.add(-(jewelries.get(idx++).value));
                }else break;
            }

            //������� �켱���� ť���� ���� ū ���� ����. (���� ���� ���� ���밪 ����� ���� ū ���� �ȴ�.)
            if (!pq.isEmpty()) answer += Math.abs(pq.poll());

        }

        System.out.println(answer);
    }
}