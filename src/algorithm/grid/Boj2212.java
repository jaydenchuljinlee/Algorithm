package algorithm.grid;

import java.util.Arrays;
import java.util.Scanner;

/*
* 백준 2212
* 센서
* */
public class Boj2212 {

    public static int solution() {

        Scanner sc = new Scanner(System.in);

        int answer = 0;

        int N = sc.nextInt();
        int K = sc.nextInt();

        if (K >= N) return 0;

        int[] road = new int[N];

        for (int i = 0; i < N; i++) road[i] = sc.nextInt();

        Arrays.sort(road);

        int[] diff = new int[N-1];

        for (int i = 0; i < N-1; i++) {

            diff[i] = Math.abs(road[i] - road[i+1]);
        }

        Arrays.sort(diff);

        for (int i = 0; i < N-K; i++) answer += diff[i];

        return answer;
    }
}
