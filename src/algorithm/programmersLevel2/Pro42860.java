package algorithm.programmersLevel2;

import java.util.*;

/*
* 프로그래머스
* 조이스틱
* */
public class Pro42860 {
    public static int solution(String name) {

        int answer = 0;

        StringBuilder nameBuilder = new StringBuilder(name);//name

        StringBuilder aBuilder = new StringBuilder("");//A문자열

        //A문자열 생성
        for (int i = 0, loop = name.length(); i < loop; i++) aBuilder.append('A');

        int start = 0;//문자열의 A를 탐색하기 위한 인덱스

        while(true) {

            int left  = start;
            int right = start;

            //A가 아닌 문자일 때,
            if (nameBuilder.charAt(start) != 'A') {

                answer += getMin(nameBuilder.charAt(start));//위,아래중 더 적은 이동을 찾는다.
                nameBuilder.setCharAt(start,'A');//name의 문자를 A로 바꿔준다.
            }

            //name의 모든 문자가 A로 바꼈을 때 종료한다.
            if (aBuilder.toString().equals(nameBuilder.toString())) break;

            //이동 횟수
            int move = 0;

            while(true) {

                left--;
                right++;
                move++;

                //왼쪽이 구간을 넘어서면 오른쪽 끝으로 만들어줌
                if (left < 0) left = nameBuilder.length()-1;

                //오른쪽이 구간을 넘어서면 왼쪽 끝으로 만들어줌
                if (right == nameBuilder.length()) right = 0;

                //문자 요소가 A가 아니라면
                if (nameBuilder.charAt(right) != 'A') {

                    answer += move;//결과 값에 이동 횟수 추가
                    start = right;//다음 탐색 인덱스를 결정
                    break;
                }

                //문자 요소가 A가 아니라면
                if (nameBuilder.charAt(left) != 'A') {

                    answer += move;
                    start = left;
                    break;
                }


            }
        }


        return answer;
    }

    //위,아래 이동 최솟값
    public static int getMin(char ch) {

        return Math.abs(ch - 'A') < Math.abs('Z' - ch)+1 ? Math.abs(ch - 'A') : Math.abs('Z' - ch)+1;
    }
}
