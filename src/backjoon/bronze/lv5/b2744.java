package backjoon.bronze.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2744 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String p = br.readLine();

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < p.length(); i++){
            char ap = p.charAt(i);
            String ad = String.valueOf(p.charAt(i));

            if(Character.isUpperCase(ap)){
                result.append(ad.toLowerCase());
            }else{
                result.append(ad.toUpperCase());
            }


            // ASCII Code 이용
            /*
            if('A' <= ap && ap <= 'Z'){
                result.append(ap+'a'-'A');
            }else{
                result.append(ap+'A'-'a');
            }
            */

        }

        System.out.println(result);
    }
}
