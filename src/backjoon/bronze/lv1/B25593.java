package backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class B25593 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                String[] employees = br.readLine().split(" ", 7);
                int hour = getWorkPeriodHours(j); // 근무시간 대 별 근무시간
                updateEmployeeWorkHours(map, employees, hour); // 근무자별 근무 시간 합산
            }
        }

        if (map.isEmpty()) {
            System.out.println("Yes");
            return;
        }

        // 최대값 구하기
        Integer max = Collections.max(map.values());
        // 최소값 구하기
        Integer min = Collections.min(map.values());

        if (max - min > 12) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    // 근무자별 근무시간 합산
    private static void updateEmployeeWorkHours(Map<String, Integer> map, String[] employees, int hour) {
        for (String employee : employees) {
            if (!employee.equals("-")) {
                map.put(employee, map.getOrDefault(employee, 0) + hour);
            }
        }
    }

    // 근무시간 대 별 근무시간
    private static int getWorkPeriodHours(int row) {
        switch (row) {
            case 0:
            case 2:
                return 4;
            case 1:
                return 6;
            default:
                return 10;
        }
    }
}
