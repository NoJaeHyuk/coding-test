package inflearn.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_3 {
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        solution(n, m, list);

        System.out.println(MAX);

    }

    private static void solution(int n, int m, List<int[]> list) {
        DFS(0,0,0,n,m,list);
    }

    private static void DFS(int idx,int sum, int time, int n, int m, List<int[]> list) {
        if (time > m) {
            return;
        }
        if(idx == n){
            if(time <= m){
                MAX = Math.max(sum, MAX);
            }
        }else{
            DFS(idx+1,sum+list.get(idx)[0], time+list.get(idx)[1],n,m, list);
            DFS(idx+1,sum, time, n, m, list);
        }
    }

}
