package algorithm.programmers;

import java.util.*;

/*
 * 2018 카카오 블라인드
 * [3차] 압축
 * */
public class Pro17684 {

    public int[] solution(String msg) {

        //인덱스 초기 셋팅
        ArrayList<String> index = new ArrayList<>(Arrays.asList(new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V"
                ,"W","X","Y","Z"}));

        //길이가 하나라면, 인덱스에서 해당 위치를 찾아서 반환
        if (msg.length() == 1) {

            int i = index.indexOf(msg);

            return new int[] {i+1};
        }

        //결과를 담을 리스트. 사이즈가 가변이기 때문에 리스트로 선언
        ArrayList<Integer> ans = new ArrayList<>();

        int idx = 1;//분기문마다 검사를 진행할 위치

        String w = ""+msg.charAt(0);

        while(idx <= msg.length()) {

            if (idx == msg.length()) {//더이상 찾을 단어가 없을 때,

                ans.add(index.indexOf(w)+1);//현재 w의 인덱스를 결과 리스트에 추가하고 분기문 종료
                break;
            }

            char c = msg.charAt(idx);//c에는 현재 검사를할 위치에 해당하는 단어를 넣어준다.

            String wc = w+c;

            if (index.contains(wc)) {//wc가 인덱스에 포함하고 있다면,

                w = wc;//현재 wc와 다음 c를 합쳐줘야하기 때문에 w에 넣어준다.
                idx++;//다음 단어 위치를 정해주고, 다음 분기문으로 간다.
                continue;
            }

            index.add(wc);//wc를 포함하고 있지 않기 때문에 새롭게 인덱스에 추가해준다.
            ans.add(index.indexOf(w)+1);//결과 리스트에 새롭게 추가해준 인덱스 번호를 추가한다.

            w = ""+c;//인덱스를 추가했으므로, w는 현재 c로 다시 셋팅한다.
            idx++;//다음 위치로 선정하고, 다음 분기문으로 간다.

        }

        //결과 리스트를 포맷에 맞게 결과 배열로 만들고 반환
        int[] answer = new int[ans.size()];

        for (int i = 0; i < answer.length; i++) answer[i] = ans.get(i);

        return answer;
    }
}
