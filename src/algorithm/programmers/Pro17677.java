package algorithm.programmers;

import java.util.*;


/*
 * 2018 KAKAO BLIND RECRUITMENT
 * [1��] ���� Ŭ�����͸�
 * */
public class Pro17677 {

    public int solution(String str1, String str2) {
        ArrayList<String> list1 = new ArrayList<>();//str1�� �ܾ� ������ ���� ����Ʈ
        ArrayList<String> list2 = new ArrayList<>();//str2�� �ܾ� ������ ���� ����Ʈ

        list1 = combinateWord(str1,list1);
        list2 = combinateWord(str2,list2);

        ArrayList<String> unionList			= getUnionList(list1,list2);//������ ����Ʈ
        ArrayList<String> interSectionList	= getInterSectionList(list1,list2);//������ ����Ʈ

        double union			= unionList.size();
        double interSection	= interSectionList.size();

        int answer = 0;

        if (interSection == 0 ) {//�������� 0�̸鼭

            if (union == 0) answer = 65536;//�������� 0�̸�,
            else answer = 0;//�������� 0�� �ƴϸ�

        } else {

            answer = (int)((interSection/union)*(double)65536);// (������/������)*65536
        }

        return answer;
    }

    /*
    * ���ڿ��� �ܾ� ������ ����� ����Ʈ�� ��ȯ
    * */
    private ArrayList<String> combinateWord(String str,ArrayList<String> list) {

        for (int i = 0; i < str.length()-1; i++) {

            String sub = str.substring(i,i+2).toUpperCase();

            if (sub.matches("^[A-Z]+$")) list.add(sub);

        }

        return list;
    }

    /*
    * �������� ����� ��ȯ
    * */
    private ArrayList<String> getInterSectionList(ArrayList<String> list1, ArrayList<String> list2) {

        list1 = (ArrayList<String>) list1.clone();
        list2 = (ArrayList<String>) list2.clone();

        ArrayList<String> interSectionList = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {

            String temp = list1.get(i);

            if (list2.contains(temp)) {//list1�� �������� list2�� �����ϰ� �ִٸ�,

                list2.remove(temp);//�ߺ����� �˻��ϸ� �ȵǹǷ�, �������ش�.
                interSectionList.add(temp);//������ ����Ʈ�� �߰�����
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

            if (list2.contains(temp)) {//list1�� �������� list2�� �����ϰ� ������, �ϳ��� �����ش�.

                list2.remove(temp);
            }

            uionList.add(temp);
        }

        uionList.addAll(list2);//list2�� �ߺ��� �ƴ� ��� ��Ҹ� �����տ� �߰����ش�.

        return uionList;
    }
}
