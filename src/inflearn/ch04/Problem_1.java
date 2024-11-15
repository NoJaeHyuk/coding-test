package inflearn.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String nString = br.readLine();

        Map<Character,Integer> nMap = new HashMap();

        nMap.put('A',0);
        nMap.put('B',0);
        nMap.put('C',0);
        nMap.put('D',0);
        nMap.put('E',0);

        for(int i = 0; i < nString.length(); i++){
            if(nMap.containsKey(nString.charAt(i))){
                nMap.put(nString.charAt(i),nMap.get(nString.charAt(i))+1);
            }
        }

        Character maxKey = null;
        for (Character key : nMap.keySet()) {
            if (maxKey == null || nMap.get(key) > nMap.get(maxKey)) {
                maxKey = key;
            }
        }

        System.out.println(maxKey);
    }
}
