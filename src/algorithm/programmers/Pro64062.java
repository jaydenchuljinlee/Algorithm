package algorithm.programmers;

/*
* 2019 카카오 개발자 겨울 인턴십
* 징검다리 건너기
* */
public class Pro64062 {

    public int solution(int[] stones, int k) {

        int min = Integer.MAX_VALUE;//구간의 max 값 중에 최솟값

        for (int i = 0; i <= stones.length-k;) {//징검다리 갯수-k만큼 분기문을 돌려준다.
            //System.out.println(i);

            int max = stones[i];//구간의 처음 요소를 max 변수에 추가

            int idx = 0;//다음 i의 위치를 지정할 인덱스 변수

            for (int j = i+1; j < i+k; j++) {//k만큼의 구간 탐색

                if (stones[j] >= max) {//현재 구간의 징검다리가 구간의 최댓값보다 크거나 같을 때

                    idx = j;//인덱스를 현재 징검다리 번호로 변경
                    max = stones[j];//구간의 최댓값을 현재 징검다리로 변경
                }
            }

            if (idx == 0) i++;//구간의 최댓값이 변경되지 않았을 때는 한칸만 이동
            else {//구간의 최댓값이 변경되었을 때는 최댓값에 해당하는 징검다리 번호+1로 이동
                i = (idx+1);
            }

            min = Math.min(min,max);//구간의 최댓값이 다른 구간과 비교했을 때, 더 작은 구간의 최댓값을 결값에 설정
        }

        return min;
    }
}
