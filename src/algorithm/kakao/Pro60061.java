package algorithm.kakao;

import java.util.*;

/*
 * 2020 īī�� ����ε� �ڵ��׽�Ʈ
 * ��հ� �� ��ġ
 * */
public class Pro60061 {

    private static ArrayList<Frame> list;//������ ������ ������ ����Ʈ
    private static int len;

    private static final int pillar 	= 0;//���
    private static final int board		= 1;//��
    private static final int build		= 1;//��ġ
    private static final int remove		= 0;//����

    //��ġ�� ������ ���� Ŭ����
    private static class Frame {
        int x;
        int y;
        int type;

        public Frame(int x, int y, int type) {
            this.x 		= x;
            this.y	 	= y;
            this.type	= type;
        }

        @Override
        public boolean equals(Object obj) {//��ü Ȯ���� ����

            if (obj == null) return false;

            if (getClass() != obj.getClass()) return false;

            Frame other = (Frame) obj;

            //�� �߿� �ϳ��� ���� ������ ���� ��ü�� �ƴϴ�
            if (x != other.x || y != other.y || type != other.type) return false;

            return true;
        }
    }

    public static int[][] solution(int n, int[][] build_frame) {
        list = new ArrayList<>();

        //������ ���� �迭�� ���� ��ġ���� �������� ����
        for (int[] build_arr: build_frame) {

            Frame frame = new Frame(build_arr[0],build_arr[1],build_arr[2]);

            int build_state	= build_arr[3];

            if (build_state == build) {//��ġ�Ѵٸ�

                list.add(frame);//����Ʈ�� �߰��غ���

                if (check(list)) continue;//�䱸 ���׿� �����ϸ� ���� ����������

                list.remove(list.size()-1);//�䱸 ������ �������� ���ϸ� �߰��ߴ� ������ ����

            } else {//�����Ѵٸ�

                list.remove(frame);//�������� ����Ʈ���� �����غ���

                if (check(list)) continue;//�䱸 ������ �����Ѵٸ� ���� ����������

                list.add(frame);//�䱸 ������ �������� ���Ѵٸ� �����ߴ� ������ �ٽ� �߰�

            }

        }

        //���� ������ ���¸� x-y-���-�� ������ �����������ش�.
        Collections.sort(list,new Comparator<Frame>() {

            @Override
            public int compare(Frame o1, Frame o2) {

                if (o1.x < o2.x) return -1;
                else if (o1.x == o2.x) {

                    if (o1.y < o2.y) return -1;
                    else if (o1.y == o2.y) {

                        if (o1.type < o2.type) return -1;
                        else return 1;
                    }
                }

                return 1;
            }

        });

        int[][] answer = new int[list.size()][3];

        for (int i = 0; i < list.size(); i++) {

            Frame f = list.get(i);

            answer[i][0] = f.x;
            answer[i][1] = f.y;
            answer[i][2] = f.type;
            //System.out.println(answer[i][0] + "," + answer[i][1] + ":" + answer[i][2]);
        }
        return answer;
    }

    //�䱸 ������ �����ϴ��� Ȯ��
    static boolean check(ArrayList<Frame> list) {

        for (Frame frame : list) {//��ġ�� ��ü ������ ����

            switch (frame.type) {//������ Ÿ��
                case pillar ://����� ��

                    //�䱸 ���׿� ���� ����� �� ���� �ְų�
                    //���� �� �� �� �κп� �ְų�
                    //�� �ٸ� ��տ� �ִ� ���
                    if (frame.y == 0 || list.contains(new Frame(frame.x-1,frame.y,1))
                            || list.contains(new Frame(frame.x,frame.y,1))
                            || list.contains(new Frame(frame.x,frame.y-1,0))) continue;
                    else return false;

                case board ://���� ��

                    //���� �� �κ��� ��� ���� �ְų�
                    //���� �� �κ��� �ٸ� ���� ���ÿ� ���� ���ִ� ���
                    if (list.contains(new Frame(frame.x,frame.y-1,0))
                            || list.contains(new Frame(frame.x+1,frame.y-1,0))
                            || (list.contains(new Frame(frame.x-1,frame.y,1)) && list.contains(new Frame(frame.x+1,frame.y,1)))) continue;
                    else return false;

            }
        }

        return true;
    }
}
