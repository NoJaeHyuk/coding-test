package inflearn.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
3. 매출액의 종류
 */
public class Problem_3 {
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

        Map<Integer,Integer> kMap = new HashMap<>();
        for(int i = 0; i < K; i++){
            kMap.put(array[i], kMap.getOrDefault(array[i],0)+1);
        }

        System.out.print(kMap.keySet().size() + " ");

        for(int j=K; j<N; j++){
            kMap.put(array[j-K], kMap.getOrDefault(array[j-K],0)-1);
            if(kMap.get(array[j-K]) <= 0){
                kMap.remove(array[j-K]);
            }

            kMap.put(array[j],kMap.getOrDefault(array[j],0)+1);

            System.out.print(kMap.keySet().size() + " ");
        }

    }
}
