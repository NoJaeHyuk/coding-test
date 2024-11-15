package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2800 {
    static List<int[]> brackets;
    static Set<String> result;
    static boolean[] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        brackets = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        //버켓의 '(', ')' 인덱스의 위치값을 넣어준다.
        for(int i=0; i<line.length(); i++) {
            char c = line.charAt(i);
            if(c == '(') {
                s.push(i);
            }else if(c == ')'){
                //int[] = { ')' index, '(' index }
                brackets.add(new int[] {s.pop(), i});
            }
        }

        check = new boolean[line.length()];
        result = new TreeSet<>();

        //조합알고리즘의 재귀방식
        combination(0, line.toCharArray());

        //정렬 후 출력
        result.stream().forEach(System.out::println);
    }

    /*
    재귀를 돌면서 탐색하여 모든 경우를 체크
     */
    static void combination(int depth, char[] str) {
        if(depth == brackets.size()) {
            boolean f = false;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<str.length; i++) {
                if(!check[i]) {
                    sb.append(str[i]);
                }else {
                    f = true;
                }
            }
            if(f) {
                result.add(sb.toString());
            }
            return;
        }

        combination(depth+1, str);

        int[] bracket = brackets.get(depth);

        //int[] -> { , } 로 받았기때문에
        check[bracket[0]] = true;
        check[bracket[1]] = true;

        combination(depth+1, str);

        check[bracket[0]] = false;
        check[bracket[1]] = false;
    }
}
