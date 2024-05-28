package Lv1.데이터분석;

/**
 *
 *   문제풀이
 *   데이터는 ["코드 번호(code)", "제조일(date)", "최대 수량(maximum)", "현재 수량(remain)"]으로 구성되어 있으며 현식이는 이 데이터들 중 조건을 만족하는 데이터만 뽑아서 정렬하려 합니다.
 *   data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후, sort_by에 해당하는 값을 기준으로 오름차순으로 정렬하여 return 하도록 solution 함수를 완성해 주세요.
 *   단, 조건을 만족하는 데이터는 항상 한 개 이상 존재합니다.
 *
 *   1. ext 값이 val_ext보다 작은 데이터를 제외하고 List에 담기
 *   2. List를 order_by 기준으로 정렬
 *
 * */

import java.util.*;

public class DataAnalyze {

    private static List<List<Integer>> solution(int[][] data, String ext, int val_ext, String sort_by) {

        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String[] col = {"code", "date", "maximum", "remain"};

        for (int i = 0; i < col.length; i++) {
            map.put(col[i], i);
        }

        for (int i = 0; i < data.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < data[i].length; j++) {
                list.add(data[i][j]);
            }
            if (list.get(map.get(ext)) < val_ext) {
                result.add(list);
            }
        }

        Collections.sort(result, (o1, o2) -> o1.get(map.get(sort_by)) - o2.get(map.get(sort_by)));

        return result;
    }

    public static void main(String[] args) {

        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";

        System.out.println(solution(data, ext, val_ext, sort_by));

    }

}
