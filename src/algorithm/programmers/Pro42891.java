package algorithm.programmers;

import java.util.*;

/*
 * 2019 카카오 블라인드
 * 무지의 먹방 라이브
 * */
public class Pro42891 {

    //음식의 번호와 먹는데 걸리는 시간에 대한 클래스
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

        ArrayList<Food> list = new ArrayList<>();//음식에 대한 정보를 저장할 리스트

        //음식에 대한 정보를 리스트에 저장
        for (int i = 0; i < food_times.length; i++) {

            list.add(new Food(i+1,food_times[i]));
        }

        //음식을 먹는데 걸리는 시간을 오름차순으로 정렬
        Collections.sort(list,new Comparator<Food>() {

            @Override
            public int compare(Food o1, Food o2) {

                return o1.time - o2.time;
            }
        });

        int prev = 0;//이전 음식의 시간
        int idx = 0;//음식 번호

        for (Food food : list) {

            long diff = food.time - prev;//이전 음식 시간과의 차이

            long spen = diff * len;//가장 적은 시간이 걸리는 음식을 기준으로 전체 음식을 먹는데 걸리는 시간

            if (k >= spen) {//k가 가장 적은 시간이 걸리는 음식을 다 먹는데 시간보다 클 때는

                k -= spen;// 그 시간만큼 k에서 빼주고,
                prev = food.time;//다음 음식 시간 체크를 위해 현재 음식의 시간을 저장

            } else {

                k %= len;//몇 번째 먹을 차례인지를 구해줌

                List<Food> sub = list.subList(idx, list.size());//아직 남은 음식들의 번호를 리스트로 재구성

                Collections.sort(sub, new Comparator<Food>() {//리스트를 음식 번호를 기준으로 오름차순 정렬

                    @Override
                    public int compare(Food o1, Food o2) {

                        return o1.idx - o2.idx;
                    }
                });

                return sub.get((int)k).idx;//리스트에서 k에 해당하는 음식 번호를 반환
            }

            idx++;//현재 가장 시간이 적은 음식을 다 먹었기 때문에 다음 음식의 번호를 가리킨다.
            len--;//한 종류의 음식을 다먹었기 때문에 길이를 감소
        }

        return -1;//음식을 다 먹었다면, -1을 반환
    }
}
