package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B21610 {

    static int[][] nArray;
    static int N;

    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //NxN 배열의 N

        int M = Integer.parseInt(st.nextToken()); //이동횟수

        nArray = new int[N][N];

        List<int[]> move = new ArrayList<>();

        boolean[][] visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] a = new int[2];
            a[0] = Integer.parseInt(st.nextToken());
            a[1] = Integer.parseInt(st.nextToken());
            move.add(a);
        }

        //(N, 1), (N, 2), (N-1, 1), (N-1, 2) => (N-1,0) (N-1,1),(N-2,0),(N-2,1)
        //초기세팅값
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N - 1, 0});
        q.add(new int[]{N - 1, 1});
        q.add(new int[]{N - 2, 0});
        q.add(new int[]{N - 2, 1});


        for (int i = 0; i < move.size(); i++) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int[] a = new int[2];
                a = q.poll();
                //1
                a = move_value(a[0], a[1], move.get(i)[0], move.get(i)[1]);
                q.add(a);
                //2
                nArray[a[0]][a[1]] += 1;
                //3
                visit[a[0]][a[1]] = true;
            }

            //4
            int size1 = q.size();
            for (int j = 0; j < size1; j++) {
                int[] a = new int[2];
                a = q.poll();
                check(a);
            }

            //5
            for (int k = 0; k < N; k++) {
                for (int k1 = 0; k1 < N; k1++) {
                    if (!visit[k][k1] && nArray[k][k1] >= 2) {
                        nArray[k][k1] -= 2;
                        q.add(new int[]{k, k1});
                    }
                }
            }

            visit = new boolean[N][N];
        }

        int sum = 0;
        for (int k = 0; k < N; k++) {
            for (int k1 = 0; k1 < N; k1++) {
                sum += nArray[k][k1];
            }
        }

        System.out.println(sum);
    }

    //←, ↖, ↑, ↗, →, ↘, ↓, ↙
    public static int[] move_value(int row, int col, int d, int s) {
        int[] idx_array = new int[2];

        idx_array[0] = (row + N + dx[d] * s % N) % N;
        idx_array[1] = (col + N + dy[d] * s % N) % N;

        return idx_array;
    }

    public static void check(int[] a) {
        int count = 0;

        if (checkRange(a[0] - 1, a[1] - 1) && nArray[a[0] - 1][a[1] - 1] > 0) {
            count++;
        }

        if (checkRange(a[0] - 1, a[1] + 1) && nArray[a[0] - 1][a[1] + 1] > 0) {
            count++;
        }

        if (checkRange(a[0] + 1, a[1] - 1) && nArray[a[0] + 1][a[1] - 1] > 0) {
            count++;
        }

        if (checkRange(a[0] + 1, a[1] + 1) && nArray[a[0] + 1][a[1] + 1] > 0) {
            count++;
        }

        nArray[a[0]][a[1]] += count;
    }

    public static boolean checkRange(int r, int c) {
        if (r < 0 || r > N - 1 || c < 0 || c > N - 1) {
            return false;
        }
        return true;
    }

}
