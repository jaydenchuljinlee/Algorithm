package algorithm.grid;

import java.util.*;

/*
* 백준 9576
* 책 나눠주기
* */
public class Boj9576 {
    // 책 정보 클래스
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

            //이미 나눠준 책인지 확인
            boolean[] v = new boolean[n+1];

            //책 정보 리스트
            ArrayList<Student> list = new ArrayList<>();

            //책 정보를 리스트에 담는다.
            for (int i = 0; i < m; i++) {

                int a = sc.nextInt();
                int b = sc.nextInt();

                list.add(new Student(a,b));
            }

            //책 정보를 b를 기준으로 오름차순 정렬
            Collections.sort(list, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {

                    return o1.b-o2.b;
                }
            });

            int answer = 0;

            for (Student s : list) {

                //정렬된 책 정보의 a부터 b까지 순차적으로 접근
                for (int i = s.a; i <= s.b; i++) {

                    //a~b 중 등록된 책이 아니면
                    if (!v[i]) {

                        v[i] = true;//책을 나눠줬다는 표시
                        answer++;//최대 수량을 늘려준다.
                        break;
                    }
                }
            }

            System.out.println(answer);

        }
    }
}
