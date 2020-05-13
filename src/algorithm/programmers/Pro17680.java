package algorithm.programmers;

import java.util.*;

/*
 * 2018 KAKAO BLIND RECRUITMENT
 * [1차] 캐시
 * */
public class Pro17680 {

    public int solution(int cacheSize, String[] cities) {
        ArrayList<String> lru = new ArrayList<>();

        int answer = 0;

        if (cacheSize == 0) {//캐시 사이즈가 0이면, 배열 길이*5로 반환
            answer = cities.length*5;
            return answer;
        }

        for (String city : cities) {

            String temp = city.toUpperCase();//도시 이름을 대문자로 통일

            if (lru.contains(temp)) {//LRU 캐시에 포함되어 있다면,

                lru.remove(temp);//도시 이름을 참조했으므로, 다시 맨뒤로 보낸다.
                lru.add(temp);
                answer++;//시간을 1증가

            } else {

                //LRU 캐시 사이즈가 꽉차있다면, 제일 오래된 캐시를 제거
                if (lru.size() == cacheSize) lru.remove(0);

                lru.add(temp);//캐시에 새로운 도시 이름을 추가

                answer+=5;//새로운 캐시를 참조했으므로, +5를 해준다.
            }
        }

        return answer;
    }
}
