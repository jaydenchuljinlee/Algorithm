package algorithm.programmers;

import java.util.*;

public class Pro64065 {

    public static int[] solution(String s) {

        List<String> answerList = new ArrayList<>();//����� ���� ����Ʈ

        //�켱���� ť�� Ʃ���� ���� ������ ����
        PriorityQueue<List<String>> pq = new PriorityQueue(new Comparator<List<String>> () {

            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.size() - o2.size();
            }
        });

        String[] str = s.substring(2,s.length()-2).split("\\},\\{");//Ʃ���� ,�� �������� ������ �迭�� ����

        for (String item : str) {

            //System.out.println(item);
            String[] tuple = item.split(",");//������ Ʃ�� ���ڿ��� �ٽ� ,�� �������� ������ Ʃ�ÿ� ����

            pq.add(Arrays.asList(tuple));//Ʃ���� ����Ʈ�� ��ȯ�ؼ� �켱���� ť�� ��´�
        }

        List<String> cur = pq.poll();//ó�� ���̰� ���� ���� Ʃ�ú��� �����ͼ� ����Ʈ�� ����ش�.

        for (String item : cur) answerList.add(item);//������ Ʃ���� ������� ��� ����Ʈ�� ����ش�.

        while(!pq.isEmpty()) {//Ʃ�� ���� Ž��

            cur = pq.poll();//Ʃ�� ����Ʈ

            for (String item : cur) {//���� Ʃ���� ��ҵ�

                if (answerList.contains(item)) continue;//Ʃ���� ��Ұ� �������Ʈ�� ���ԵǾ� �ִٸ�, �Ѿ��.


                answerList.add(item);//���� Ʃ�� ����Ʈ�� �����ִ� ���� ��� ��� ����Ʈ�� �߰�

            }
        }

        //System.out.println(answerList);

        int[] answer = new int[answerList.size()];//Ʃ���� �������Ʈ�� �迭�� ������ֱ� ����.

        for (int i = 0 ; i < answer.length; i++) answer[i] = Integer.parseInt(answerList.get(i));

        return answer;
    }
}
