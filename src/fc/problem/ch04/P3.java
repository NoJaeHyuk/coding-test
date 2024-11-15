package fc.problem.ch04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class P3 {
    static class Solution {
        public int solution(int[][] nums){
            int answer = 0;

            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

            List<Lecture> list = new ArrayList<>();
            int maxDay = 0;

            for(int i = 0; i < nums.length; i++) {
                list.add(new Lecture(nums[i][0], nums[i][1]));
                maxDay = Math.max(maxDay,nums[i][1]);
            }

            Collections.sort(list);

            int j = 0;
            for(int i = maxDay; i > 0; i--){
                for(; j < nums.length; j++){
                    if(list.get(j).day < i){
                        break;
                    }
                    queue.add(list.get(j).money);
                }
                if(!queue.isEmpty()){
                    answer += queue.poll();
                }
            }

            return answer;
        }


        static class Lecture implements Comparable<Lecture>{
            private int money;
            private int day;

            public Lecture(int money, int day) {
                this.money = money;
                this.day = day;
            }

            @Override
            public int compareTo(Lecture o) {
                return o.day - this.day;
            }
        }


        public static void main(String[] args){
            Solution T = new Solution();
            System.out.println(T.solution(new int[][]{{50, 2}, {20, 1}, {40, 2}, {60, 3}, {30, 3}, {30, 1}}));
            System.out.println(T.solution(new int[][]{{50, 2}, {40, 2}, {20, 1}, {10, 1}}));
            System.out.println(T.solution(new int[][]{{70, 5}, {60, 1}, {80, 2}, {70, 1}}));
        }
    }
}
