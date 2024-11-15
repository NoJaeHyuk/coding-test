package backjoon.bronze.lv5;

import java.util.Scanner;

public class B10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        int b = 0;
        int c = 0;

        for(int i = 0; i < a; i++){
            b = sc.nextInt();
            c = sc.nextInt();
            sb.append(b+c+"\n");
        }

        System.out.println(sb);
    }
}
