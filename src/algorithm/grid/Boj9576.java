package algorithm.grid;

import java.util.*;

/*
* 백준 9576
* 책 나눠주기
* */
public class Boj9576 {
    private static class Student {
        int a;
        int b;
        int diff;

        public Student(int a, int b, int diff) {
            this.a = a;
            this.b = b;
            this.diff = diff;

        }

    }

    public static void solution() {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while(tc > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            boolean[] v = new boolean[n+1];

            ArrayList<Student> list = new ArrayList<>();

            for (int i = 0; i < m; i++) {

                int a = sc.nextInt();
                int b = sc.nextInt();
                int diff = b-a;

                list.add(new Student(a,b,diff));
            }

            Collections.sort(list, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {

                    return o1.diff-o2.diff;
                }
            });

            int answer = 0;

            for (Student s : list) {

                for (int i = s.a; i <= s.b; i++) {

                    if (!v[i]) {

                        v[i] = true;
                        answer++;
                        break;
                    }
                }
            }

            System.out.println(answer);

            tc--;
        }
    }
}
