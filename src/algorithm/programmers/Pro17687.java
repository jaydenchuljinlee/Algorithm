package algorithm.programmers;

/*
 * 2018 īī�� ����ε�
 * [3��] n���� ����
 * */
public class Pro17687 {

    public String solution(int n, int t, int m, int p) {
        //ǥ�� ������ ������ ����
        String[] number = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

        //
        String value = "0";

        int idx = 1;//���ڸ� n�������� ǥ���ϱ� ���� ����
        int count = 1;//n�������� ǥ���� ���ڼ����� �������� ����

        boolean flag = true;//n������ ǥ���ϱ� ���� flag����

        while(count < t*m) {//�� ���ڼ��� m���̼� ���� �� �ִ� �� �ϼ����� ���� ��
            flag = true;
            String temp = "";//������ ���� ����
            int num = idx;//���� n������ ǥ���ϱ� ���� ����

            //n������ ���ϴ� ����. �Ϲ������� ���ϴ� ����� �ݴ�� �����ϸ� �ȴ�.
            while(flag) {

                if (num / n == 0) flag = false;//���̻� ���� �� ���� ��

                temp = number[num%n] + temp;//�������� n���� �迭�� �´� ������ ������
                num/=n;//n�������� ���� ������ ���� ���
            }

            count += temp.length();//���� n���� ������ ���̸� ������
            value += temp;//n�������� ���� ���ڸ� ������
            idx++;//���� ����

        }

        String answer = "";

        for (int i = 0,j = 0; i < count&& j < t; i++) {//�� ���� �� ��° �������� ���ϱ� ����

            if (i%m == p-1) {//�ڱ� �������� Ȯ��
                answer += value.charAt(i);//n�������� ���� ���� ���ӿ��� i��° ��ġ�� ���� ��� ���� �߰�
                j++;//���� ��
            }
        }
        return answer;
    }
}
