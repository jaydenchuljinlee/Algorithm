package algorithm.kakaoEnterprise2020Summer;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;


// �� ��° ���� : ���� ����� ���� ������ ��� (����)
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

        int N = inputToInt*(inputToInt-1);//��ü ��Ʈ ��

        HashMap<String, Game> map = new HashMap<>();//������ �̸��� ���� ������ ��� map

        //��Ʈ ����ŭ �ݺ�
        while(N-- > 0) {

            String[] str = br.readLine().split(" ");

            String a = str[0];
            int aSet = Integer.parseInt(str[1]);
            String b = str[2];
            int bSet = Integer.parseInt(str[3]);

            //a�� b�� ���� map�� ��ϵǾ� �ִ� ������ �����´�.
            //���ٸ� �⺻���� ������ش�.
            Game aGame =  map.getOrDefault(a,new Game(a,0,0));
            Game bGame =  map.getOrDefault(b,new Game(b,0,0));

            //a�� b�� �¼��� üũ�ϰ� �����ش�.
            if (aSet < bSet) bGame.winCnt++;
            else aGame.winCnt++;

            //a�� b�� ��Ʈ ����� �����ش�.
            bGame.profit += (bSet - aSet);
            aGame.profit += (aSet - bSet);

            //a�� b�� map�� �ٽ� ����ش�.
            map.put(a,aGame);
            map.put(b,bGame);

        }

        //������ �¼�-��Ʈ ���-���������� ����
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

        //map�� key�� �����ͼ� �켱����ť�� ��´�.
        for (String name : map.keySet()) pq.add(map.get(name));

        //�켱����ť�� ����ִ� ������ ���� ����� �����Ѵ�.
        while(!pq.isEmpty()) {

            Game g = pq.poll();

            System.out.println(g.name + " " + g.winCnt + " " + g.profit);

        }
    }
}
