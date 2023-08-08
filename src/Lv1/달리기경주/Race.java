package Lv1.달리기경주;

import java.util.HashMap;
import java.util.Map;

public class Race {

    private static String[] solution(String[] players, String[] callings) {

        Map<String, Integer> playersMap = new HashMap<>();
        Map<Integer, String> rankMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playersMap.put(players[i], i + 1);
            rankMap.put(i + 1, players[i]);
        }

        for (int i = 0; i < callings.length; i++) {
            String callPlayer = callings[i];            // 불린선수이름
            int callRank = playersMap.get(callings[i]); // 불린선수순위

            String frontPlayer = rankMap.get(callRank - 1); // 앞선선수
            int frontRank = callRank - 1;                   // 앞선선수순위

            playersMap.put(callPlayer, frontRank);
            playersMap.put(frontPlayer, callRank);

            rankMap.put(callRank, frontPlayer);
            rankMap.put(frontRank, callPlayer);

        }

        for (int i = 0; i < rankMap.size(); i++) {
            players[i] = rankMap.get(i + 1);
        }

        return players;
    }

    private static StringBuilder sb = new StringBuilder();

    private static void print(String[] result) {
        sb.append("result ==== > ");
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }
        sb.append("\n");
        System.out.println(sb);
    }

    public static void main(String[] args) {

        String[] result;

        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        result = solution(players, callings);

        print(result);


    }


}
