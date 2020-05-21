package algorithm.programmersLevel2;

import java.util.*;

/*
* 프로그래머스
* 다리를 지나는 트럭
* */
public class Pro42583 {

    //트럭 정보 클래스
    private static class Truck{
        int weight;//트럭의 무게
        int waittingTime;//트럭의 현재 소요 시간

        public Truck(int weight, int waittingTime) {
            this.weight = weight;
            this.waittingTime = waittingTime;
        }

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Truck> waitting = new LinkedList<>();//대기하고 있는 트럭
        ArrayList<Truck> passing = new ArrayList<>();//지나고 있는 트럭

        for (int info : truck_weights) {//트럭 정보를 대기 큐에 추가해준다.

            waitting.add(new Truck(info,bridge_length));
        }

        int answer = 0;

        while(!waitting.isEmpty() || !passing.isEmpty()) {//대기중인 트럭이 있거나 다리를 지나는 트럭이 있을 때까지

            answer++;

            //다리를 지나는 트럭이 있고 제일 앞 트럭이 다리를 건넜을 때,
            if (!passing.isEmpty() && passing.get(0).waittingTime == 0) {

                weight += passing.get(0).weight;//현재 가능 무게에서 건넌 트럭의 무게를 더해준다.
                passing.remove(0);//다리를 지나는 리스트에서 제거해준다.
            }

            //대기중인 트럭이 있고 제일 앞 트럭의 무게가 현재 가능 무게보다 작거나 같을 때
            if (!waitting.isEmpty() && (waitting.peek().weight <= weight)) {

                weight -= waitting.peek().weight;//현재 가능 무게에서 트럭의 무게를 빼준다.

                passing.add(waitting.poll());//다리를 지나는 리스트에 추가해준다.
            }

            //다리를 지나는 트럭들의 소요시간을 1초 감소
            for (Truck truck : passing) {

                truck.waittingTime--;
            }
        }

        return answer;
    }

}
