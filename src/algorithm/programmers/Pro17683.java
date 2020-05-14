package algorithm.programmers;

import java.util.*;

/*
* 2018 īī�� ����ε�
* [3��] ��ݱװ�
* */
public class Pro17683 {

    //���ǿ� ���� ������ ���� Ŭ����
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

        //���� ����ð� - ���� ���������� ����
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

        int idx = 0;//�ε����� ���� ����

        m = changeOfSharp(m);//#�� ġȯ���ִ� �޼���

        for (String musicinfo : musicinfos) {

            String[] info = musicinfo.split(",");

            String[] time1 = info[0].split(":");
            String[] time2 = info[1].split(":");

            //����ð��� �Ľ����ش�.
            int runtime = (Integer.parseInt(time2[0])*60+Integer.parseInt(time2[1]))
                    - (Integer.parseInt(time1[0])*60+Integer.parseInt(time1[1]));

            String melody = "";

            //#�� ġȯ���ش�.
            info[3] = changeOfSharp(info[3]);

            //��ε� ����ð����� �� ��,
            if (info[3].length() > runtime) melody = info[3].substring(0, runtime);
            else {//��ε� ����ð����� ���� ��,

                int repeat = runtime / info[3].length();//�ݺ��� Ƚ���� ������ ǥ��
                int remain = runtime % info[3].length();//�ݺ��Ŀ� �� ��° ��ε���� ǥ���ؾ������� ǥ��

                //��ε� �ݺ� Ƚ����ŭ �ݺ��Ѵ�
                for (int i = 0; i < repeat; i++) melody+=info[3];

                //��ε� �߰��� ǥ���ؾ��� ��ε� �߰��Ѵ�.
                melody+=info[3].substring(0, remain);
            }

            //��ε�� �ߺ��� ���� �� �����Ƿ� ������ �������� ���ĵ� ť�� ������ �־��ش�.
            if (melody.contains(m)) {

                Music music = new Music(idx,runtime,info[2],melody);

                pq.add(music);
            }

            idx++;//�ε��� ����
        }

        String answer = "";

        if (pq.isEmpty()) answer = "(None)";//��ġ�ϴ� ��ε� ���� ��,
        else answer = pq.poll().title;//��������� ���� ���� ��ε� ������ ��ȯ

        return answer;
    }

    //#�� ġȯ���ִ� �޼���
    private String changeOfSharp(String notes) {

        notes = notes.replaceAll("C#", "H")
                .replaceAll("D#", "I")
                .replaceAll("F#", "J")
                .replaceAll("G#", "K")
                .replaceAll("A#", "L");

        return notes;
    }
}
