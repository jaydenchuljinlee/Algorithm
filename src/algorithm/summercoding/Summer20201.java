package algorithm.summercoding;

import java.util.ArrayList;

public class Summer20201 {

    public static int solution(int n) {

        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(3);

        int degree = 1;

        while(true) {

            int k = 2*degree - 1;

            int cur = list.get(list.size()-1);

            int len = list.size();

            for (int i = 0; i < len-1; i++) {

                list.add(list.get(i)+cur);
            }

            //System.out.println(list);

            list.add((int)Math.pow(3,++degree));

            if (list.size() >= n) {

                //System.out.println(list);

                answer = list.get(n-1);
                break;
            }

        }

        //System.out.println(answer);

        return answer;
    }
}
