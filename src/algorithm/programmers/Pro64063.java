package algorithm.programmers;

import java.util.*;

/*
 * 2019 īī�� ������ �ܿ� ���Ͻ�
 * ȣ�� �� ����
 * */
public class Pro64063 {

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        HashMap<Long,Long> room = new HashMap<>();//key   : ���� ��ϵ� �� ��ȣ
                                                  //value : ���� �� ��ȣ�� Ȯ���ϱ� ���� �� ��ȣ

        int idx = 0;//��� �迭�� ������ �ε���

        for (long wanted : room_number) {

            if (!room.containsKey(wanted)) {//�� ��ȣ�� ��ϵǾ� �������� ��,

                room.put(wanted,wanted+1);
                answer[idx++] = wanted;
            } else {//���ȣ�� ��ϵǾ� ������

                Queue<Long> q = new LinkedList<>();//��ϵ� �� ��ȣ���� Ȯ���ϱ� ���� ���� �� ��ȣ�� ���� �ٲ��ֱ� ����

                long next = room.get(wanted);//���� ��ϵ� �� ��ȣ�� ���� �� ��ȣ�� �����´�.

                q.add(next);

                while(room.containsKey(next)) {//���� �� ��ȣ�� ��� �Ǿ��ִ����� �˻�

                    next = room.get(next);//���� �� ��ȣ�� next ������ q�� ����ش�.
                    q.add(next);

                }

                answer[idx++] = next;//��� �Ǿ����� ���� �� ��ȣ�� ��� �迭�� ��´�.

                while(!q.isEmpty()) room.put(q.poll(),next+1);//���� ��ϵ��� ���� �� ��ȣ�� �����ϰ� �ִ� key���� ���� ��ȣ�� ���� �ٲ��ش�.

            }
        }

        //for (int i = 0; i < room_number.length; i++) System.out.println(answer[i]);

        return answer;
    }
}
