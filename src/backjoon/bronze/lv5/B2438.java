package backjoon.bronze.lv5;

import java.io.*;

public class B2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int i = 0;

        StringBuilder sb = new StringBuilder();

        while (i < N){
            sb.append("*");
            bw.write(sb.toString()+"\n");
            i++;
        }

        bw.flush();
        bw.close();
    }
}
