package algorithm.programmersLevel2;

/*
* 프로그래머스
* 예상 대진표
 */
public class Pro12985 {

    public int solution(int n, int a, int b) {

        int answer = 0;

        while(a>0) {

            answer++;

            a = (a+1)/2;
            b = (b+1)/2;
            
            if (a==b) break;
        }

        return answer;
    }
}
