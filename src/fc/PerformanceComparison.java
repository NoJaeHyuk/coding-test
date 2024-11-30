package fc;

import java.io.*;
import java.util.Scanner;

public class PerformanceComparison {
    public static void main(String[] args) throws IOException {
        // Generate test input (1 to 100,000)
        StringBuilder inputBuilder = new StringBuilder();
        for (int i = 1; i <= 100000; i++) {
            inputBuilder.append(i).append(" ");
        }
        String testInput = inputBuilder.toString();

        // Scanner simulation
        long scannerStartTime = System.currentTimeMillis();
        scannerSimulation(testInput);
        long scannerEndTime = System.currentTimeMillis();

        // BufferedReader simulation
        long bufferedReaderStartTime = System.currentTimeMillis();
        bufferedReaderSimulation(testInput);
        long bufferedReaderEndTime = System.currentTimeMillis();

        // Calculate and print performance results
        long scannerTime = scannerEndTime - scannerStartTime;
        long bufferedReaderTime = bufferedReaderEndTime - bufferedReaderStartTime;

        System.out.println("Scanner Time: " + scannerTime + " ms");
        System.out.println("BufferedReader Time: " + bufferedReaderTime + " ms");
    }

    // Simulate Scanner-style input processing
    private static void scannerSimulation(String input) {
        Scanner scanner = new Scanner(input);
        long sum = 0;
        while (scanner.hasNextInt()) {
            sum += scanner.nextInt();
        }
        scanner.close();
        System.out.println("Scanner Result: " + sum);
    }

    // Simulate BufferedReader-style input processing
    private static void bufferedReaderSimulation(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        String[] tokens = br.readLine().split(" ");
        long sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        br.close();
        System.out.println("BufferedReader Result: " + sum);
    }
}
