package backjoon.silver.lv4;

import java.util.Scanner;

public class b1543 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();

        String b = sc.nextLine();

        int cnt = 0;

        if(a.contains(b)){
            a = a.replace(b,"X");
            for(int i = 0; i < a.length(); i++){
                if(a.charAt(i) == 'X'){
                    cnt++;
                }
            }
        }else{
            cnt = 0;
        }

        System.out.println(cnt);

    }
}
