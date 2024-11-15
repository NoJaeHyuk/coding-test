package programmers.l2;

import java.util.ArrayList;
import java.util.List;

public class P_3차압축 {
    static List<String> arrList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 26; i++) {
            // ASCII Code를 char로 형변환하여 배열에 담기
            arrList.add(String.valueOf((char) (65 + i)));
        }

        List<Integer> answer = new ArrayList<>();

        String msg = "ABABABABABABABAB";

        int i = 0;
        String value = "";
        while (true){
            String cur = String.valueOf(msg.charAt(i));
            if(i != msg.length()-1){
                String s = String.valueOf(msg.charAt(i + 1));
                if(arrList.contains(cur) && !arrList.contains(cur+s)){
                    answer.add(arrList.indexOf(cur)+1);
                    arrList.add(cur+ s);
                }else{
                    answer.add(arrList.indexOf(cur+ s)+1);
                    arrList.add(cur+ s +String.valueOf(msg.charAt(i+2)));
                    i++;
                }
            }else{
                answer.add(arrList.indexOf(cur)+1);
                break;
            }
            i++;

            if(i == msg.length()-1){
                break;
            }
        }

        System.out.println();


    }
}
