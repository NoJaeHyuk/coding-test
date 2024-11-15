package inflearn.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
7. 수업설계
 */
public class Problem_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        solution(s1,s2);
    }

    public static void solution(String s1,String s2){
        Queue<Character> queue = new LinkedList<>();

        //필수과목을 큐에 넣는다.
        for(char c : s1.toCharArray()){
            queue.add(c);
        }

        //수업설계와 큐의 포인터값과 같으면 poll 해준다.
        for(char c : s2.toCharArray()){
            if(c == queue.peek()){
                queue.poll();
            }
            if(queue.isEmpty()){
                System.out.println("YES");
                return;
            }
        }

        //위에 조건이 걸려있으므로 따로 조건이 필요없다.
        System.out.println("NO");
    }
}
