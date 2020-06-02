package algorithm.grid;

import java.util.*;

/*
* 백준
* 보석 도둑
* */
public class Boj1202 {

    //보석점 정보를 저장해줄 클래스
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

        //보석점을 오름차순 정렬
        Collections.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {

                if (o1.weight <= o2.weight) return -1;
                else return 1;

            }
        });

        //가방을 오름차순 정렬
        Collections.sort(bagList);

        long answer = 0;
        int idx = 0;//보석점 인덱스

        for (int bag : bagList) {

            //보석점의 길이만큼 반복
            while(idx < n) {

                //가방의 무게가 현재 보석점의 무게보다 크거나 같을 때
                if (bag >= jewelries.get(idx).weight) {

                    //보석점의 가격을 우선순위 큐에 음수 형태로 담는다.(오름차순 정렬이기 때문에)
                    pq.add(-(jewelries.get(idx++).value));
                }else break;
            }

            //결과값에 우선순위 큐에서 가장 큰 값을 뺀다. (가장 작은 값을 절대값 씌우면 가장 큰 값이 된다.)
            if (!pq.isEmpty()) answer += Math.abs(pq.poll());

        }

        System.out.println(answer);
    }
}
