package algorithm;

import java.util.Scanner;

public class Algorithm {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();

        if (n.charAt(0) == '0') {

            System.out.println(0);
            return;
        }

        long[] dp = new long[n.length()+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1,loop = n.length(); i < loop; i++) {

            char pre = n.charAt(i-1);
            char cur = n.charAt(i);

            if ('1' <= cur && cur <= '9') {

                dp[i+1] += dp[i];
                dp[i+1] %= 1000000;
            }

            if (!(pre == '0' || pre > '2' || (pre == '2' && cur > '6'))) {

                dp[i+1] += dp[i-1];
                dp[i+1] %= 1000000;
            }


        }

        System.out.println(dp[n.length()]%1000000);
	}
}
