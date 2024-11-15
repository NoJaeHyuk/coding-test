package inflearn.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
3. 카카오 인형 뽑기
 */
public class Problem_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int M = Integer.parseInt(br.readLine());

        int[] moves = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            moves[i] = Integer.parseInt(st.nextToken());
        }

        solution(N,board,M,moves);

    }

    public static void solution(int N, int[][] board, int M, int[] moves){
        Stack<Integer> s = new Stack<>();
        int cnt = 0;

        for(int i = 0; i < moves.length; i++){
            int idx = moves[i] - 1;

            for(int j = 0; j < N; j++){
                if(board[j][idx] != 0){
                    if(s.size() != 0){
                        int cur_s = s.peek();

                        if(cur_s == board[j][idx]){
                            s.pop();
                            cnt += 2;
                            board[j][idx] = 0;
                            break;
                        }else{
                            s.push(board[j][idx]);
                            board[j][idx] = 0;
                            break;
                        }
                    }else{
                        s.push(board[j][idx]);
                        board[j][idx] = 0;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
