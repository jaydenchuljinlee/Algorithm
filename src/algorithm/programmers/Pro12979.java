package algorithm.programmers;

/*
 * 2018 summer/winter conding
 * ������ ��ġ
 * */
public class Pro12979 {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int location = 1;//�������� ��ġ�� ���� ��ġ
        int idx = 0;//��ġ�� ������ �ε���

        while(location <= n) {//��ġ�� ��ü �������� �۰ų� ���� ������

            //��ġ�� ������ ���� �ȿ� �����鼭, ���� ��ġ�� ��ġ�� �������� �������� Ŭ ��,
            if (idx < stations.length && location >= stations[idx]-w) {

                location = stations[idx]+w+1;//��ġ�� �������� �������� +1 ū ��ġ�� �̵�
                idx++;//���� �ε����� �̵�
            } else {//��ġ�� ������ ���� ���� ��,

                location += 2*w+1;//�������� ������ ���� �ִ� +1�� ���ش�.
                answer++;//�������� ��ġ�����Ƿ�, ������� �߰�
            }
        }

        return answer;
    }
}
