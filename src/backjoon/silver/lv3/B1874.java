package backjoon.silver.lv3;

import java.util.Scanner;
import java.util.Stack;

public class B1874 {
    static int[] array;
    static int sidx;

    static StringBuilder sb;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        array = new int[N];

        for(int i=0; i<N; i++){
            array[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        sidx = 0;
        sb = new StringBuilder();

        for(int i=0; i<N; i++){
            start(stack,sidx,N,i);
        }

        System.out.println(sb);

    }

    public static void start(Stack<Integer> stack, int idx, int N, int i1){
        if(stack.size() != 0 && stack.peek() == sidx){
            if(array[i1] < stack.peek()){
                sb = new StringBuilder("NO");
                return;
            }
        }

        for(int i=idx; i<=N; i++){
            if(stack.size() != 0 && array[i1] == stack.peek()){
                stack.pop();
                sb.append("- \n");
                return;
            }else{
                stack.push(i+1);
                sidx = Math.max(stack.peek(),sidx);
                sb.append("+ \n");
            }
        }
    }
}
