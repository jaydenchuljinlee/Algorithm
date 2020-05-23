package algorithm.summercoding;

public class Summer20203 {

    public static int solution(int p) {

        int answer = 0;

        outter : while(true) {

            p++;

            String check = "" + p;

            for (int i = 0; i < check.length(); i++) {

                char ch = check.charAt(i);

                String sub = check.substring(0,i) + check.substring(i+1);

                if (sub.contains(""+ch)) continue outter;
            }

            answer = Integer.parseInt(check);
            break;
        }

        return answer;
    }
}
