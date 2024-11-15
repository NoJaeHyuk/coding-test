package programmers.l2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_튜플 {
    public static void main(String[] args) {
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        s = s.substring(0,s.length()-2).replaceAll("[{]", "");

        String[] splitArr = s.split("},");

        Arrays.sort(splitArr, (String s1, String s2) -> s1.length() - s2.length());

        List<Integer> answer = new ArrayList<>();

        for(String s1 : splitArr){
            if(answer.size() == 0){
                answer.add(Integer.parseInt(s1));
            }else{
                for(String s2 :s1.split(",")){
                    if(!answer.contains(Integer.parseInt(s2))){
                        answer.add(Integer.parseInt(s2));
                    }
                }
            }
        }
    }
}
