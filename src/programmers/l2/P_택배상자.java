package programmers.l2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P_택배상자 {
    public static void main(String[] args) {
        P_택배상자 p = new P_택배상자();
        p.solution(new int[]{5, 4, 3, 2, 1});
    }

    public int solution(int[] order) {
        //보조컨테이너
        Stack<Integer> assident = new Stack<>();
        //1~N 값을 가진 컨테이너
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= order.length; i++){
            q.offer(i);
        }

        int idx = 0;

        //q를 이용해 반복문 설정했더니 큐가 종료했을때 문제가 발생해 무한반복형태로 변경
        while(true){
            boolean flag = false;

            //큐의 값이 있고 큐포인터와 값이 같은 경우 count++
            //큐에서 값 poll()
            if(!q.isEmpty() && order[idx] == q.peek()){
                q.poll();
                idx++;
                flag = true;
                continue;
            }

            //위에서 1차적으로 거르지 못하면 스택을 본다.
            //스택에 해당 값과 맞는값이 있으면 count++
            //stack에서 pop()
            if(!assident.isEmpty() && order[idx] == assident.peek()) {
                assident.pop();
                idx++;
                flag = true;
                continue;
            }

            //위 코드를 둘 다 만족하지 않으면 해당하지 않는거이므로 stack에 add() 한다.
            if(!q.isEmpty()) {
                assident.add(q.poll());
                flag = true;
            }

            if(!flag) {
                break;
            }
        }
        return idx;
    }
}
