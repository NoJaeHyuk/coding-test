package inflearn.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
LRU
 */
public class Problem_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] array = new int[s];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < s; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        solution(n,s,array);
    }

    public static void solution(int n, int s, int[] array){
        List<Integer> works = new ArrayList<>(n);
        //캐시 miss
        //캐시 hit
        for(int i = 0; i < s; i++){
            if(!works.contains(array[i])){
                works.add(0,array[i]);
            }else{
                works.remove(works.indexOf(array[i]));
                works.add(0,array[i]);
            }
        }

        for(int i = 0; i < n; i++){
            System.out.print(works.get(i) + " ");
        }
    }
}
