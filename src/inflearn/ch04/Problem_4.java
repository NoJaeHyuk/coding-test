package inflearn.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
모든 아나그램 찾기
 */
public class Problem_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        String input2 = br.readLine();

        solution(input1,input2);
    }

    public static void solution(String input1, String input2){
        Map<Character,Integer> input1Map = new HashMap<>(); //input2 = count 보관 (명칭이 반대..)
        Map<Character,Integer> input2Map = new HashMap<>(); //input1의 원도우슬라이딩 count 보관
        int wSize = input2.length();

        int count = 0;

        //input1Map 반복문
        for(char a : input2.toCharArray()){
            input1Map.put(a, input1Map.getOrDefault(a,0)+1);
        }

        //input2Map 슬라이딩원도우 첫 배열
        for(int i=0; i < wSize; i++){
            input2Map.put(input1.charAt(i), input2Map.getOrDefault(input1.charAt(i),0)+1);
            //두 해시맵이 같으면 count++
            if(input1Map.equals(input2Map)){
                count++;
            }
        }

        //input1Map 슬라이딩원도우 첫배열 다음부터 진행 반복문
        //첫인덱스 빼주고, 다음인덱스 더해준다.
        for(int i = wSize; i < input1.length(); i++){
            input2Map.put(input1.charAt(i-wSize), input2Map.getOrDefault(input1.charAt(i-wSize),0)-1);
            if(input2Map.get(input1.charAt(i-wSize)) == 0){
                input2Map.remove(input1.charAt(i-wSize));
            }

            input2Map.put(input1.charAt(i), input2Map.getOrDefault(input1.charAt(i),0)+1);
            if(input1Map.equals(input2Map)){
                count++;
            }
        }

        System.out.println(count);
    }
}
