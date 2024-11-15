package backjoon.bronze.lv4;

import java.io.*;

public class B2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            for (int j = 0; j < N-i-1; j++){
                bw.write(" ");
            }
            for (int k = 0; k <= i; k++){
                bw.write("*");
            }
            bw.write('\n');
        }

        bw.flush();
        bw.close();
    }
}