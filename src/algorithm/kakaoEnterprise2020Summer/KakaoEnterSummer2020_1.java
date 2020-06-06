package algorithm.kakaoEnterprise2020Summer;

import java.io.*;
import java.util.HashSet;

public class KakaoEnterSummer2020_1 {

    public static void solution()throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        HashSet<Integer> set = new HashSet<>();//���̽��� �ߺ����� �����ϱ����� set�� �����߽��ϴ�.


        if (input.length() >= 10) set.add(1);//ó���� ���̸� üũ�մϴ�.

        for (int i = 0, loop = input.length(); i < loop; i++) {

            char cur = input.charAt(i);

            //�� �׽�Ʈ ���̽��� üũ�ϰ� �ߺ����� set�� �����մϴ�.
            if ('a' <= cur && cur <= 'z') set.add(2);
            else if ('A' <= cur && cur <= 'Z') set.add(3);
            else if ('0' <= cur && cur <= '9') set.add(4);
            else set.add(5);
        }

        String answer = "LEVEL"+set.size();//����� �׽�Ʈ���̽��� �����ŭ ������ �÷��ݴϴ�.

        System.out.println(answer);
    }
}
