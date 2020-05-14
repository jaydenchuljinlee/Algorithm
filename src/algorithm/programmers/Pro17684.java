package algorithm.programmers;

import java.util.*;

/*
 * 2018 īī�� ����ε�
 * [3��] ����
 * */
public class Pro17684 {

    public int[] solution(String msg) {

        //�ε��� �ʱ� ����
        ArrayList<String> index = new ArrayList<>(Arrays.asList(new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V"
                ,"W","X","Y","Z"}));

        //���̰� �ϳ����, �ε������� �ش� ��ġ�� ã�Ƽ� ��ȯ
        if (msg.length() == 1) {

            int i = index.indexOf(msg);

            return new int[] {i+1};
        }

        //����� ���� ����Ʈ. ����� �����̱� ������ ����Ʈ�� ����
        ArrayList<Integer> ans = new ArrayList<>();

        int idx = 1;//�б⹮���� �˻縦 ������ ��ġ

        String w = ""+msg.charAt(0);

        while(idx <= msg.length()) {

            if (idx == msg.length()) {//���̻� ã�� �ܾ ���� ��,

                ans.add(index.indexOf(w)+1);//���� w�� �ε����� ��� ����Ʈ�� �߰��ϰ� �б⹮ ����
                break;
            }

            char c = msg.charAt(idx);//c���� ���� �˻縦�� ��ġ�� �ش��ϴ� �ܾ �־��ش�.

            String wc = w+c;

            if (index.contains(wc)) {//wc�� �ε����� �����ϰ� �ִٸ�,

                w = wc;//���� wc�� ���� c�� ��������ϱ� ������ w�� �־��ش�.
                idx++;//���� �ܾ� ��ġ�� �����ְ�, ���� �б⹮���� ����.
                continue;
            }

            index.add(wc);//wc�� �����ϰ� ���� �ʱ� ������ ���Ӱ� �ε����� �߰����ش�.
            ans.add(index.indexOf(w)+1);//��� ����Ʈ�� ���Ӱ� �߰����� �ε��� ��ȣ�� �߰��Ѵ�.

            w = ""+c;//�ε����� �߰������Ƿ�, w�� ���� c�� �ٽ� �����Ѵ�.
            idx++;//���� ��ġ�� �����ϰ�, ���� �б⹮���� ����.

        }

        //��� ����Ʈ�� ���˿� �°� ��� �迭�� ����� ��ȯ
        int[] answer = new int[ans.size()];

        for (int i = 0; i < answer.length; i++) answer[i] = ans.get(i);

        return answer;
    }
}
