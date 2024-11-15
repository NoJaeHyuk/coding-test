package backjoon.bronze.lv5;

import java.util.Scanner;

/**
 *
 */
public class B2739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        StringBuilder cu = new StringBuilder();

        int i = 1;
        while (i < 10){
            cu.append(a+" * "+i+" = "+a*i+"\n");
            i++;
        }

        System.out.println(cu);
    }
}
