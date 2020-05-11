package algorithm.programmers;

import java.util.*;

/*
 * 2018 summer/winter conding
 * ��ƼĿ ������(2)
 * */
public class Pro12971 {

    public static int solution(int sticker[]) {
        int answer = 0;

        int len = sticker.length;

        if (len == 1) return sticker[0];

        int[] dp1 = new int[len];
        int[] dp2 = new int[len];

        //ù��° ��ƼĿ�� ���� ���
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for (int i = 2; i < len-1;i++) dp1[i] = Math.max(dp1[i-1],dp1[i-2] + sticker[i]);


        //ù��° ��ƼĿ�� ���� �ʴ� ���
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < len; i++) dp2[i] = Math.max(dp2[i-1],dp2[i-2] + sticker[i]);

        answer = Math.max(dp1[len-2],dp2[len-1]);

        return answer;
    }
}
