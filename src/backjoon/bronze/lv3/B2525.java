package backjoon.bronze.lv3;

import java.util.Scanner;

/**
 * 일반 분끼리 더해 더한값을 60으로 나누어 몫을 시간에 더한다.
 * 더한 시간이 23을 초과하는지 확인한다.
 * 초과하였으면 값의 24 뺴서 나타낸다.
 */
public class B2525 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();

        int r1 = sc.nextInt();

        m += r1;

        if(m >= 60){
            if(h + (m/60) > 23){
                h = (h + (m/60))-24;
            }else{
                h = (h + (m/60));
            }
            m = m%60;
        }

        System.out.println(h+" "+m);
    }
}
