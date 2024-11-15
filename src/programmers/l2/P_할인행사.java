package programmers.l2;

import java.util.HashMap;
import java.util.Map;

/**
 * 슬라이딩 원도우
 */
public class P_할인행사 {

    public static void main(String[] args) {
        P_할인행사 p = new P_할인행사();
        p.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1},
            new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> countMap = new HashMap<>();
        int days = 0;

        for(int i = 0; i < want.length; i++){
            countMap.put(want[i], number[i]);
            days += number[i];
        }

        //0부터 시작하니깐 + 1
        for(int i = 0; i < (discount.length - days)+1; i++){
            Map<String, Integer> checkMap = new HashMap<>();
            for(int j = i;  j < (i+days); j++){
                checkMap.put(discount[j], checkMap.getOrDefault(discount[j],0)+1);
            }

            Boolean isIdentical = true;

            for(String key : countMap.keySet()){
                if(countMap.get(key) != checkMap.get(key)){
                    isIdentical = false;
                    break;
                }
            }

            answer += isIdentical ? 1 : 0;
        }

        return answer;
    }

}
