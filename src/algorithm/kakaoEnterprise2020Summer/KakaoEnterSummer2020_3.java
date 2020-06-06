package algorithm.kakaoEnterprise2020Summer;

import java.io.*;
import java.util.*;

public class KakaoEnterSummer2020_3 {

    public static void solution() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        //과자를 넣을 우선순위큐를 내림차순으로 정렬해준다.
        PriorityQueue<Double> pq = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {

                if (o1 > o2) return -1;
                else return 1;

            }
        });

        double min = Integer.MAX_VALUE;

        //N만큼 과자를 받고 과자의 최솟값을 셋팅
        while(N-- > 0) {

            double snack = Double.parseDouble(br.readLine());

            if (snack < min) min = snack;

            pq.add(snack);
        }

        //과자를 반으로 자르고 큐에 다시 넣는 것을 반복
        while(pq.size() < K) {

            double mid = Math.round((pq.poll()/2)*100)/100.0;

            pq.add(mid);
            pq.add(mid);
        }

        //자른 과자를 다시 오름차순으로 정렬
        PriorityQueue<Double> reverse = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {

                if (o1 < o2) return -1;
                else return 1;

            }
        });

        //오름차순으로 정렬된 우선순위큐에 과자를 다시 넣는다.
        while (!pq.isEmpty()) reverse.add(pq.poll());

        //우선순위큐에서 제일 작은 과자 길이를 꺼낸다.
        System.out.println(reverse.poll());
    }

}
