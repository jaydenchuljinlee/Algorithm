package algorithm.programmers;


/*
 * 2018 KAKAO BLIND RECRUITMENT
 * [1��] ĳ��
 * */
public class Pro17681 {

    public static String binary(String str, int n) {

        while (str.length() < n) {//�������� n���� ������ n��ŭ �ڸ����� ������ش�.
            str = "0" + str;
        }
        return str;
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i =0; i<n; i++) {


            answer[i] = binary(Integer.toBinaryString(arr1[i] | arr2[i]),n)//arr1�� arr2�� or������ �������� �����.
                    .replace("1","#")//1�� #����
                    .replace("0"," ");//0�� �������� ǥ��

        }
        return answer;
    }
}
