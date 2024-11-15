package inflearn.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
5. K번째 큰 수
 */
public class Problem_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        solution(N, K, array);
    }

    public static void solution(int N, int K, int[] array){
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                for(int q = j+1; q < N; q++){
                    treeSet.add(array[i] + array[j] + array[q]);
                }
            }
        }

        int cnt = 0;

        if(K > treeSet.size()){
            System.out.println(-1 + " ");
            return;
        }

        for(Integer a : treeSet){
            cnt++;

            if(cnt == K){
                System.out.println(a);
                break;
            }
        }
    }
}
