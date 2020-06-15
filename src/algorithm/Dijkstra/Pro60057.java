package algorithm.Dijkstra;

import java.util.*;

/*
* 2020 카카오 블라인드 코딩테스트
* 문자열 압축
* */
public class Pro60057 {

    public int solution(String s) {
        //최대 압축이 가능한 길이는 절반이다.
        int len = s.length()%2 == 0 ? s.length()/2 : (s.length()/2)+1;

        int min = Integer.MAX_VALUE;

        //압축 길이
        for (int i = 1; i <= len; i++) {

            StringBuilder sb = new StringBuilder("");//압축된 문자열을 저장할 객체

            int left	= 0;//왼쪽 구간
            int right 	= left+i;//오른쪽 구간
            int cnt 	= 1;//현재 중복 문자열이 몇 개인지

            String s1 = s.substring(left,left+i);//left부터 i까지의 문자열
            sb.append(s1);//압축 문자열에 추가

            while(right+i <= s.length()) {//오른쪽 구간 검사 값이 전체 문자열의 길이보다 작거나 같아야한다.

                String s2 = s.substring(right,right+i);//오른쪽 구간에 대한 문자열 생성
                if (!s1.equals(s2)) {//왼쪽과 오른쪽이 같지 않을 때,

                    left = right;//왼쪽에 오른쪽을 재구성
                    s1 = s2;

                    if (cnt > 1) sb.insert(sb.length()-i, cnt);//중복된 값이 있다면, 현재 문자열 앞에 갯수를 추가

                    sb.append(s1);//압축 문자열에 현재까지 만들어준 문자열을 저장

                    cnt = 1;//중복값을 다시 1로 만들어준다.
                } else {//왼쪽과 오른쪽이 같을 때,
                    cnt++;//중복값을 더해준다.
                }

                right += i;//오른쪽을 i만큼 증가

            }

            //마지막 오른쪽 값을 압축 문자열에 추가해주는 과정
            if (cnt > 1) sb.insert(sb.length()-i, cnt);

            sb.append(s.substring(right));
            min = Math.min(sb.length(), min);//현재 만들어준 문자열 길이와 최솟값을 비교
        }

        return min;
    }
}
