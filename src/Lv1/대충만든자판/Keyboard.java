package Lv1.대충만든자판;

import java.util.HashMap;
import java.util.Map;

/**
 * -----제한사항-------
 *
 * 1 ≤ keymap의 길이 ≤ 100
 * 1 ≤ keymap의 원소의 길이 ≤ 100
 * keymap[i]는 i + 1번 키를 눌렀을 때 순서대로 바뀌는 문자를 의미합니다.
 * 예를 들어 keymap[0] = "ABACD" 인 경우 1번 키를 한 번 누르면 A, 두 번 누르면 B, 세 번 누르면 A 가 됩니다.
 * keymap의 원소의 길이는 서로 다를 수 있습니다.
 * keymap의 원소는 알파벳 대문자로만 이루어져 있습니다.
 * 1 ≤ targets의 길이 ≤ 100
 * 1 ≤ targets의 원소의 길이 ≤ 100
 * targets의 원소는 알파벳 대문자로만 이루어져 있습니다.
 * 각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return 하는 solution 함수를 완성해 주세요.
 */
public class Keyboard {

    private static int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char ch = keymap[i].charAt(j);
                // 맵에 해당 문자가 없으면 key:문자 value:인덱스
                if (!map.containsKey(ch)) {
                    map.put(ch, j+1);
                // key의 값이 현재 인덱스보다 크면 작은 값으로 변경
                } else {
                    if (map.get(ch) > j) {
                        map.put(ch, j+1);
                    }
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                char ch = targets[i].charAt(j);
                if (!map.containsKey(ch)) {
                    result[i] = -1;
                    break;
                } else {
                    result[i] += map.get(ch);
                }
            }
        }


        return result;
    }

    private static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        String[] keymap1 = {"ABACD", "BCEFD"};
        String[] keymap2 = {"AA"};
        String[] keymap3 = {"AGZ", "BSSS"};

        String[] targets1 = {"ABCD","AABB"};
        String[] targets2 = {"B"};
        String[] targets3 = {"ASA","BGZ"};

        print(solution(keymap1, targets1));
        print(solution(keymap2, targets2));
        print(solution(keymap3, targets3));

    }
}
