package algorithm.programmers;

import java.util.*;

/*
 * 2019 카카오 블라인드
 * 후보키
 * */
public class Pro42890 {
    public int solution(String[][] relation) {
        int answer = 0;
        int m = relation.length;
        int n = relation[0].length;

        ArrayList<Integer> ans = new ArrayList<>();

        //컬럼으로 만들 수 있는 조합을 비트마스킹으로 표현
        for (int i = 1; i<=(1<<n)-1;i++) {

            Set<String> set = new HashSet<>();//중복된 값을 조사하기 위한 set

            for (int j = 0; j < m; j++) {//로우

                StringBuilder sb = new StringBuilder();//조합을 만들 문자열 객체

                for (int k = 0; k < n; k++) {//컬럼

                    if ((i&(1<<k)) > 0) {//&연산을 통해 i로 만들 수 있는 조합에 해당하는 컬럼이면 해당 컬럼의 값을 추가
                        sb.append(relation[j][k]);//조합을 추가
                    }
                }

                set.add(sb.toString());//합쳐진 조합을 set에 추가
            }

            //만들어진 조합의 사이즈가 m과 같아야 후보키 조건을 만족하고,
            //check()를 통해 기존에 등록된 조합과 부분 집합을 이루는 조합이 있는지를 검사
            if (set.size() == m && check(ans,i)) {
                ans.add(i);
            }
        }

        answer = ans.size();
        return answer;
    }

    //등록된 조합(ans)과 부분집합이 있는지를 검사
    private boolean check(ArrayList<Integer> ans, int now) {

        for (int i = 0; i < ans.size(); i++) {

            if ((ans.get(i)&now) == ans.get(i)) return false;
        }

        return true;
    }

}
