package programmers.l2;

import java.util.*;

public class P_무인도여행 {
    public static void main(String[] args) {
        solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
    }

    static char[][] c_map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();

        //직사각형이니깐
        c_map = new char[maps.length][maps[0].length()];
        visited = new boolean[c_map.length][c_map[0].length];

        for (int i = 0; i < maps.length; i++) {
            c_map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < c_map.length; i++) {
            for (int j = 0; j < c_map[i].length; j++) {
                if (!visited[i][j] && c_map[i][j] != 'X') {
                    answer.add(BFS(i, j));
                }
            }
        }

        if(answer.size() == 0){
            answer.add(-1);
        }else{
            Collections.sort(answer);
        }

        return answer;
    }

    public static int BFS(int i, int j) {
        int sum = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int cx = cur[0];
            int cy = cur[1];

            sum += c_map[cx][cy]-'0';

            //다음 연결지점을 큐에 삽입해야한다.
            for (int k = 0; k < dx.length; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if(nx < 0 || ny < 0 || nx >= c_map.length || ny >= c_map[0].length){
                    continue;
                }

                if (c_map[nx][ny] != 'X' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    //연결된 섬들을 큐에 삽입
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return sum;
    }


}
