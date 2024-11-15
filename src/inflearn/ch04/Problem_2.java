package inflearn.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String array_1 = br.readLine();
        String array_2 = br.readLine();

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        String chk = "YES";

        for(char c : array_1.toCharArray()){
            map1.put(c, map1.getOrDefault(c,0)+1);
        }

        for(char c : array_2.toCharArray()){
            map2.put(c, map2.getOrDefault(c,0)+1);
        }

        for(char key : map1.keySet()){
            if(map2.containsKey(key)){
                if(map1.get(key) != map2.get(key)){
                    chk = "NO";
                    break;
                }
            }else if(!map2.containsKey(key)){
                chk = "NO";
                break;
            }
        }

        System.out.println(chk);
    }
}
