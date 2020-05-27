package algorithm.programmersLevel2;

/*
* 프로그래머스
* 다음 큰 숫자
* */
public class Pro12911 {

    public int solution(int n) {

        String str = Integer.toBinaryString(n);

        int cnt = 0;

        for (int i = 0, loop = str.length(); i < loop; i++) {

            if (str.charAt(i) == '1') cnt++;
        }

        while(true) {

            n++;

            str = Integer.toBinaryString(n);

            int ncnt = 0;

            for (int i = 0, loop = str.length(); i < loop; i++) {

                if (str.charAt(i) == '1') ncnt++;
            }

            if (cnt == ncnt) break;
        }

        return n;
    }
}
