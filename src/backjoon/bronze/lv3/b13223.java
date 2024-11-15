package backjoon.bronze.lv3;

import java.util.Scanner;

public class b13223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        String[] a1 = a.split(":");
        String[] b1 = b.split(":");

        int currentHour = Integer.parseInt(a1[0]);
        int currentMinute = Integer.parseInt(a1[1]);
        int currentSecond = Integer.parseInt(a1[2]);

        int targetHour = Integer.parseInt(b1[0]);
        int targetMinute = Integer.parseInt(b1[1]);
        int targetSecond = Integer.parseInt(b1[2]);

        int currentSecondTotal = currentHour * 3600 + currentMinute * 60 + currentSecond;
        int targetSecondTotal = targetHour * 3600 + targetMinute * 60 + targetSecond;

        int NeedSecondAmount = targetSecondTotal - currentSecondTotal;
        if(NeedSecondAmount <= 0){
            NeedSecondAmount += 24*3600;
        }

        int needHour = NeedSecondAmount / 3600;
        int needMinute = (NeedSecondAmount % 3600) / 60;
        int needSecond = NeedSecondAmount % 60;

        System.out.println(String.format("%02d:%02d:%02d", needHour, needMinute, needSecond));

    }
}
