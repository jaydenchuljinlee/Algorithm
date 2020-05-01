package algorithm.programmers;

import java.util.*;

public class Pro64065 {

    public static int[] solution(String s) {

        List<String> answerList = new ArrayList<>();//결과를 담을 리스트

        //우선순위 큐에 튜플의 길이 순으로 저장
        PriorityQueue<List<String>> pq = new PriorityQueue(new Comparator<List<String>> () {

            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.size() - o2.size();
            }
        });

        String[] str = s.substring(2,s.length()-2).split("\\},\\{");//튜플을 ,를 기준으로 나눠서 배열에 저장

        for (String item : str) {

            //System.out.println(item);
            String[] tuple = item.split(",");//나눠진 튜플 문자열을 다시 ,를 기준으로 나눠서 튜플에 저장

            pq.add(Arrays.asList(tuple));//튜플을 리스트로 변환해서 우선순위 큐에 담는다
        }

        List<String> cur = pq.poll();//처음 길이가 가장 작은 튜플부터 꺼내와서 리스트에 담아준다.

        for (String item : cur) answerList.add(item);//꺼내온 튜플의 순서대로 결과 리스트에 담아준다.

        while(!pq.isEmpty()) {//튜플 정보 탐색

            cur = pq.poll();//튜플 리스트

            for (String item : cur) {//현재 튜플의 요소들

                if (answerList.contains(item)) continue;//튜플의 요소가 결과리스트에 포함되어 있다면, 넘어간다.


                answerList.add(item);//현재 튜블 리스트에 남아있는 값을 모두 결과 리스트에 추가

            }
        }

        //System.out.println(answerList);

        int[] answer = new int[answerList.size()];//튜플의 결과리스트를 배열로 만들어주기 위함.

        for (int i = 0 ; i < answer.length; i++) answer[i] = Integer.parseInt(answerList.get(i));

        return answer;
    }
}
