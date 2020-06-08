package algorithm.grid;

import java.io.*;
import java.util.*;

/*
* ���� 8980
* �ù�
* */
public class Boj8980 {

    private static class Box {
        int start;
        int end;
        int weight;

        public Box(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void solution() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        //�ڽ��� ������������ ����
        PriorityQueue<Box> pq = new PriorityQueue<>(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {

                if (o1.end < o2.end) return -1;
                else if (o1.end < o2.end) return 0;
                else return 1;
            }
        });

        int[] town = new int[N+1];

        //������ ���� �Է�
        while(M-- > 0) {

            String[] str = br.readLine().split(" ");

            pq.add(new Box(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2])));
        }

        int answer = 0;

        //�޴� ������ �������� ���ĵ� �ڽ� ������
        while(!pq.isEmpty()) {

            Box b = pq.poll();

            int max = 0;

            //�ڽ��� �Ƿȴ��� Ȯ��
            boolean isLoaded = true;

            //���� �������� �� �������� �ڽ� ���Ը� �˻�
            for (int i = b.start; i < b.end; i++) {

                //�ش� �������� �ڽ��� ���԰� �ʰ��Ѵٸ� false�� ����
                if (town[i] >= C) {

                    isLoaded = false;
                    break;
                }
                //max�� ����
                max = Math.max(max,town[i]);
            }

            //�ڽ��� ���� �� �ִٸ�
            if (isLoaded) {

                //���� ���Կ��� max�� ����(���İ��� ������ �ڽ��� ���� �� �ִ����� �˻��ϱ� ����)
                int unLoaded = C - max;

                //���� ���� ���� �ڽ� ���Ժ��� ũ�� �ش� �ڽ��� ������ ��´�.
                if (unLoaded > b.weight) unLoaded = b.weight;

                //��� ���� �߰�
                answer += unLoaded;

                //���� �ε�� �ڽ� ���Ը� ���İ��� �����鿡 �߰�
                for (int i = b.start; i < b.end; i++) {
                    town[i] += unLoaded;
                }
            }
        }

        System.out.println(answer);
    }
}
