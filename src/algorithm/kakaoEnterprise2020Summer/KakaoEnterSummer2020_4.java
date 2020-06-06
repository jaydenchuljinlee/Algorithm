package algorithm.kakaoEnterprise2020Summer;

import java.io.*;
import java.util.HashMap;

//�� ��° ���� : �ּ� �Ʒ� ��� �˻� (Ž��)
public class KakaoEnterSummer2020_4 {
    private static HashMap<String, HashMap<String,Integer>> map;
    private static int min;

    public static void solution() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new HashMap<>();

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        //m��ŭ �ݺ�
        while(M-- > 0) {

            String[] str2 = br.readLine().split(" ");

            //M�� ° �ٿ��� �Է¹��� Ÿ���� ����
            HashMap<String,Integer> sub = map.getOrDefault(str2[0],new HashMap<>());

            //Ÿ�� ������ �߰�
            sub.put(str2[1],Integer.parseInt(str2[2]));

            //map�� �ش� ������ Ÿ�� ������ ��´�.
            map.put(str2[0],sub);
        }

        int Q = Integer.parseInt(br.readLine());

        //���� ����ŭ �ݺ�
        while(Q-- > 0) {

            //�ּڰ� �ʱ�ȭ
            min = Integer.MAX_VALUE;

            String[] query = br.readLine().split(" ");

            //������ ó���� ���� ���� ���� 0�� ����
            if (query[0].equals(query[1])) {
                System.out.println(0);
                continue;
            }

            //������ ó���� ���� map�� ����ִٸ� Ÿ�� ������ ã�´�.
            if (map.get(query[0]) != null) {

                min = find(map.get(query[0]),query[1],0);
            }

            //�ּڰ��� ������ �ʾҴٸ� -1��
            if (min == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {//���ߴٸ� �ּڰ��� ���
                System.out.println(min);
            }

        }
    }

    //Ÿ�� ������ ã�� �޼���
    private static int find(HashMap<String,Integer> query,String next, int sum) {

        //Ÿ�� ������ ã�Ҵٸ�
        if (query.get(next) != null) {

            //�ּڰ��� ����
            min = Math.min(sum+query.get(next),min);

        } else {

            //���� ������ Ÿ�� ������ ����
            for (String key : query.keySet()) {

                //���� map���� ������ Ÿ�� ������ �����Ѵٸ�
                if (map.get(key) != null) {

                    //sum�� ���� Ÿ�� ������ �Ʒ� ����� �߰��ϰ� Ž��
                    min = find(map.get(key),next,sum+query.get(key));
                }
            }
        }

        return min;
    }
}
