package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2805 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(binary_search(arr, m, 0, arr[arr.length - 1]));
    }

    private static int binary_search(int[] trees, int target, int start, int end) {
        int result = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long total = getCutWood(trees, mid);

            if (total >= target) {
                result = mid; // 최적값 갱신
                start = mid + 1; // 더 높은 높이를 탐색
            } else {
                end = mid - 1; // 더 낮은 높이를 탐색
            }
        }

        return result;
    }

    private static long getCutWood(int[] trees, int height) {
        long total = 0;
        for (int tree : trees) {
            if (tree > height) {
                total += tree - height;
            }
        }
        return total;
    }

}
