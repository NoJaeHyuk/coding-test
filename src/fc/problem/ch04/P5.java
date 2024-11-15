package fc.problem.ch04;

import java.util.Arrays;

public class P5 {
    static class Solution {

        public int solution(int[] nums, int n){
            int answer = 0;
            Arrays.sort(nums);

            int min = 1;
            int max = Arrays.stream(nums).max().getAsInt()+1;
            int mid = 0;

            while (min <= max) {
                mid = (max + min) / 2;

                long count = 0;

                for (int i = 0; i < nums.length; i++) {
                    count += (nums[i] / mid);
                }

                if(count < n) {
                    max = mid -1;
                }
                else {
                    answer = mid;
                    min = mid + 1;
                }
            }

            return answer;
        }

        public static void main(String[] args){
            Solution T = new Solution();
            System.out.println(T.solution(new int[]{802, 743, 457, 539}, 11));
            System.out.println(T.solution(new int[]{8593, 9617, 9313, 4513, 7505, 5457, 8257, 4689, 2657}, 100));
            System.out.println(T.solution(new int[]{93, 97, 93, 53, 75, 57, 85, 89, 67}, 30));
        }
    }
}
