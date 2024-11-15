package programmers.l2;

import java.util.*;

public class P_영어끝말잇기 {
    public static void main(String[] args) {
        P_영어끝말잇기 a = new P_영어끝말잇기();

        int[] result = a.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});

        for(int c : result){
            System.out.println(c);
        }
    }

    public int[] solution(int n, String[] words) {
        Queue<Integer> q = new LinkedList<>();
        List<String> checkList = new ArrayList<>();
        Map<Integer,Integer> countMap = new HashMap<>();

        //1차로 세팅
        for(int i = 1; i <= n; i++){
            q.offer(i);
            countMap.put(i, 0);
        }

        for(int i = 0; i < words.length; i++){
            int cur = q.poll();
            countMap.put(cur, countMap.getOrDefault(cur,0)+1);

            if(checkList.size() == 0){
                checkList.add(words[i]);
            }else{
                char f_last = checkList.get(i-1).charAt(checkList.get(i-1).length() - 1);
                char l_last = words[i].charAt(0);

                if(checkList.contains(words[i]) || f_last != l_last){
                    return new int[]{cur,countMap.get(cur)};
                }else{
                    checkList.add(words[i]);
                }
            }

            q.offer(cur);
        }

        return new int[]{0,0};
    }
}
