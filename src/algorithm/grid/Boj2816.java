package algorithm.grid;

import java.util.Scanner;

/*
* 백준 2816
* 디지털 티비
* */
public class Boj2816 {

    public static String solution() {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sc.nextLine();

        int k1 = -1, k2 = -1;

        String cur = "";

        int idx = 0;

        while(idx < N) {

            cur = sc.nextLine();

            if ("KBS1".equals(cur)) k1 = idx;
            else if ("KBS2".equals(cur)) k2 = idx;

            if (k1 != -1 && k2 != -1) break;

            idx++;
        }

        StringBuilder sb = new StringBuilder("");

        int inOrder = k1 > k2 ? 1 : 0;

        for (int i = 0; i < k1; i++) sb.append("1");

        for (int i = 0; i < k1; i++) sb.append("4");

        for (int i = 0; i < k2 +inOrder; i++) sb.append("1");

        for (int i = 0; i < k2 + inOrder -1; i++) sb.append("4");

        return sb.toString();
    }
}
