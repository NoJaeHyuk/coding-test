package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888 {

    static int max_val = Integer.MIN_VALUE;
    static int min_val = Integer.MAX_VALUE;
    static int N;
    static int[] array;
    static int[] oper_array;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        array = new int[N];
        oper_array = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            oper_array[i] = Integer.parseInt(st.nextToken());
        }

        //기본세팅
        //첫수는 정해져 있으므로 depth 1과 첫 수 선언
        solve(1,array[0]);

        System.out.println(max_val);
        System.out.println(min_val);
    }

    public static void solve(int depth, int sum){
        /* 종료 조건 */
        // 모든 연산자를 사용했을경우
        if (depth == N) {
            max_val = Math.max(max_val, sum);
            min_val = Math.min(min_val, sum);
            return;
        }

        //연산자의 종류만큼 로직 수행
        for(int i=0; i<4; i++){
            if(oper_array[i]>0){ //연산자배열의 해당 연산자가 1개라도 있을경우
                oper_array[i]--; //연산자를 사용하므로 감소

                switch (i){
                    case 0:
                        solve(depth+1,sum+array[depth]);
                        break;
                    case 1:
                        solve(depth+1,sum-array[depth]);
                        break;
                    case 2:
                        solve(depth+1,sum*array[depth]);
                        break;
                    case 3:
                        solve(depth+1,sum/array[depth]);
                        break;
                }

                oper_array[i]++; // 재귀 호출 후엔 연산자 개수를 복구
            }
        }
    }
}
