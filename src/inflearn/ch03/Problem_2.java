package inflearn.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
2. 공통원소구하기 (투포인터)
 */
public class Problem_2 {
    static ArrayList<Integer> result_list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nArray = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] mArray = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            mArray[i] = Integer.parseInt(st.nextToken());
        }

        solution(N,M,nArray,mArray);

        for(Integer a : result_list){
            System.out.print(a+" ");
        }

    }

    public static void solution(int N, int M, int[] nArray, int[] mArray){
        Arrays.sort(nArray);
        Arrays.sort(mArray);

        int p2 = 0;

        for(int i = 0; i < nArray.length; i++){
            for(int j = p2; j < mArray.length; j++){
                if(nArray[i] == mArray[j]){
                    result_list.add(nArray[i]);
                    p2++;
                    break;
                }
            }
        }
    }
}
