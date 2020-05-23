package algorithm.summercoding;

import java.util.ArrayList;

public class Summer20202 {

    private static int[] index = new int[10001];

    //스킬 정보
    private static class Skill{
        int idx;//스킬 번호
        int w;//스킬 포인트
        int cnt;//스킬 보유 갯수
        ArrayList<Skill> list;//하위 스킬

        public Skill(int idx) {
            this.idx = idx;
            list = new ArrayList<>();
        }

        //하위 스킬 찾기
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

        //전체 갯수 구하기
        public int totalCnt() {

            if (list.size() == 0) return 1;

            int total = 0;

            for (int i = 0; i < list.size(); i++) {

                total += list.get(i).totalCnt();
            }

            return total;
        }

        //점수 부여
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

            //null일 때는 루트 설정
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
