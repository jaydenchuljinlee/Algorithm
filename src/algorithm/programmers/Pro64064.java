package algorithm.programmers;

import java.util.*;

/*
 * 2019 카카오 개발자 겨울 인턴십
 * 불량 사용자
 * */
public class Pro64064 {

    private int user_len,ban_len;
    private String[] user_id,banned_id;
    private boolean[] visited;//응모자 ID의
    private HashSet<String> set;

    public int solution(String[] User_id, String[] Banned_id) {

        user_id = User_id;
        banned_id = Banned_id;

        user_len = user_id.length;
        ban_len = banned_id.length;

        visited = new boolean[user_id.length];

        set = new HashSet<>();

        int answer = 0;

        dfs(0,"");

        answer = set.size();

        return answer;
    }

    public void dfs(int idx, String str) {

        if (idx == ban_len) {

            StringBuilder sb = new StringBuilder("");

            for (int i = 0; i < user_len; i++) {

                if (str.contains(""+i)) sb.append(""+i);
            }

            if (!set.contains(sb.toString())) {
                //System.out.println(str);
                set.add(sb.toString());
            }

            return;
        }

        for (int i = 0; i < user_len; i++) {

            if (visited[i]) continue;

            String regex = banned_id[idx].replace("*",".");

            if (user_id[i].matches(regex)) {

                visited[i] = true;
                dfs(idx+1,str+i);
                visited[i] = false;
            }
        }

    }
}
