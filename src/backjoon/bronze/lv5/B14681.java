package backjoon.bronze.lv5;

import java.util.Scanner;

public class B14681 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int in1 = sc.nextInt();
        int in2 = sc.nextInt();
        
        if(in1 > 0 && in2 > 0){
            System.out.println(1);
        } else if (in1 < 0 && in2 > 0) {
            System.out.println(2);
        } else if (in1 < 0 && in2 < 0) {
            System.out.println(3);
        } else if (in1 < 0 && in2 > 0) {
            System.out.println(4);
        }


    }
}
