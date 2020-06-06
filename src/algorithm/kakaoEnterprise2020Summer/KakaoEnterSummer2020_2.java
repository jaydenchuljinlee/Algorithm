package algorithm.kakaoEnterprise2020Summer;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;


// 두 번째 문제 : 리그 경기의 승자 순으로 출력 (정렬)
public class KakaoEnterSummer2020_2 {
    private static class Game {
        String name;
        int winCnt;
        int profit;

        public Game(String name, int winCnt, int profit) {
            this.name = name;
            this.winCnt = winCnt;
            this.profit = profit;

        }
    }

    public static void solution() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int inputToInt = Integer.parseInt(input);

        int N = inputToInt*(inputToInt-1);//전체 세트 수

        HashMap<String, Game> map = new HashMap<>();//게임의 이름을 통해 정보를 담는 map

        //세트 수만큼 반복
        while(N-- > 0) {

            String[] str = br.readLine().split(" ");

            String a = str[0];
            int aSet = Integer.parseInt(str[1]);
            String b = str[2];
            int bSet = Integer.parseInt(str[3]);

            //a와 b에 대해 map에 등록되어 있는 정보를 가져온다.
            //없다면 기본값을 만들어준다.
            Game aGame =  map.getOrDefault(a,new Game(a,0,0));
            Game bGame =  map.getOrDefault(b,new Game(b,0,0));

            //a와 b의 승수를 체크하고 더해준다.
            if (aSet < bSet) bGame.winCnt++;
            else aGame.winCnt++;

            //a와 b의 세트 득실을 더해준다.
            bGame.profit += (bSet - aSet);
            aGame.profit += (aSet - bSet);

            //a와 b를 map에 다시 담아준다.
            map.put(a,aGame);
            map.put(b,bGame);

        }

        //게임을 승수-세트 득실-사전순으로 정렬
        PriorityQueue<Game> pq = new PriorityQueue<>(new Comparator<Game>() {

            @Override
            public int compare(Game o1, Game o2) {

                if (o1.winCnt > o2.winCnt) return -1;
                else if (o1.winCnt < o2.winCnt) return 1;
                else {

                    if (o1.profit > o2.profit) return -1;
                    else if (o1.profit < o2.profit) return 1;
                    else {

                        if (o1.name.compareTo(o2.name) < 0) return -1;
                        else return 1;
                    }
                }
            }
        });

        //map의 key를 가져와서 우선순위큐에 담는다.
        for (String name : map.keySet()) pq.add(map.get(name));

        //우선순위큐에 담겨있는 게임을 꺼내 결과를 도출한다.
        while(!pq.isEmpty()) {

            Game g = pq.poll();

            System.out.println(g.name + " " + g.winCnt + " " + g.profit);

        }
    }
}
