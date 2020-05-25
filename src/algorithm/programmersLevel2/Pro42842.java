package algorithm.programmersLevel2;



/*
* 프로그래머스
* 카펫
* */
public class Pro42842 {

    public int[] solution(int brown, int red) {

        int width  = 0;
        int height = 0;

        for (int i = 1; i <= red; i++) {

            width = i;

            if (red%i != 0) continue;

            height = red/i;

            if (width*2 + height*2 + 4 == brown) break;
        }


        int[] answer= {Math.max(width,height)+2,Math.min(width,height)+2};

        return answer;
    }
}
