package algorithm.programmers;

import java.util.*;

/*
* 2019 īī�� ����ε�
* ���� ä�ù�
* */
public class Pro42888 {

    //ä�ù� ���¸� ������ Ŭ����
    private class Room {
        String state;
        String userId;

        public Room(String state, String userId) {
            this.state = state;
            this.userId = userId;
        }
    }

    public String[] solution(String[] record) {
        ArrayList<Room> stateOrder = new ArrayList<>();//ä�ù��� ����/���� ���¸� ������ ����Ʈ
        HashMap<String,String> user = new HashMap<>();//������ ���̵�� �г����� ���¸� ������ ��

        for (String str : record) {

            String[] arr = str.split(" ");

            String state = arr[0];// ����/����/�г��� ���濡 ���� ����
            String id	 = arr[1];// ���̵�

            if (arr.length == 3) {// ����/�г��� ������ üũ

                String name	 = arr[2];

                user.put(id, name);//�ʿ� ���̵� ���� �г����� ����

                if ("Change".equals(state)) continue;//�г��� ������ ��� ����Ʈ�� �߰������� �ʰ� ���� �б⹮����
            }

            Room r = new Room(state,id);

            stateOrder.add(r);// ����/���� ���¸� ������ ����Ʈ�� �߰�

        }

        String[] result = new String[stateOrder.size()];

        for (int i = 0; i < stateOrder.size(); i++) {

            Room room = stateOrder.get(i);

            result[i] = roomStateMessage(room,user);//���� ID�� ���� ä�ù��� ���¸� �޼����� ��ȯ

        }
        return result;
    }


    //������ ���� ä�ù��� ���¸� �޼��� ���·� ��ȯ�ϱ����� �޼���
    private String roomStateMessage(Room room,HashMap<String,String> user) {

        String state = room.state;//���� ����
        String name = user.get(room.userId);//�г���

        String rtnMessage = "";

        switch(state) {

            case "Enter" ://����
                rtnMessage = name + "���� ���Խ��ϴ�.";
                break;
            case "Leave" ://����
                rtnMessage = name + "���� �������ϴ�.";
                break;
        }

        return rtnMessage;
    }
}
