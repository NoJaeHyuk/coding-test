package backjoon.bronze.lv5;

import java.io.*;
import java.util.StringTokenizer;

public class B11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int a;
        int b;
        int sum = 0;

        StringTokenizer st;

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sum = a+b;
            wr.write("Case #"+(i+1)+":");
            wr.write(" "+sum+"\n");
        }

        wr.flush();
        wr.close();
    }
}
