package algorithm.programmers;

/*
 * 2018 카카오 블라인드
 * [3차] n진수 게임
 * */
public class Pro17687 {

    public String solution(int n, int t, int m, int p) {
        //표현 가능한 진법을 셋팅
        String[] number = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

        //
        String value = "0";

        int idx = 1;//숫자를 n진법으로 표현하기 위한 변수
        int count = 1;//n진법으로 표기한 글자수들을 세기위한 변수

        boolean flag = true;//n진법을 표현하기 위한 flag변수

        while(count < t*m) {//총 글자수가 m명이서 만들 수 있는 총 턴수보다 작을 때
            flag = true;
            String temp = "";//진법을 담을 변수
            int num = idx;//다음 n진법을 표현하기 위한 변수

            //n진법을 구하는 과정. 일반적으로 구하는 방식의 반대로 생각하면 된다.
            while(flag) {

                if (num / n == 0) flag = false;//더이상 나눌 수 없을 때

                temp = number[num%n] + temp;//나머지를 n진법 배열에 맞는 값으로 더해줌
                num/=n;//n진법으로 구할 숫자의 다음 요소
            }

            count += temp.length();//현재 n진법 숫자의 길이를 더해줌
            value += temp;//n진법으로 만든 숫자를 더해줌
            idx++;//다음 숫자

        }

        String answer = "";

        for (int i = 0,j = 0; i < count&& j < t; i++) {//턴 수와 몇 번째 차례인지 구하기 위함

            if (i%m == p-1) {//자기 차례인지 확인
                answer += value.charAt(i);//n진법으로 만든 숫자 게임에서 i번째 위치한 값을 결과 값에 추가
                j++;//다음 턴
            }
        }
        return answer;
    }
}
