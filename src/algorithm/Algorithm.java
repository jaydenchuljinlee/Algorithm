package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {

    public static void solution() throws IOException

    {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int k = sc.nextInt();

        sc.nextLine();

        String num = sc.nextLine();

        StringBuilder answer = new StringBuilder("");

        int len = num.length();

        int idx = 0;

        for (int i = 0; i < len - k; i++) {

            int max = 0;

            for (int j = idx; j <= i+k; j++) {

                int next = num.charAt(j) - '0';

                if (next > max) {

                    idx = j+1;
                    max = next;
                }
            }

            answer.append(max);
        }

        System.out.println(answer.toString());
    }

	public static void main(String[] args) throws IOException{

        solution();
	}

}
