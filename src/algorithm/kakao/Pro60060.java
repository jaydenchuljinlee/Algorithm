package algorithm.kakao;

import java.util.*;

/*
* 2020 카카오 블라인드 코딩테스트
* 가사 검색
* */
public class Pro60060 {

    //문자 노드 클래스 정보
    private static class Trie {
        HashMap<Character, Trie> next;//다음 문자 노드를 가리킴
        HashMap<Integer, Integer> wordLen;//현재 문자열 길이까지 같은 동일한 문자열 갯수

        public Trie() {//초기화
            next    = new HashMap<>();
            wordLen = new HashMap<>();
        }

        //문자 정보 등록
        public void insert(String word, int len, int idx, int flag) {

            //문자열의 범위 밖이라면 종료
            if (word.length() == idx || idx < 0) return;

            //?를 만났다면 종료
            if (word.charAt(idx) == '?') return;

            //현재 문자열의 길이에 갯수를 추가
            wordLen.put(len,wordLen.getOrDefault(len,0) + 1);

            //현재 인덱스에 해당하는 문자
            char ch = word.charAt(idx);

            //다음 문자 노드중에 현재 문자를 포함하는 노드가 없을 때, 등록
            if (!next.containsKey(ch)) next.put(ch,new Trie());

            //해당 문자 노드에 문자열의 다음 인덱스부터 등록
            if (flag == 0) next.get(ch).insert(word,len,idx+1,0);
            else next.get(ch).insert(word,len,idx-1,1);

        }

        //쿼리에 대한 일치 문자열 갯수 탐색
        public int find(String query, int len, int idx, int flag) {

            //쿼리 범위 밖이면 종료
            if (query.length() == idx || idx < 0) return 0;

            //?를 만났을 때, 해당 쿼리 길이와 일치하는 문자열 갯수 반환
            if (query.charAt(idx) == '?') return wordLen.getOrDefault(len,0);

            //현재 인덱스의 문자
            char ch = query.charAt(idx);

            //현재 문자에 대한 다음 노드가 존재하지 않다면 종료
            if (!next.containsKey(ch)) return 0;

            //해당 문자열에 대한 다음 인덱스부터 재탐색
            if (flag == 0) return next.get(ch).find(query,len,idx+1,0);
            else return next.get(ch).find(query,len,idx-1,1);
        }
    }

    public static int[] solution(String[] words, String[] queries) {

        int[] answer = new int[queries.length];

        Trie root = new Trie();//문자열을 앞에서부터 읽기 위함
        Trie tail = new Trie();//문자열을 뒤에서부터 읽기 위함

        //모든 단어에 대한 문자 트리를 만들어준다
        for (String word : words) {

            root.insert(word,word.length(),0,0);
            tail.insert(word,word.length(),word.length()-1,1);
        }

        int idx = 0;


        for (String query : queries) {


            if (query.charAt(0) != '?') {//첫 번째 문자가 ?가 아니라면, 앞에서부터 읽는 root노드에서 찾는다
                answer[idx++] = root.find(query,query.length(),0,0);
            } else {//?라면, 뒤에서부터 읽는 tail노드에서 찾는다
                answer[idx++] = tail.find(query,query.length(),query.length()-1, 1);
            }
        }

        return answer;
    }
}
