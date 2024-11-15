import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] nArray;
    static int[] mArray;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        nArray = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        mArray = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mArray[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0, N, M);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

        List<String> aaList = Arrays.asList("a", "b", "c", "d", "e");
        aaList.remove(0);

    }

    public static void solution(int start, int end, int N, int M) {
        while (start < N && end < M) {
            if (nArray[start] < mArray[end]) {
                result.add(nArray[start]);
                start++;
            } else if (nArray[start] > mArray[end]) {
                result.add(mArray[end]);
                end++;
            } else {
                result.add(nArray[start]);
                result.add(mArray[end]);
                start++;
                end++;
            }
        }

        while (start < N) {
            result.add(nArray[start]);
            start++;
        }

        while (end < M) {
            result.add(mArray[end]);
            end++;
        }
    }
}
