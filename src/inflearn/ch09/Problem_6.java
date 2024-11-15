package inflearn.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_6 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];

        for(int i = 0; i <= n; i++){
            parents[i] = i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            union(s,e);
        }

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int fa = find(a);
        int fb = find(b);

        if(fa == fb){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

    private static void union(int s, int e) {
        s = find(s);
        e = find(e);

        if (s != e) {
            parents[s] = e;
        }
    }

    private static int find(int a) {
        if(a == parents[a]){
            return a;
        }

        return parents[a] = find(parents[a]);
    }


}
