package algorithm.netmarble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Netmarble1 {

    public static int solution(int n) {

        HashMap<Integer,Integer> map = new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);

        int idx = 2;

        while(list.size() < n) {

            int cur = (int)Math.pow(idx,2);

            if (list.contains(cur)) {

                idx++;
                continue;
            }

            for (int key : map.keySet()) {

                int s = map.get(key);

                while (true) {

                    int num = (int)Math.pow(key,s+1);

                    if (list.contains(num)) {

                        s++;
                        continue;
                    }

                    if (num >= cur) break;

                    list.add(num);
                    map.put(key,s+1);
                }
            }

            list.add(cur);
            map.put(idx,map.getOrDefault(idx,1)+1);

            idx++;
        }

        Collections.sort(list);

        System.out.println(list);

        return list.get(n-1);
    }
}
