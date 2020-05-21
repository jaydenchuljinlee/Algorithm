package algorithm.programmersLevel2;

/*
* 프로그래머스
* 주식가격
* */
public class Pro42584 {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        int cnt = 0;//시간을 저장할 값

        for (int i = 0; i< prices.length; i++) {

            for (int j = i+1; j < prices.length; j++) {
                cnt++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }

            answer[i] = cnt;

            cnt = 0;
        }


        return answer;
    }
}
