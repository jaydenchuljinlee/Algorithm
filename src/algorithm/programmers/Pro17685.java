package algorithm.programmers;

import java.util.*;

/*
 * 2018 카카오 블라인드
 * [3차] 자동완성
 * */
public class Pro17685 {

    private static class Trie {
        HashMap<Character,Trie> next;
        int len;

        public Trie() {
            next 	= new HashMap<>();
            len = 0;
        }

        public void insert(String word,int idx) {

            if (word.length() == idx) return;

            char ch = word.charAt(idx);

            if (!next.containsKey(ch)) next.put(ch, new Trie());

            next.get(ch).len++;
            next.get(ch).insert(word,idx+1);

        }

        public int find(String word,int idx) {

            if (idx == word.length()) return idx;

            char ch = word.charAt(idx);

            if (next.get(ch).len > 1) return next.get(ch).find(word, idx+1);
            else if (next.get(ch).len == 1) return idx+1;
            else return idx;

        }

    }

    public static int solution(String[] words) {
        int answer = 0;

        Trie root = new Trie();

        Arrays.sort(words);

        for (String word : words) {

            root.insert(word, 0);

        }

        for (String word : words) {
            int cnt = root.find(word, 0);
            answer += cnt;
        }

        return answer;
    }
}
