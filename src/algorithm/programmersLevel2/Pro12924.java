package algorithm.programmersLevel2;

/*
* ���α׷��ӽ�
* ������ ǥ��
* */
public class Pro12924 {

    public int solution(int n) {

        int range = (n/2)+1;

        int answer = 1;

        for (int i = 1; i < range; i++) {

            int sum = i;

            for (int j = i+1; j <= range && sum < n; j++) {

                sum += j;

                if (sum == n) answer++;
            }
        }

        return answer;
    }
}
