package algorithm.grid;

import java.io.*;
import java.util.*;

/*
* 백준 8980
* 택배
* */
public class Boj8980 {

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

    public static void solution() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        //박스를 오름차순으로 정렬
        PriorityQueue<Box> pq = new PriorityQueue<>(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {

                if (o1.end < o2.end) return -1;
                else if (o1.end < o2.end) return 0;
                else return 1;
            }
        });

        int[] town = new int[N+1];

        //데이터 정보 입력
        while(M-- > 0) {

            String[] str = br.readLine().split(" ");

            pq.add(new Box(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2])));
        }

        int answer = 0;

        //받는 마을로 오름차순 정렬된 박스 데이터
        while(!pq.isEmpty()) {

            Box b = pq.poll();

            int max = 0;

            //박스가 실렸는지 확인
            boolean isLoaded = true;

            //시작 마을부터 끝 마을까지 박스 무게를 검사
            for (int i = b.start; i < b.end; i++) {

                //해당 마을에서 박스의 무게가 초과한다면 false로 변경
                if (town[i] >= C) {

                    isLoaded = false;
                    break;
                }
                //max값 셋팅
                max = Math.max(max,town[i]);
            }

            //박스를 실을 수 있다면
            if (isLoaded) {

                //제어 무게에서 max를 빼줌(거쳐가는 마을에 박스를 실을 수 있는지를 검사하기 위함)
                int unLoaded = C - max;

                //빼준 값이 현재 박스 무게보다 크면 해당 박스를 변수에 담는다.
                if (unLoaded > b.weight) unLoaded = b.weight;

                //결과 값에 추가
                answer += unLoaded;

                //현재 로드된 박스 무게를 거쳐가는 마을들에 추가
                for (int i = b.start; i < b.end; i++) {
                    town[i] += unLoaded;
                }
            }
        }

        System.out.println(answer);
    }
}
