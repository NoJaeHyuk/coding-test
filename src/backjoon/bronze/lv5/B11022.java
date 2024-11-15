package backjoon.bronze.lv5;

import java.io.*;
import java.util.StringTokenizer;

public class B11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int a;
        int b;
        int sum = 0;
        for(int i = 0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sum = a+b;
            bw.write("Case #"+(i+1)+": ");
            bw.write(a+" + "+b);
            bw.write(" = "+sum+"\n");
        }

        bw.flush();
        bw.close();
    }
}
