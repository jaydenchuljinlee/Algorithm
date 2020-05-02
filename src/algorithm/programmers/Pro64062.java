package algorithm.programmers;

/*
* 2019 īī�� ������ �ܿ� ���Ͻ�
* ¡�˴ٸ� �ǳʱ�
* */
public class Pro64062 {

    public int solution(int[] stones, int k) {

        int min = Integer.MAX_VALUE;//������ max �� �߿� �ּڰ�

        for (int i = 0; i <= stones.length-k;) {//¡�˴ٸ� ����-k��ŭ �б⹮�� �����ش�.
            //System.out.println(i);

            int max = stones[i];//������ ó�� ��Ҹ� max ������ �߰�

            int idx = 0;//���� i�� ��ġ�� ������ �ε��� ����

            for (int j = i+1; j < i+k; j++) {//k��ŭ�� ���� Ž��

                if (stones[j] >= max) {//���� ������ ¡�˴ٸ��� ������ �ִ񰪺��� ũ�ų� ���� ��

                    idx = j;//�ε����� ���� ¡�˴ٸ� ��ȣ�� ����
                    max = stones[j];//������ �ִ��� ���� ¡�˴ٸ��� ����
                }
            }

            if (idx == 0) i++;//������ �ִ��� ������� �ʾ��� ���� ��ĭ�� �̵�
            else {//������ �ִ��� ����Ǿ��� ���� �ִ񰪿� �ش��ϴ� ¡�˴ٸ� ��ȣ+1�� �̵�
                i = (idx+1);
            }

            min = Math.min(min,max);//������ �ִ��� �ٸ� ������ ������ ��, �� ���� ������ �ִ��� �ᰪ�� ����
        }

        return min;
    }
}
