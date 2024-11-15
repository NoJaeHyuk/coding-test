package fc.problem.ch1;

/**
 * 두 수의 합
 */

import java.util.Arrays;

public class P1 {

    public int[] solution(int[] nums, int target) {
        int[] answer = new int[2];

        // 투포인터로 풀어보기
        Arrays.sort(nums);

        int start = 0;
        int sum = 0;
        for (int end = nums.length - 1; end >= 0; end--) {
            sum = nums[start] + nums[end];

            if (sum == target) {
                answer[0] = nums[start];
                answer[1] = nums[end];
                break;
            }

            while (sum <= target) {
                sum = nums[++start] + nums[end];
                if (sum == target) {
                    answer[0] = nums[start];
                    answer[1] = nums[end];
                    return answer;
                }
            }
        }

        // HashMap 으로 풀어보자
        /*Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();

        for(int x : nums){
            map.put(x,0);
        }

        for(int x : nums){
            int y = target - x;
            if(map.containsKey(y) && x != y){
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }*/

        return answer;
    }

    public static void main(String[] args) {
        P1 T = new P1();
        System.out.println(Arrays.toString(T.solution(new int[]{3, 7, 2, 12, 9, 15, 8}, 12)));
        System.out.println(
            Arrays.toString(T.solution(new int[]{21, 12, 30, 15, 6, 2, 9, 19, 14}, 24)));
        System.out.println(
            Arrays.toString(T.solution(new int[]{12, 18, 5, 8, 21, 27, 22, 25, 16, 2}, 28)));
        System.out.println(
            Arrays.toString(T.solution(new int[]{11, 17, 6, 8, 21, 9, 19, 12, 25, 16, 2}, 26)));
        System.out.println(
            Arrays.toString(T.solution(new int[]{7, 5, 12, -9, -12, 22, -30, -35, -21}, -14)));
        System.out.println(Arrays.toString(T.solution(new int[]{7, 5, 12, 20}, 15)));
    }
}
