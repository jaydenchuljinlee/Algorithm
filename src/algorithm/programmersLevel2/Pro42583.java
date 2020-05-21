package algorithm.programmersLevel2;

import java.util.*;

/*
* ���α׷��ӽ�
* �ٸ��� ������ Ʈ��
* */
public class Pro42583 {

    //Ʈ�� ���� Ŭ����
    private static class Truck{
        int weight;//Ʈ���� ����
        int waittingTime;//Ʈ���� ���� �ҿ� �ð�

        public Truck(int weight, int waittingTime) {
            this.weight = weight;
            this.waittingTime = waittingTime;
        }

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Truck> waitting = new LinkedList<>();//����ϰ� �ִ� Ʈ��
        ArrayList<Truck> passing = new ArrayList<>();//������ �ִ� Ʈ��

        for (int info : truck_weights) {//Ʈ�� ������ ��� ť�� �߰����ش�.

            waitting.add(new Truck(info,bridge_length));
        }

        int answer = 0;

        while(!waitting.isEmpty() || !passing.isEmpty()) {//������� Ʈ���� �ְų� �ٸ��� ������ Ʈ���� ���� ������

            answer++;

            //�ٸ��� ������ Ʈ���� �ְ� ���� �� Ʈ���� �ٸ��� �ǳ��� ��,
            if (!passing.isEmpty() && passing.get(0).waittingTime == 0) {

                weight += passing.get(0).weight;//���� ���� ���Կ��� �ǳ� Ʈ���� ���Ը� �����ش�.
                passing.remove(0);//�ٸ��� ������ ����Ʈ���� �������ش�.
            }

            //������� Ʈ���� �ְ� ���� �� Ʈ���� ���԰� ���� ���� ���Ժ��� �۰ų� ���� ��
            if (!waitting.isEmpty() && (waitting.peek().weight <= weight)) {

                weight -= waitting.peek().weight;//���� ���� ���Կ��� Ʈ���� ���Ը� ���ش�.

                passing.add(waitting.poll());//�ٸ��� ������ ����Ʈ�� �߰����ش�.
            }

            //�ٸ��� ������ Ʈ������ �ҿ�ð��� 1�� ����
            for (Truck truck : passing) {

                truck.waittingTime--;
            }
        }

        return answer;
    }

}
