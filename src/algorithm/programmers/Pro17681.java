package algorithm.programmers;


/*
 * 2018 KAKAO BLIND RECRUITMENT
 * [1차] 캐시
 * */
public class Pro17681 {

    public static String binary(String str, int n) {

        while (str.length() < n) {//이진수가 n보다 작으면 n만큼 자릿수를 만들어준다.
            str = "0" + str;
        }
        return str;
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i =0; i<n; i++) {


            answer[i] = binary(Integer.toBinaryString(arr1[i] | arr2[i]),n)//arr1과 arr2를 or연산한 이진수로 만든다.
                    .replace("1","#")//1은 #으로
                    .replace("0"," ");//0은 공백으로 표시

        }
        return answer;
    }
}
