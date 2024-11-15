package backjoon.bronze.lv1;

import java.util.Scanner;

public class b1236 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] charArray = new char[N][M];
        for (int i = 0; i < N; i++){
            charArray[i] = sc.next().toCharArray();
        }

        System.out.println(charArray);

    }
}
