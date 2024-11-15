package backjoon.bronze.lv4;

import java.util.Scanner;

/**
 * 입력값 중 같은 값이 몇개인지 확인한다.
 * 몇개인지 확인했으면 조건에 맞는 상금을 계산해 표출한다.
 */
public class B2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int cnt = 0;
        int re = 0 ;

        if(a == b){
            cnt++;
            re = a;
        }

        if (a == c) {
            cnt++;
            re = a;
        }

        if (b == c) {
            cnt++;
            re = b;
        }

        if(cnt > 2 ){
            System.out.println(10000+re*1000);
        } else if (cnt == 1) {
            System.out.println(1000+re*100);
        } else {
            int max = Math.max(a,b);
            max = Math.max(max,c);
            System.out.println(max*100);
        }

        /*
        if(a==b && b==c){
            System.out.println(10000+(a*1000));
        }else if(a!=b && b!=c && a!=c){
            System.out.println(Math.max(Math.max(a, b), c)*100);
        }else{
            if (a==b || a==c){
                System.out.println(1000+(a*100));
            }else{
                System.out.println(1000+(b*100));
            }
        }
        */
    }
}
