package inflearn.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_6 {
    static int n,m;
    static int[] array;
    static int[] check,pm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n];
        check = new int[n];
        pm = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);
    }

    private static void DFS(int L) {
        if(L == m){
            for(int d : pm){
                System.out.print(d+" ");
            }
            System.out.println();
        }else{
            for(int i = 0; i < n; i++){
                if(check[i] == 0){
                    check[i] = 1;
                    pm[L] = array[i];
                    DFS(L+1);
                    check[i] = 0;
                }
            }
        }
    }


}
