package programmers.l2_2;

import java.util.ArrayList;
import java.util.List;

public class P_우박수열 {

    public static void main(String[] args) {
        P_우박수열 p = new P_우박수열();
        p.solution(5, new int[][]{{0, 0}, {0, -1}, {2, -3}, {3, -3}});
    }

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        List<Integer> list = new ArrayList<>();

        while (k > 1) {
            list.add(k);
            // 짝수면 2로 나눕니다.
            if (k % 2 == 0) {
                k = k / 2;
            } else {
                // 홀수라면 3을 곱하고 1을 더합니다.
                k = (k * 3) + 1;
            }
        }

        list.add(k);

        // 사다리꼴
        // ((윗변 + 아래변)*높이)/2
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i][0] > ranges[i][1] + list.size() - 1) {
                answer[i] = -1;
                continue;
            } else if (ranges[i][0] == ranges[i][1] + list.size() - 1) {
                answer[i] = 0;
                continue;
            }

            int s = ranges[i][0];
            int e = list.size() + ranges[i][1] - 1;

            double dimension = 0;

            for (int j = s; j < e; j++) {
                dimension += (list.get(j) + list.get(j + 1)) / 2.0;
            }

            answer[i] = dimension;
        }

        return answer;
    }

}
