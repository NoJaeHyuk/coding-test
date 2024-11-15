package inflearn.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_14 {
    static ArrayList<Point> home = new ArrayList<>();
    static ArrayList<Point> pizza = new ArrayList<>();
    static int m;
    static int[] combi;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    home.add(new Point(i,j));
                }else if(tmp == 2){
                    pizza.add(new Point(i,j));
                }
            }
        }

        combi = new int[m];
        DFS(0,0);

        System.out.println(answer);
    }

    private static void DFS(int L, int s) {
        if(L == m){
            int sum = 0;
            for(Point p : home){
                int dis = Integer.MAX_VALUE;
                for(int i : combi){
                    dis=Math.min(dis, Math.abs(p.x-pizza.get(i).x)+Math.abs(p.y-pizza.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer,sum);
        }else {
            for(int j = s ; j < pizza.size(); j++){
                combi[L] = j;
                DFS(L+1, j+1);
            }
        }
    }

    static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
