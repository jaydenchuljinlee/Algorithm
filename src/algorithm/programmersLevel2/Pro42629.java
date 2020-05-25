package algorithm.programmersLevel2;

import java.util.*;

/*
* 프로그래머스
* 라면공장
* */
public class Pro42629 {

    private class Supply {
        int suppliment;
        int date;

        public Supply(int suppliment, int date) {
            this.date = date;
            this.suppliment = suppliment;
        }
    }

    public int solution(int stock, int[] dates, int[] supplies, int k) {

        PriorityQueue<Supply> pq = new PriorityQueue<>(new Comparator<Supply>() {

            @Override
            public int compare(Supply o1, Supply o2) {

                if (o1.suppliment > o2.suppliment) return -1;
                else if (o1.suppliment < o2.suppliment) return 1;
                else {

                    if (o1.date < o2.date) return -1;
                    else return 1;
                }
            }
        });

        ArrayList<Supply> list = new ArrayList<>();

        for (int i = 0, loop = dates.length; i < loop; i++) {

            Supply s = new Supply(supplies[i],dates[i]);

            pq.add(s);
        }

        for (int i = 0, loop = dates.length; i < loop; i++) {

            list.add(pq.poll());
        }

        int answer = 0;

        while(stock < k) {

            for (Supply s : list) {

                if (stock >= s.date) {

                    stock += s.suppliment;

                    list.remove(s);
                    answer++;
                    break;
                }
            }

        }

        return answer;
    }
}
