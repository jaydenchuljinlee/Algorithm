package algorithm.grid;

import java.util.*;

/*
* 백준 멀티탭 스케줄링
* */
public class Boj1700 {

    public static void solution() {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) list.add(sc.nextInt());

        ArrayList<Integer> answerList = new ArrayList<>();

        int answer = 0;

        for (int i = 0; i < m; i++) {

            int cur = list.get(i);

            if (answerList.contains(cur)) continue;

            if (answerList.size() < n) {
                answerList.add(cur);
                continue;
            }

            int idx = -1;

            int target = 0;

            for (int device : answerList) {

                int nidx = -1;

                for (int j = i+1; j < m; j++) {

                    if (device == list.get(j)) {

                        nidx = device;
                        break;
                    }
                }

                if (nidx == -1) {

                    target = answerList.indexOf(device);
                    break;
                } else {

                    if (nidx > idx) {

                        idx = nidx;
                        target = answerList.indexOf(device);
                    }

                }

            }

            answerList.remove(target);

            answerList.add(cur);
            answer++;

        }

        System.out.println(answer);
    }
}
