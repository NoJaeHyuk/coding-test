package backjoon.bronze.lv4;

import java.util.Scanner;

public class B2753 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int in = sc.nextInt();

        if((in%4 == 0 && in%100 != 0) ||  (in%4 == 0 && in%400 == 0)){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
}
