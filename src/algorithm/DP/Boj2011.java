package algorithm.DP;

import java.util.Scanner;

/*
* 백준 2011
* 암호코드
* */
public class Boj2011 {

    public static void solution() {

        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();

        long[] dp = new long[n.length()+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < dp.length; i++) {

            char pre = n.charAt(i-1);
            char cur = n.charAt(i);

            if ('1' <= cur && cur <= '9') {

                dp[i+1] += dp[i];
                dp[i+1] %= 1000000;
            }

            if (pre == 1 || !(pre == 2 && cur > '6')) {

                dp[i+1] += dp[i];
                dp[i+1] %= 1000000;
            }

            System.out.println(dp[n.length()]%1000000);
        }
    }
}
