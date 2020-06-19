package algorithm.codility.level5;

public class GenomicRangeQuery {

    public static int[] solution(String S, int[] P, int[] Q) {

        int[] answer = new int[P.length];

        int[] A = new int[S.length()];
        int[] C = new int[S.length()];
        int[] G = new int[S.length()];

        {
            char c = S.charAt(0);

            switch (c) {

                case 'A' :
                    A[0]++;
                    break;

                case 'C' :
                    C[0]++;
                    break;

                case 'G' :
                    G[0]++;
                    break;
            }
        }


        for (int i = 1; i < S.length(); i++) {

            char c = S.charAt(i);

            switch (c) {

                case 'A' :
                    A[i]++;
                    break;

                case 'C' :
                    C[i]++;
                    break;

                case 'G' :
                    G[i]++;
                    break;
            }

            A[i] += A[i-1];
            C[i] += C[i-1];
            G[i] += G[i-1];
        }

        for (int i = 0; i < P.length; i++) {

            if (P[i] > 0) {

                if (A[Q[i]] > A[P[i]-1]) answer[i] = 1;
                else if (C[Q[i]] > C[P[i]-1]) answer[i] = 2;
                else if (G[Q[i]] > G[P[i]-1]) answer[i] = 3;
                else answer[i] = 4;

            } else {

                if (A[Q[i]] > 0) answer[i] = 1;
                else if (C[Q[i]] >0) answer[i] = 2;
                else if (G[Q[i]] > 0) answer[i] = 3;
                else answer[i] = 4;
            }
        }

        return answer;
    }
}
