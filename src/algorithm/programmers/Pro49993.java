package algorithm.programmers;

import java.util.*;

/*
 * 2018 summer/winter conding
 * 스킬 트리
 * */
public class Pro49993 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<Character> q = new LinkedList<>();
        String sumStr = "";

        int[] strLength = new int[skill_trees.length];

        for (int i = 0; i<skill_trees.length; i++) {
            sumStr += skill_trees[i];
            strLength[i] = skill_trees[i].length();
        }

        char[] strCharSum = sumStr.toCharArray();

        for (int i = 0; i<strCharSum.length; i++) {
            q.offer(strCharSum[i]);
        }

        int cnt=0;
        String target = "";

        while(!q.isEmpty()) {

            char item = q.poll();

            if  (skill.contains(""+item)) target += item;

            if ((--strLength[cnt]) == 0) {
                if (target.equals(skill.substring(0, target.length()))) {answer++;}
                cnt++;
                target = "";
            }

        }
        return answer;
    }
}
