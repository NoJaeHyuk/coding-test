package backjoon.bronze.lv2;

import java.util.Scanner;

public class b1919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String o1 = sc.next();
        String o2 = sc.next();

        int[] countA = new int[26];
        int[] countB = new int[26];

        for(int i = 0; i < o1.length(); i++){
            countA[o1.charAt(i) - 'a']++;
        }

        for(int i = 0; i < o2.length(); i++){
            countB[o2.charAt(i) - 'a']++;
        }

        int ans = 0;

        for(int i = 0; i < 26; i++){
            ans += Math.abs(countA[i]-countB[i]);
        }

        System.out.println(ans);
    }
}
