package algorithm.programmersLevel2;

/*
* ���α׷��ӽ�
* ������ ���� �̵�
* */
public class Pro12980 {

    public int solution(int n) {

        int answer = 0;

        while(n != 0) {

            if (n%2 == 0) {

                n%=2;

            } else {

                n-=1;
                answer++;
            }
        }

        return answer;
    }
}
