package algorithm.programmers;

import java.util.*;

/*
 * 2019 카카오 블라인드
 * 실패율
 * */
public class Pro42889 {

    //스테이지에 대한 인덱스와 실패율을 저장할 클래스
    private static class Stage {
        int idx;
        double percent;

        public Stage(int idx, double percent) {
            this.idx		= idx;
            this.percent	= percent;
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] fail = new int[N];//스테이지에 대한 실패 횟수를 저장할 배열
        int[] ans = new int[N];//실패율을 내림차순으로 저장할 결과 배열
        int total = stages.length;//실패율을 구하기 위해 초기값

        for (int stage : stages) {

            if (stage > N) continue;//모든 스테이지를 성공했다면 다음 분기문으로
            fail[stage-1]++;//실패 횟수를 저장
        }

        //우선순위큐에 실패율-인덱스를 내림차순으로 정렬한다.
        PriorityQueue<Stage> pq = new PriorityQueue<Stage>(new Comparator<Stage>() {

            @Override
            public int compare(Stage o1, Stage o2) {

                if (o1.percent - o2.percent < 0) return 1;
                else if (o1.percent - o2.percent == 0) {

                    if (o1.idx < o2.idx) return -1;
                    else return 1;
                }
                else return -1;
            }
        });

        for (int i = 0,loop = fail.length; i < loop; i++) {

            Stage s = new Stage(i,(double)fail[i]/total);//문제에서 제시된 실패율 공식을 통해 실패율을 구해준다.

            pq.add(s);//실패율을 정렬해줄 우선순위큐에 해당 객체를 저장
            total = (total - fail[i] == 0) ? 1 : total - fail[i];//다음 스테이지에서 현재 스테이지의 실패횟수를 빼준다.

        }

        for (int i = 0,loop = ans.length; i < loop; i++) {

            ans[i] = pq.poll().idx+1;//결과 배열에 내림차순으로 정렬된 실패율을 저장해준다.

        }

        return ans;
    }
}
