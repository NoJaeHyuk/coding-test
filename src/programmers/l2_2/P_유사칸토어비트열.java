package programmers.l2_2;

public class P_유사칸토어비트열 {
    static class Solution {
        public int solution(int n, long l, long r) {
            int answer = 0;
            long pow = (long) Math.pow(5, n - 1);

            for (long i = l; i <= r; i++) {
                if ((i / pow == 2 && i % pow != 0) || (i / pow == 3 && i % pow == 0) || (i % 5 == 3)) {
                    continue;
                }

                answer += getAnswer(n - 1, i);
            }

            return answer;
        }

        private int getAnswer(int n, long l) {
            return 1;
        }

        public static void main(String[] args) {
            Solution T = new Solution();
            System.out.println(T.solution(2, 4, 17));
        }
    }
}
