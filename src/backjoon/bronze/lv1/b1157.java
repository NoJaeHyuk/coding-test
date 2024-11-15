package backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1157 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bb = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine().toUpperCase();

        int[] countA = new int[26];

        for(int i = 0; i < a.length(); i++){
            countA[a.charAt(i)-'A']++;
        }

        char ch = '?';
        int maxNum = -1;

        for(int i = 0; i < 26; i++){
            if (countA[i] > maxNum) {
                maxNum = countA[i];
                ch = (char)(i + 'A');
            } else if (countA[i] == maxNum) {
                ch = '?';
            }
        }

        System.out.println(ch);
    }

}
