package algorithm.programmersLevel2;

import java.util.*;

/*
* ÇÁ·Î±×·¡¸Ó½º
* ¶¥µû¸Ô±â
* */
public class Pro12913 {

    int solution(int[][] land) {

        int answer = 0;

        int height = land.length;

        for (int i = 1; i < height; i++) {

            for (int j = 0; j < 4; j++ ) {

                int max = 0;

                for (int k = 0; k < 4; k++) {

                    if (j == k) continue;

                    max = Math.max(max,land[i-1][k]);
                }

                land[i][j] += max;
            }
        }

        Arrays.sort(land[height-1]);

        answer = land[height-1][3];

        return answer;
    }
}
