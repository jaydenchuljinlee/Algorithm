package algorithm.programmers;

import java.util.*;

/*
* 2018 카카오 블라인드
* [3차] 방금그곡
* */
public class Pro17683 {

    //음악에 대한 정보를 담을 클래스
    private class Music {
        int idx;
        int runtime;
        String title;
        String melody;

        public Music(int idx,int runtime, String title, String melody) {
            this.idx = idx;
            this.runtime = runtime;
            this.title = title;
            this.melody = melody;
        }
    }

    public String solution(String m, String[] musicinfos) {

        if ("".equals(m)) return "(None)";

        //음악 재생시간 - 음악 순서순으로 정렬
        PriorityQueue<Music> pq = new PriorityQueue<Music>(new Comparator<Music>() {

            @Override
            public int compare(Music o1, Music o2) {

                if (o1.runtime > o2.runtime) return -1;
                else if (o1.runtime == o2.runtime) {

                    if (o1.idx < o2.idx) return -1;
                    else return 1;
                }

                return 1;
            }
        });

        int idx = 0;//인덱스를 담을 변수

        m = changeOfSharp(m);//#을 치환해주는 메서드

        for (String musicinfo : musicinfos) {

            String[] info = musicinfo.split(",");

            String[] time1 = info[0].split(":");
            String[] time2 = info[1].split(":");

            //재생시간을 파싱해준다.
            int runtime = (Integer.parseInt(time2[0])*60+Integer.parseInt(time2[1]))
                    - (Integer.parseInt(time1[0])*60+Integer.parseInt(time1[1]));

            String melody = "";

            //#을 치환해준다.
            info[3] = changeOfSharp(info[3]);

            //멜로디가 재생시간보다 길 때,
            if (info[3].length() > runtime) melody = info[3].substring(0, runtime);
            else {//멜로디가 재생시간보다 작을 때,

                int repeat = runtime / info[3].length();//반복할 횟수를 몫으로 표현
                int remain = runtime % info[3].length();//반복후에 몇 번째 멜로디까지 표현해야할지를 표현

                //멜로디를 반복 횟수만큼 반복한다
                for (int i = 0; i < repeat; i++) melody+=info[3];

                //멜로디에 추가로 표현해야할 멜로디를 추가한다.
                melody+=info[3].substring(0, remain);
            }

            //멜로디는 중복이 있을 수 있으므로 위에서 정의해준 정렬된 큐에 정보를 넣어준다.
            if (melody.contains(m)) {

                Music music = new Music(idx,runtime,info[2],melody);

                pq.add(music);
            }

            idx++;//인덱스 증가
        }

        String answer = "";

        if (pq.isEmpty()) answer = "(None)";//일치하는 멜로디가 없을 때,
        else answer = pq.poll().title;//실행순서가 제일 빠른 멜로디 정보를 반환

        return answer;
    }

    //#을 치환해주는 메서드
    private String changeOfSharp(String notes) {

        notes = notes.replaceAll("C#", "H")
                .replaceAll("D#", "I")
                .replaceAll("F#", "J")
                .replaceAll("G#", "K")
                .replaceAll("A#", "L");

        return notes;
    }
}
