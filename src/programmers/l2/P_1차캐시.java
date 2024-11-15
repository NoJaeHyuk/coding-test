package programmers.l2;

import java.util.ArrayList;
import java.util.List;

public class P_1차캐시 {
    public static void main(String[] args) {
        P_1차캐시 p = new P_1차캐시();

        p.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"});
    }

    static List<String> list;

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        //LRU 는 hit 와 miss 로 구성된다.
        //LRU 는 고정된 크기 배열에서 가장 사용하지 않는 인덱스를 제거하여 새로운 들어온 동작을 처리하는 것이다.
        //hit 는 고정된 배열안에 이미 값이 있을겅우이며 이 경우 그 값을 최우선순위로 이동시킨다.
        //miss 는 고정된 배열안에 값이 없을 경우 마지막 인덱스를 제거한 후 들어온 값이 최우선순위로 동작하게 된다.
        list = new ArrayList<>(cacheSize);

        if(cacheSize == 0) return cities.length*5;

        for(String str : cities){
            String strA = str.toLowerCase();
            if(list.contains(strA)){
                //hit
                lruHit(cacheSize, strA);
                answer += 1;
            }else{
                //miss
                lruMiss(cacheSize, strA);
                answer += 5;
            }
        }


        return answer;
    }

    public static void lruMiss(int cacheSize, String str){
        if(list.size() == cacheSize){
            list.remove(cacheSize-1);
            list.add(0,str);
        }else{
            list.add(0,str);
        }
    }

    public static void lruHit(int cacheSize, String str){
        list.remove(list.indexOf(str));
        list.add(0,str);
    }
}
