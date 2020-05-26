package algorithm.programmersLevel2;

import java.util.*;

/*
* 2017 카카오 코드 본선
* 단체사진 찍기
* */
public class Pro1835 {
    private HashMap<Character, Integer> map;
    private int[] permute;
    private boolean[] selected;
    int cnt;

    public int solution(int n, String[] data) {

        map = new HashMap<>();

        map.put('A',0);
        map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);

        permute  = new int[8];
        selected = new boolean[8];
        cnt = 0;

        dfs(data,0);

        return cnt;
    }

    public void dfs(String[] data, int idx) {

        if (idx == 8) {

            for (int i = 0, loop = data.length; i < loop; i++) {

                int c1 = permute[map.get(data[i].charAt(0))];
                int c2 = permute[map.get(data[i].charAt(2))];
                char express = data[i].charAt(3);
                int digit = data[i].charAt(4) - '0';

                if (express == '>') {

                    if (Math.abs(c1-c2) -1 <= digit) return;

                } else if (express == '<') {

                    if (Math.abs(c1-c2) -1 >= digit) return;

                } else {

                    if (Math.abs(c1-c2) -1 != digit) return;
                }

            }

            cnt++;
            return;
        }

        for (int i = 0; i < 8; i++) {

            if (!selected[i]) {

                selected[i] = true;
                permute[idx] = i;
                dfs(data,idx+1);
                selected[i] = false;
            }
        }
    }
}
