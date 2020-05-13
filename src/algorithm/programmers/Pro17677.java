package algorithm.programmers;

import java.util.*;


/*
 * 2018 KAKAO BLIND RECRUITMENT
 * [1차] 뉴스 클러스터링
 * */
public class Pro17677 {

    public int solution(String str1, String str2) {
        ArrayList<String> list1 = new ArrayList<>();//str1의 단어 조합을 만들 리스트
        ArrayList<String> list2 = new ArrayList<>();//str2의 단어 조합을 만들 리스트

        list1 = combinateWord(str1,list1);
        list2 = combinateWord(str2,list2);

        ArrayList<String> unionList			= getUnionList(list1,list2);//합집합 리스트
        ArrayList<String> interSectionList	= getInterSectionList(list1,list2);//교집합 리스트

        double union			= unionList.size();
        double interSection	= interSectionList.size();

        int answer = 0;

        if (interSection == 0 ) {//교집합이 0이면서

            if (union == 0) answer = 65536;//합집합이 0이면,
            else answer = 0;//합집합이 0이 아니면

        } else {

            answer = (int)((interSection/union)*(double)65536);// (교집합/합집합)*65536
        }

        return answer;
    }

    /*
    * 문자열의 단어 조합을 만들고 리스트로 반환
    * */
    private ArrayList<String> combinateWord(String str,ArrayList<String> list) {

        for (int i = 0; i < str.length()-1; i++) {

            String sub = str.substring(i,i+2).toUpperCase();

            if (sub.matches("^[A-Z]+$")) list.add(sub);

        }

        return list;
    }

    /*
    * 교집합을 만들고 반환
    * */
    private ArrayList<String> getInterSectionList(ArrayList<String> list1, ArrayList<String> list2) {

        list1 = (ArrayList<String>) list1.clone();
        list2 = (ArrayList<String>) list2.clone();

        ArrayList<String> interSectionList = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {

            String temp = list1.get(i);

            if (list2.contains(temp)) {//list1을 기준으로 list2에 포함하고 있다면,

                list2.remove(temp);//중복으로 검사하면 안되므로, 제거해준다.
                interSectionList.add(temp);//교집합 리스트에 추가해줌
            }
        }

        return interSectionList;
    }



    private ArrayList<String> getUnionList(ArrayList<String> list1, ArrayList<String> list2) {

        list1 = (ArrayList<String>) list1.clone();
        list2 = (ArrayList<String>) list2.clone();

        ArrayList<String> uionList = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {

            String temp = list1.get(i);

            if (list2.contains(temp)) {//list1을 기준으로 list2에 포함하고 있으면, 하나를 지워준다.

                list2.remove(temp);
            }

            uionList.add(temp);
        }

        uionList.addAll(list2);//list2의 중복이 아닌 모든 요소를 합집합에 추가해준다.

        return uionList;
    }
}
