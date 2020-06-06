package algorithm.kakaoEnterprise2020Summer;

import java.io.*;
import java.util.*;

public class KakaoEnterSummer2020_3 {

    public static void solution() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        //���ڸ� ���� �켱����ť�� ������������ �������ش�.
        PriorityQueue<Double> pq = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {

                if (o1 > o2) return -1;
                else return 1;

            }
        });

        double min = Integer.MAX_VALUE;

        //N��ŭ ���ڸ� �ް� ������ �ּڰ��� ����
        while(N-- > 0) {

            double snack = Double.parseDouble(br.readLine());

            if (snack < min) min = snack;

            pq.add(snack);
        }

        //���ڸ� ������ �ڸ��� ť�� �ٽ� �ִ� ���� �ݺ�
        while(pq.size() < K) {

            double mid = Math.round((pq.poll()/2)*100)/100.0;

            pq.add(mid);
            pq.add(mid);
        }

        //�ڸ� ���ڸ� �ٽ� ������������ ����
        PriorityQueue<Double> reverse = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {

                if (o1 < o2) return -1;
                else return 1;

            }
        });

        //������������ ���ĵ� �켱����ť�� ���ڸ� �ٽ� �ִ´�.
        while (!pq.isEmpty()) reverse.add(pq.poll());

        //�켱����ť���� ���� ���� ���� ���̸� ������.
        System.out.println(reverse.poll());
    }

}
