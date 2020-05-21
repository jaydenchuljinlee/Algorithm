package algorithm.programmersLevel2;

/*
* 프로그래머스
* 124 나라의 숫자
* */
public class Pro12899 {

    public String solution(int n) {

        String answer = "";

        while(n>0) {

            //n을 3으로 나눈 나머지의 인덱스가 4,1,2 중 해당하는 값을 결과값 앞에 추가
            answer += "412".charAt(n%3) + answer;

            n = (n-1)/3;//n을 단순히 3으로 나누면은 1,2,3에 대한 3진수가 된다. 따라서 (n-1)로 나눠야한다.
        }

        return answer;
    }
}
