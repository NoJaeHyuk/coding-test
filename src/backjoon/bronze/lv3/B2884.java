package backjoon.bronze.lv3;

import java.util.Scanner;

public class B2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();
        m -= 45;
        if (m < 0) {
            h--;
            m += 60;
        }
        if (h < 0) h = 23;

        System.out.println(h +" "+ m);
    }
}
