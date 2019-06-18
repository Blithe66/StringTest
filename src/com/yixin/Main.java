package com.yixin;

import java.util.ArrayList;
import java.util.List;

public class Main {

    enum Temp {
        E_1('['),
        E_2('{'),
        E_3('('),
        E_$1(']'),
        E_$2('}'),
        E_$3(')'),;
        private char value;

        Temp(char value) {
            this.value = value;
        }
    }

    static void add(List<Temp> tempList, Temp temp) {
        tempList.add(temp);
    }

    static void remove(List<Temp> tempList, Temp temp) throws Exception {
        if (tempList.get(tempList.size() - 1).equals(temp)) {
            tempList.remove(tempList.size() - 1);
        } else {
            throw new Exception("failed");
        }
    }

    static void judge(Temp[] tempArr) {
        List<Temp> tempList = new ArrayList<>();
        for (int i = 0;i<tempArr.length /2 ; i++) {
            add(tempList, tempArr[i]);
        }
        for (int j = tempList.size() ; j<tempArr.length;j++) {
            try {
                switch (tempArr[j]){
                    case E_1:
                        remove(tempList, Temp.E_$1);
                        break;
                    case E_2:
                        remove(tempList, Temp.E_$2);
                        break;
                    case E_3:
                        remove(tempList, Temp.E_$3);
                        break;
                    case E_$1:
                        remove(tempList, Temp.E_1);
                        break;
                    case E_$2:
                        remove(tempList, Temp.E_2);
                        break;
                    case E_$3:
                        remove(tempList, Temp.E_3);
                        break;
                }
            } catch (Exception e) {
                System.out.println("faild");
                return;
            }
        }
        if(tempList.size() == 0){
            System.out.println("success");
            return;
        }
    }

    public static void main(String[] args) {

        Temp[] tempArr = new Temp[]{
                Temp.E_1, Temp.E_2, Temp.E_3, Temp.E_$1, Temp.E_$2, Temp.E_$3,
        };

        Temp[] tempArr2 = new Temp[]{
                Temp.E_1, Temp.E_2, Temp.E_3, Temp.E_$3, Temp.E_$2, Temp.E_$1,Temp.E_$1,Temp.E_$1
        };
        Temp[] tempArr3 = new Temp[]{
                Temp.E_2,       Temp.E_2, Temp.E_1, Temp.E_$3, Temp.E_3, Temp.E_$1, Temp.E_$2, Temp.E_$2
        };
        try {
            judge(tempArr);
          judge(tempArr2);
            judge(tempArr3);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}