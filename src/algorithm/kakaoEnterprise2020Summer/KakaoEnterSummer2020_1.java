package algorithm.kakaoEnterprise2020Summer;

import java.io.*;
import java.util.HashSet;

public class KakaoEnterSummer2020_1 {

    public static void solution()throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        HashSet<Integer> set = new HashSet<>();//케이스를 중복없이 저장하기위해 set을 선택했습니다.


        if (input.length() >= 10) set.add(1);//처음엔 길이를 체크합니다.

        for (int i = 0, loop = input.length(); i < loop; i++) {

            char cur = input.charAt(i);

            //각 테스트 케이스를 체크하고 중복없이 set에 저장합니다.
            if ('a' <= cur && cur <= 'z') set.add(2);
            else if ('A' <= cur && cur <= 'Z') set.add(3);
            else if ('0' <= cur && cur <= '9') set.add(4);
            else set.add(5);
        }

        String answer = "LEVEL"+set.size();//통과한 테스트케이스의 사이즈만큼 레벨을 올려줍니다.

        System.out.println(answer);
    }
}
