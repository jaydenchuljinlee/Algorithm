package algorithm.grid;

import java.util.Scanner;

public class Boj1343 {

    public static void solution() {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        StringBuilder sb = new StringBuilder("");

        while(s.indexOf(".") != -1) {

            int len = s.substring(0,s.indexOf(".")).length();

            s = s.substring(len+1);

            findStr(s,sb,len);

            sb.append(".");
        }

        if (s.length() != 0) {

            int len = s.length();

            findStr(s,sb,len);
        }

        System.out.println(sb.toString());
    }

    private static void findStr(String s,StringBuilder sb, int len) {

        if (len != 0) {

            if (len%4 == 0) {

                for (int i = 0; i < len; i++) sb.append("A");
            } else if (len%2 == 0) {

                int rem = len-2;

                len%=4;

                for (int i = 0; i < rem; i++) sb.append("A");

                for (int i = 0; i < len; i++) sb.append("B");
            } else {
                System.out.println(-1);
                return;
            }
        }

    }
}
