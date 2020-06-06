package algorithm.kakaoEnterprise2020Summer;

import java.io.*;
import java.util.HashMap;

//네 번째 문제 : 최소 훈련 비용 검사 (탐색)
public class KakaoEnterSummer2020_4 {
    private static HashMap<String, HashMap<String,Integer>> map;
    private static int min;

    public static void solution() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new HashMap<>();

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        //m만큼 반복
        while(M-- > 0) {

            String[] str2 = br.readLine().split(" ");

            //M번 째 줄에서 입력받은 타겟의 정보
            HashMap<String,Integer> sub = map.getOrDefault(str2[0],new HashMap<>());

            //타겟 정보를 추가
            sub.put(str2[1],Integer.parseInt(str2[2]));

            //map에 해당 진열의 타겟 정보를 담는다.
            map.put(str2[0],sub);
        }

        int Q = Integer.parseInt(br.readLine());

        //쿼리 수만큼 반복
        while(Q-- > 0) {

            //최솟값 초기화
            min = Integer.MAX_VALUE;

            String[] query = br.readLine().split(" ");

            //쿼리의 처음과 끝이 같을 때는 0을 리턴
            if (query[0].equals(query[1])) {
                System.out.println(0);
                continue;
            }

            //쿼리의 처음이 진열 map에 들어있다면 타겟 쿼리를 찾는다.
            if (map.get(query[0]) != null) {

                min = find(map.get(query[0]),query[1],0);
            }

            //최솟값이 변하지 않았다면 -1을
            if (min == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {//변했다면 최솟값을 출력
                System.out.println(min);
            }

        }
    }

    //타겟 쿼리를 찾는 메서드
    private static int find(HashMap<String,Integer> query,String next, int sum) {

        //타겟 쿼리를 찾았다면
        if (query.get(next) != null) {

            //최솟값을 셋팅
            min = Math.min(sum+query.get(next),min);

        } else {

            //현재 쿼리의 타겟 정보를 기준
            for (String key : query.keySet()) {

                //진열 map에서 쿼리의 타겟 정보가 존재한다면
                if (map.get(key) != null) {

                    //sum에 현재 타겟 정보의 훈련 비용을 추가하고 탐색
                    min = find(map.get(key),next,sum+query.get(key));
                }
            }
        }

        return min;
    }
}
