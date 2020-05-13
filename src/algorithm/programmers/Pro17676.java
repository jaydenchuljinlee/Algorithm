package algorithm.programmers;

import java.util.*;

/*
* 2018 KAKAO BLIND RECRUITMENT
* [1��] �߼� Ʈ����
* */
public class Pro17676 {

    //�α� �����͸� �ٷ������ Ŭ����
    private class Process {
        String date;
        float start;
        float end;

        public Process(String date, float start, float end) {
            this.date = date;
            this.start = start;
            this.end = end;

        }

    }

    public int solution(String[] lines) {
        int answer = 0;

        ArrayList<Process> list = new ArrayList<>();

        for (String line : lines) {

            line = line.replace("s","");//ó�� �ӵ��� ���� �������·� �ٲ��ֱ� ���� ���� ó��

            String[] str = line.split(" ");//������ �������� ���ڿ��� ���� ���´�.

            String date = str[0];

            String[] time = str[1].split(":");//���� �ð��� �ٽ� :�� �������� ������.

            //���� �ð��� �Ǽ� ���·� �ٲ��ش�.
            float end = (Float.parseFloat(time[0])*3600) + (Float.parseFloat(time[1])*60) + Float.parseFloat(time[2]);

            //�����ð��� ó�� �ӵ��� ���ؼ� ���۽ð��� �����ش�.
            //0.001�� �����ִ� ������ ���۽ð��� ���� �ð��� �����ϱ� ����
            float start = (end - Float.parseFloat(str[2])) + (float)0.001;

            list.add(new Process(date,start,end));//����Ʈ�� ����ش�.
        }

        Collections.sort(list, new Comparator<Process>() {//���� �ð�-���� �ð��� �������� �������ش�.

            @Override
            public int compare(Process p1, Process p2) {

                if (p1.end == p2.end) {

                    if (p1.start < p2.start) return -1;
                    else return 1;

                } else if (p1.end > p2.end) {
                    return 1;
                } else {
                    return -1;
                }

            }
        });

        for (int i = 0,outter = list.size(); i < outter; i++) {

            Process cur = list.get(i);

            float range = cur.end+(float)0.999;//���� �ð��� �������� 1�� ���� �ð��� �����ش�.

            int cnt = 0;

            for (int j = i,inner = list.size(); j < inner; j++) {

                Process next = list.get(j);
                //System.out.println("range : " + range + ", start : " + next.start + "," + (range >= next.start));

                if (range >= next.start) cnt++;//range ���� ���� ���Ϸ��� �α��� ���� �ð��� ���� ���
            }

            answer = Math.max(cnt,answer);
        }

        return answer;
    }
}
