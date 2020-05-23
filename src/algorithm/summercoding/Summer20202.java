package algorithm.summercoding;

import java.util.ArrayList;

public class Summer20202 {

    private static int[] index = new int[10001];

    //��ų ����
    private static class Skill{
        int idx;//��ų ��ȣ
        int w;//��ų ����Ʈ
        int cnt;//��ų ���� ����
        ArrayList<Skill> list;//���� ��ų

        public Skill(int idx) {
            this.idx = idx;
            list = new ArrayList<>();
        }

        //���� ��ų ã��
        public boolean find(int[] s) {

            if (idx == s[0]) {
                list.add(new Skill(s[1]));
                return true;
            }

            for (int i = 0; i < list.size(); i++) {

                boolean flag = list.get(i).find(s);

                if (flag) return true;
            }

            return false;
        }

        //��ü ���� ���ϱ�
        public int totalCnt() {

            if (list.size() == 0) return 1;

            int total = 0;

            for (int i = 0; i < list.size(); i++) {

                total += list.get(i).totalCnt();
            }

            return total;
        }

        //���� �ο�
        public int makePoint(int point) {

            if (list.size() == 0) return point;

            int total = 0;

            for (int i = 0; i < list.size(); i++) {

                total += list.get(i).makePoint(point);
            }

            return total;
        }
    }

    //int[][] skills = {{1,2},{1,3},{3,6},{3,4},{3,5}};
    public static int[] solution(int[][] skills) {

        Skill root = null;

        for (int[] s : skills) {

            //null�� ���� ��Ʈ ����
            if (root == null) {
                root = new Skill(s[0]);
                root.list.add(new Skill(s[1]));
            } else {

                root.find(s);
            }
        }

        int total = root.totalCnt();

        int[] answer = {};

        return answer;

    }
}
