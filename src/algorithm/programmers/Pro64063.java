package algorithm.programmers;

import java.util.*;

/*
 * 2019 카카오 개발자 겨울 인턴십
 * 호텔 방 배정
 * */
public class Pro64063 {

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        HashMap<Long,Long> room = new HashMap<>();//key   : 현재 등록된 룸 번호
                                                  //value : 다음 룸 번호를 확인하기 위한 룸 번호

        int idx = 0;//결과 배열에 저장할 인덱스

        for (long wanted : room_number) {

            if (!room.containsKey(wanted)) {//룸 번호가 등록되어 있지않을 때,

                room.put(wanted,wanted+1);
                answer[idx++] = wanted;
            } else {//룸번호가 등록되어 있을때

                Queue<Long> q = new LinkedList<>();//등록된 룸 번호들이 확인하기 위한 다음 룸 번호를 새로 바꿔주기 위함

                long next = room.get(wanted);//현재 등록된 룸 번호의 다음 룸 번호를 가져온다.

                q.add(next);

                while(room.containsKey(next)) {//다음 룸 번호가 등록 되어있는지를 검사

                    next = room.get(next);//다음 룸 번호를 next 변수와 q에 담아준다.
                    q.add(next);

                }

                answer[idx++] = next;//등록 되어있지 않은 룸 번호를 결과 배열에 담는다.

                while(!q.isEmpty()) room.put(q.poll(),next+1);//현재 등록되지 않은 룸 번호를 참조하고 있는 key들의 참조 번호를 새로 바꿔준다.

            }
        }

        //for (int i = 0; i < room_number.length; i++) System.out.println(answer[i]);

        return answer;
    }
}
