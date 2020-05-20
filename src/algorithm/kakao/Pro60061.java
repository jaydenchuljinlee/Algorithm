package algorithm.kakao;

import java.util.*;

/*
 * 2020 카카오 블라인드 코딩테스트
 * 기둥과 보 설치
 * */
public class Pro60061 {

    private static ArrayList<Frame> list;//프레임 정보를 저장할 리스트
    private static int len;

    private static final int pillar 	= 0;//기둥
    private static final int board		= 1;//보
    private static final int build		= 1;//설치
    private static final int remove		= 0;//제거

    //설치할 프레임 정보 클래스
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
        public boolean equals(Object obj) {//객체 확인을 위해

            if (obj == null) return false;

            if (getClass() != obj.getClass()) return false;

            Frame other = (Frame) obj;

            //셋 중에 하나라도 같지 않으면 같은 객체가 아니다
            if (x != other.x || y != other.y || type != other.type) return false;

            return true;
        }
    }

    public static int[][] solution(int n, int[][] build_frame) {
        list = new ArrayList<>();

        //프레임 구조 배열을 통해 설치할지 제거할지 결정
        for (int[] build_arr: build_frame) {

            Frame frame = new Frame(build_arr[0],build_arr[1],build_arr[2]);

            int build_state	= build_arr[3];

            if (build_state == build) {//설치한다면

                list.add(frame);//리스트에 추가해보고

                if (check(list)) continue;//요구 사항에 충족하면 다음 프레임으로

                list.remove(list.size()-1);//요구 사항을 충족하지 못하면 추가했던 프레임 제거

            } else {//제거한다면

                list.remove(frame);//프레임을 리스트에서 제거해보고

                if (check(list)) continue;//요구 사항을 축종한다면 다음 프레임으로

                list.add(frame);//요구 사항을 충족하지 못한다면 제거했던 프레임 다시 추가

            }

        }

        //최종 구조물 형태를 x-y-기둥-보 순서로 오름차순해준다.
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

    //요구 사항을 충족하는지 확인
    static boolean check(ArrayList<Frame> list) {

        for (Frame frame : list) {//설치된 전체 프레임 구조

            switch (frame.type) {//프렘의 타입
                case pillar ://기둥일 때

                    //요구 사항에 따라 기둥이 땅 위에 있거나
                    //보의 한 쪽 끝 부분에 있거나
                    //또 다른 기둥에 있는 경우
                    if (frame.y == 0 || list.contains(new Frame(frame.x-1,frame.y,1))
                            || list.contains(new Frame(frame.x,frame.y,1))
                            || list.contains(new Frame(frame.x,frame.y-1,0))) continue;
                    else return false;

                case board ://보일 때

                    //한쪽 끝 부분이 기둥 위에 있거나
                    //양쪽 끝 부분이 다른 보와 동시에 연결 되있는 경우
                    if (list.contains(new Frame(frame.x,frame.y-1,0))
                            || list.contains(new Frame(frame.x+1,frame.y-1,0))
                            || (list.contains(new Frame(frame.x-1,frame.y,1)) && list.contains(new Frame(frame.x+1,frame.y,1)))) continue;
                    else return false;

            }
        }

        return true;
    }
}
