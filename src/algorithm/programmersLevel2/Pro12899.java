package algorithm.programmersLevel2;

/*
* ���α׷��ӽ�
* 124 ������ ����
* */
public class Pro12899 {

    public String solution(int n) {

        String answer = "";

        while(n>0) {

            //n�� 3���� ���� �������� �ε����� 4,1,2 �� �ش��ϴ� ���� ����� �տ� �߰�
            answer += "412".charAt(n%3) + answer;

            n = (n-1)/3;//n�� �ܼ��� 3���� �������� 1,2,3�� ���� 3������ �ȴ�. ���� (n-1)�� �������Ѵ�.
        }

        return answer;
    }
}
