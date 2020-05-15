package algorithm.programmers;

import java.util.*;

/*
* 2019 카카오 블라인드
* 오픈 채팅방
* */
public class Pro42888 {

    //채팅방 상태를 저장할 클래스
    private class Room {
        String state;
        String userId;

        public Room(String state, String userId) {
            this.state = state;
            this.userId = userId;
        }
    }

    public String[] solution(String[] record) {
        ArrayList<Room> stateOrder = new ArrayList<>();//채팅방을 입장/퇴장 상태를 저장할 리스트
        HashMap<String,String> user = new HashMap<>();//유저의 아이디와 닉네임의 상태를 저장할 맵

        for (String str : record) {

            String[] arr = str.split(" ");

            String state = arr[0];// 입장/퇴장/닉네임 변경에 대한 상태
            String id	 = arr[1];// 아이디

            if (arr.length == 3) {// 입장/닉네임 변경을 체크

                String name	 = arr[2];

                user.put(id, name);//맵에 아이디에 대한 닉네임을 저장

                if ("Change".equals(state)) continue;//닉네임 변경일 경우 리스트에 추가해주지 않고 다음 분기문으로
            }

            Room r = new Room(state,id);

            stateOrder.add(r);// 입장/퇴장 상태를 저장할 리스트에 추가

        }

        String[] result = new String[stateOrder.size()];

        for (int i = 0; i < stateOrder.size(); i++) {

            Room room = stateOrder.get(i);

            result[i] = roomStateMessage(room,user);//유저 ID에 대한 채팅방의 상태를 메세지로 변환

        }
        return result;
    }


    //유저에 대한 채팅방의 상태를 메세지 형태로 변환하기위한 메서드
    private String roomStateMessage(Room room,HashMap<String,String> user) {

        String state = room.state;//입장 상태
        String name = user.get(room.userId);//닉네임

        String rtnMessage = "";

        switch(state) {

            case "Enter" ://입장
                rtnMessage = name + "님이 들어왔습니다.";
                break;
            case "Leave" ://퇴장
                rtnMessage = name + "님이 나갔습니다.";
                break;
        }

        return rtnMessage;
    }
}
