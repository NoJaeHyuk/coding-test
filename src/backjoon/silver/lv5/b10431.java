package backjoon.silver.lv5;

import java.util.Scanner;

public class b10431 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt(); //테스트 케이스 수

        int cnt = 0;

        StringBuilder reselt = new StringBuilder();

        while (P --> 0){
            int T = sc.nextInt(); //테스트 케이스 번호
            int[] h = new int[20];

            for(int i=0; i<20; i++){
                h[i] = sc.nextInt();
            }

            for(int i=0; i < 20; i++){
                // 1. 줄 서 있는 학생 중에 자신보다 큰 학생을 찾는다.
                for(int j=0; j<i; j++){
                    if(h[i] < h[j]){
                        cnt++;
                    }
                }
            }

            reselt.append(T+" "+cnt+"\n");
            cnt = 0;
        }

        System.out.println(reselt);


    }
}
