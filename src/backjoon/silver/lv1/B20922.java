package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20922 {
    static int[] count = new int[100001];
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] num_array = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num_array[i] = Integer.parseInt(st.nextToken());
        }

        solve(num_array,K);

        System.out.println(MAX);
    }

    /**
     * 투포인터로직
     * @param arr - 입력값 배열
     * @param K - 입력값 - 최대중복값
     */
    public static void solve(int[] arr, int K){
        //두포인터는 같은위치에서 시작한다.
        int left = 0;
        int right = 0;

        //1. 오른쪽 포인터가 증가하며 K의 최대부분수열을 우선 구한다.
        //2. 최대수열을 구하면 왼쪽 포인터가 이동하며 다시 최대수열을 구한다.
        //3. 최종적으로 오른쪽 포인터가 입력배열의 마지막 인덱스까지 도달하면 동작을 탐색이 끝난다.
        //4. 탐색 중 갱신한 최대부분수열의 길이를 출력하면 된다.
        while (right < arr.length){
            //오른쪽포인터 우선 탐색
            while (right < arr.length && count[arr[right]]+1 <= K){
                count[arr[right]]++;
                right++;
            }

            //오른쪽포인터 구한 후 왼쪽 포인터 이동하여 탐색
            int leng = right-left;
            MAX = Math.max(MAX,leng);
            count[arr[left]]--;
            left++;
        }
    }
}
