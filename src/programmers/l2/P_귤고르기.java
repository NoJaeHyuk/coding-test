package programmers.l2;

import java.util.*;

public class P_귤고르기 {
    public static void main(String[] args) {
        System.out.println(solution(6,new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }

    public static int solution(int k, int[] tangerine){
        int answer = 0;

        Map<Integer,Integer> countMap = new HashMap<>();

        for(int e : tangerine){
            countMap.put(e,countMap.getOrDefault(e,0)+1);
        }

        //Map 값을 List 담는다.
        List<Integer> keylist = new ArrayList<>(countMap.keySet());
        //큰 수로 정렬하여 푼다.
        Collections.sort(keylist, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return countMap.get(o2)-countMap.get(o1);
            }
        });

        //keylist.sort((o1, o2) -> countMap.get(o2) - countMap.get(o1));

        // Integer같이 Comparable<>이 구현된
        // Comparator.naturalOrder() => 오름차순
        // Comparator.reverseOrder() => 내림차순
        // int 기본 타입
        // Comparator.comparingInt(Map::get)

        for(Integer i : keylist){
            if(k <= 0){
                break;
            }
            answer++;
            k -= countMap.get(i);
        }
        return answer;
    }
}
