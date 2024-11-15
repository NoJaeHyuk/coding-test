package backjoon.bronze.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); //공백단위로 읽어드릴수 있는 라인 추가
        int A = Integer.parseInt(st.nextToken()); //한줄에서 공백 단위로 읽음
        int B = Integer.parseInt(st.nextToken()); //한줄에서 공백 단위로 읽음
        int C = Integer.parseInt(st.nextToken()); //한줄에서 공백 단위로 읽음

        //(A+B)%C
        System.out.println((A+B)%C);

        //((A%C) + (B%C))%C
        System.out.println(((A%C)+(B%C))%C);

        //(A×B)%C
        System.out.println((A*B)%C);

        //((A%C) × (B%C))%C
        System.out.println(((A%C) * (B%C))%C);

    }
}
