package inflearn.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_12 {
    static int n;
    static int[] ch;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<Integer>());
        }

        ch = new int[n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            list.get(row).add(col);
        }

        ch[1] = 1;
        DFS(1,list);
        System.out.println(answer);
    }

    private static void DFS(int idx, List<ArrayList<Integer>> list) {
        if(idx == n){
            answer++;
            return;
        }else{
            for(int nv : list.get(idx)){
                if(ch[nv] != 1){
                    ch[nv] = 1;
                    DFS(nv,list);
                    ch[nv] = 0;
                }
            }
        }
    }
}
