package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2512 {
    static long max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] ary = new long[N];
        long left = 0;
        long right = 0;
        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            ary[i] = Integer.parseInt(st.nextToken());
            sum += ary[i];
            //입력값중 최대값 구하기
            right = Math.max(ary[i],right);
        }

        int total = Integer.parseInt(br.readLine());

        /*
        지방의 예산합이 주어진 예산보다 적을 경우 위에 얻은 최대값을 그대로 호출하며
		(위 조건절 없이 이분탐색만 해도 상관없다.)
        반대의 경우 이분탐색 진행
        이분탐색의 경우 가장 큰 수 기준으로 탐색 시작하며
        탐색의 중간값인 mid가 문제의 나오는 상환선이 된다.
		상환선을 이용해 최적의 상환선을 구하면 된다.
        결론적으로 max = right로 봐도 무방할거 같다.
         */
        if(sum > total){
            while (left <= right){
                long mid = (left+right)/2; // 세금의 상환선
                long result = 0; //지방 세금의 총합
                for(int i=0; i<N; i++){
                    if(mid < ary[i]){
                        result += mid;
                    }else{
                        result += ary[i];
                    }
                }

                if(result <= total){
                    left = mid+1;
                    max = Math.max(mid,max);
                }else{
                    right = mid-1;
                }
            }
            System.out.println(max);
        }else{
            System.out.println(right);
        }

    }
}
