package algorithm.programmers;

import java.util.*;

/*
 * 2019 īī�� ����ε�
 * �ĺ�Ű
 * */
public class Pro42890 {
    public int solution(String[][] relation) {
        int answer = 0;
        int m = relation.length;
        int n = relation[0].length;

        ArrayList<Integer> ans = new ArrayList<>();

        //�÷����� ���� �� �ִ� ������ ��Ʈ����ŷ���� ǥ��
        for (int i = 1; i<=(1<<n)-1;i++) {

            Set<String> set = new HashSet<>();//�ߺ��� ���� �����ϱ� ���� set

            for (int j = 0; j < m; j++) {//�ο�

                StringBuilder sb = new StringBuilder();//������ ���� ���ڿ� ��ü

                for (int k = 0; k < n; k++) {//�÷�

                    if ((i&(1<<k)) > 0) {//&������ ���� i�� ���� �� �ִ� ���տ� �ش��ϴ� �÷��̸� �ش� �÷��� ���� �߰�
                        sb.append(relation[j][k]);//������ �߰�
                    }
                }

                set.add(sb.toString());//������ ������ set�� �߰�
            }

            //������� ������ ����� m�� ���ƾ� �ĺ�Ű ������ �����ϰ�,
            //check()�� ���� ������ ��ϵ� ���հ� �κ� ������ �̷�� ������ �ִ����� �˻�
            if (set.size() == m && check(ans,i)) {
                ans.add(i);
            }
        }

        answer = ans.size();
        return answer;
    }

    //��ϵ� ����(ans)�� �κ������� �ִ����� �˻�
    private boolean check(ArrayList<Integer> ans, int now) {

        for (int i = 0; i < ans.size(); i++) {

            if ((ans.get(i)&now) == ans.get(i)) return false;
        }

        return true;
    }

}
