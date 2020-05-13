package algorithm.programmers;

import java.util.*;

/*
 * 2018 KAKAO BLIND RECRUITMENT
 * [1차] 뉴스 클러스터링
 * */
public class Pro17678 {

    public static String solution(int n, int t, int m, String[] timetable) {

        String answer = "";

        //크루가 도착하는 시간을 오름차순으로 정렬
        PriorityQueue<Integer> crew = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {

                return o1-o2;
            }

        });

        for (String table : timetable) {

            //크루의 도착시간을 문자열->Integer 형태로 변환
            int time = Integer.parseInt(table.substring(0, 2))*60 + Integer.parseInt(table.substring(3));

            crew.add(time);
        }

        int busTime = 9*60;//버스가 처음 도착하는 시간 셋팅

        int last = 0;

        while(n-->0) {//

            int accept = m;//수용 인원을 초기화

            int time = 0;//마지막으로 탄 크루의 시간을 저장하기 위함

            while(!crew.isEmpty()) {//기다리는 크루가 있다면

                if (crew.peek() <= busTime && accept > 0) {//현재 버스의 도착시간보다 일찍왔으며, 수용인원도 있을 때,

                    accept--;
                    time = crew.poll();
                } else break;
            }

            //마지막 버스가 아님
            if (n > 0) {

                if (crew.isEmpty()) {//기다리는 크루가 없다면

                    last = busTime +((n+1)*t);//마지막 버스의 도착시간
                    break;
                }

                busTime += t;//버스의 다음 시간 셋팅

            } else {// 마지막 버스

                if (accept > 0) last = busTime;//수용인원이 있다면, 버스의 도착시간으로
                else last = time-1;//없다면, 마지막으로 탄 크루의 시간보다 1분 일찍

                break;

            }
        }

        answer = String.format("%02d",last/60) + ":" + String.format("%02d", last%60);

        return answer;
    }
}
