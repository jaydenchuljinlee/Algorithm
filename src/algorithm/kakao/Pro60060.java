package algorithm.kakao;

import java.util.*;

/*
* 2020 īī�� ����ε� �ڵ��׽�Ʈ
* ���� �˻�
* */
public class Pro60060 {

    //���� ��� Ŭ���� ����
    private static class Trie {
        HashMap<Character, Trie> next;//���� ���� ��带 ����Ŵ
        HashMap<Integer, Integer> wordLen;//���� ���ڿ� ���̱��� ���� ������ ���ڿ� ����

        public Trie() {//�ʱ�ȭ
            next    = new HashMap<>();
            wordLen = new HashMap<>();
        }

        //���� ���� ���
        public void insert(String word, int len, int idx, int flag) {

            //���ڿ��� ���� ���̶�� ����
            if (word.length() == idx || idx < 0) return;

            //?�� �����ٸ� ����
            if (word.charAt(idx) == '?') return;

            //���� ���ڿ��� ���̿� ������ �߰�
            wordLen.put(len,wordLen.getOrDefault(len,0) + 1);

            //���� �ε����� �ش��ϴ� ����
            char ch = word.charAt(idx);

            //���� ���� ����߿� ���� ���ڸ� �����ϴ� ��尡 ���� ��, ���
            if (!next.containsKey(ch)) next.put(ch,new Trie());

            //�ش� ���� ��忡 ���ڿ��� ���� �ε������� ���
            if (flag == 0) next.get(ch).insert(word,len,idx+1,0);
            else next.get(ch).insert(word,len,idx-1,1);

        }

        //������ ���� ��ġ ���ڿ� ���� Ž��
        public int find(String query, int len, int idx, int flag) {

            //���� ���� ���̸� ����
            if (query.length() == idx || idx < 0) return 0;

            //?�� ������ ��, �ش� ���� ���̿� ��ġ�ϴ� ���ڿ� ���� ��ȯ
            if (query.charAt(idx) == '?') return wordLen.getOrDefault(len,0);

            //���� �ε����� ����
            char ch = query.charAt(idx);

            //���� ���ڿ� ���� ���� ��尡 �������� �ʴٸ� ����
            if (!next.containsKey(ch)) return 0;

            //�ش� ���ڿ��� ���� ���� �ε������� ��Ž��
            if (flag == 0) return next.get(ch).find(query,len,idx+1,0);
            else return next.get(ch).find(query,len,idx-1,1);
        }
    }

    public static int[] solution(String[] words, String[] queries) {

        int[] answer = new int[queries.length];

        Trie root = new Trie();//���ڿ��� �տ������� �б� ����
        Trie tail = new Trie();//���ڿ��� �ڿ������� �б� ����

        //��� �ܾ ���� ���� Ʈ���� ������ش�
        for (String word : words) {

            root.insert(word,word.length(),0,0);
            tail.insert(word,word.length(),word.length()-1,1);
        }

        int idx = 0;


        for (String query : queries) {


            if (query.charAt(0) != '?') {//ù ��° ���ڰ� ?�� �ƴ϶��, �տ������� �д� root��忡�� ã�´�
                answer[idx++] = root.find(query,query.length(),0,0);
            } else {//?���, �ڿ������� �д� tail��忡�� ã�´�
                answer[idx++] = tail.find(query,query.length(),query.length()-1, 1);
            }
        }

        return answer;
    }
}
