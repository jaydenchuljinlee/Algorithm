package algorithm.grid;

import java.util.*;

/*
* ���� 9576
* å �����ֱ�
* */
public class Boj9576 {
    // å ���� Ŭ����
    private static class Student {
        int a;
        int b;

        public Student(int a, int b) {
            this.a = a;
            this.b = b;

        }

    }

    public static void solution() {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while(tc-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            //�̹� ������ å���� Ȯ��
            boolean[] v = new boolean[n+1];

            //å ���� ����Ʈ
            ArrayList<Student> list = new ArrayList<>();

            //å ������ ����Ʈ�� ��´�.
            for (int i = 0; i < m; i++) {

                int a = sc.nextInt();
                int b = sc.nextInt();

                list.add(new Student(a,b));
            }

            //å ������ b�� �������� �������� ����
            Collections.sort(list, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {

                    return o1.b-o2.b;
                }
            });

            int answer = 0;

            for (Student s : list) {

                //���ĵ� å ������ a���� b���� ���������� ����
                for (int i = s.a; i <= s.b; i++) {

                    //a~b �� ��ϵ� å�� �ƴϸ�
                    if (!v[i]) {

                        v[i] = true;//å�� ������ٴ� ǥ��
                        answer++;//�ִ� ������ �÷��ش�.
                        break;
                    }
                }
            }

            System.out.println(answer);

        }
    }
}
