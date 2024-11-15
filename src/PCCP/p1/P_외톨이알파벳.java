package PCCP.p1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_외톨이알파벳 {
    public static void main(String[] args) {
        P_외톨이알파벳 p = new P_외톨이알파벳();
        p.solution("edeaaabbccd");
    }

    public String solution(String input_string) {
        String answer = "";

        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Integer> countDivideMap = new HashMap<>();

        List<Character> result = new ArrayList<>();

        char prevChar = '-';
        for(int i = 0; i < input_string.length(); i++){
            char tmp = input_string.charAt(i);
            countMap.put(tmp, countMap.getOrDefault(tmp, 0) + 1);
            if(prevChar != tmp){
                countDivideMap.put(tmp, countDivideMap.getOrDefault(tmp, 0) + 1);
                prevChar = tmp;
            }
        }

        for(char a : countMap.keySet()){
            if(countDivideMap.get(a) >= 2 && countDivideMap.get(a) >= 2){
                answer += a;
            }
        }

        if(answer == ""){
            answer = "N";
        }

        return answer;
    }


}
