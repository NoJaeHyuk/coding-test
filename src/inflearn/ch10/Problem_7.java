package inflearn.ch10;

public class Problem_7 {
    public static void main(String[] args) {
        System.out.println(solution(12, 3, new int[]{2,3,6,7,8,10,11}));
    }

    private static int solution(int n, int k, int[] arr) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE; // 초기값을 최대값으로 설정
            for (int j = 0; j < arr.length; j++) {
                if (i - arr[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }

        return dp[n];
    }
}
