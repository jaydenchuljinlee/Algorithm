package algorithm;

import java.io.*;
import java.util.*;

public class Algorithm {

    private static class Box {
        int start;
        int end;
        int weight;

        public Box(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

	public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        PriorityQueue<Box> pq = new PriorityQueue<>(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {

                if (o1.start < o2.start) return -1;
                else if (o1.start > o2.start) return 1;
                else {

                    if (o1.end < o2.end) return -1;
                    else return 1;
                }
            }
        });

        while(M-- > 0) {

            String[] str = br.readLine().split(" ");

            pq.add(new Box(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2])));
        }

        PriorityQueue<Box> reverse = new PriorityQueue<>(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o1.end - o2.end;
            }
        });

        int villege = pq.peek().start;
        int max = C;
        int answer = 0;

        while(!pq.isEmpty()) {

            Box b = pq.poll();

            if (villege == b.start) {

                System.out.println(villege);

                while(!reverse.isEmpty() && reverse.peek().end == villege) {

                    Box loaded = reverse.poll();

                    System.out.println("시작 마을 : " + loaded.start + "끝 마을 :"+ loaded.end + ", 무게 : " + loaded.weight);

                    answer += loaded.weight;
                    max += loaded.weight;
                }

                if (b.weight <= max) {

                    max -= b.weight;
                    reverse.add(b);

                    System.out.println("시작 마을 :"+ b.start + ", 무게 : " + b.weight);
                }
                else {

                    if (max > 0) {

                        System.out.println("시작 마을 :"+ b.start + ", 무게 : " + max);

                        reverse.add(new Box(b.start,b.end,max));
                        max = 0;
                    }

                    villege++;
                }
            }
        }

        while(!reverse.isEmpty()) answer += reverse.poll().weight;

        System.out.println(answer);

    }


}
