package Lv2.오픈채팅방;

import java.util.*;

/**
 *  - 문제풀이 -
 *  1. record는 [Enter,Leave,Change] [uid] [nickname] 으로 둘어온다.
 *  2. Enter일 경우 HashMap에 uid와 nickname의 정보를 넣어주고, Change일 경우 Map을 update 해준다.
 *  3. Enter과 Leave의 경우 list에 순서대로 기록을 남긴다.
 *  4. 최종적인 nickname으로 Enter와 Leave 경우에 따라 출력
 *
 * */

public class OpenChat {

    private static String[] solution(String[] record) {

        String[] result;

        Map<String, String> map = new HashMap<>();  // 유저 아이디와 이름 담을 맵
        List<String[]> list = new ArrayList<>();   // 순서대로 출력할 유저아이디 list

        for (int i = 0; i < record.length; i++) {
            String[] sRecord = record[i].split(" ");

            String visit = sRecord[0];
            String uid = sRecord[1];

            if (visit.equals("Enter")) {
                String name = sRecord[2];
                map.put(uid, name);
                list.add(new String[]{visit, uid});

            } else if (visit.equals("Leave")) {
                list.add(new String[]{visit, uid});

            } else if (visit.equals("Change")) {
                String name = sRecord[2];
                map.put(uid, name);
            }
        }

        result = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {

            StringBuilder sb = new StringBuilder();

            String visit = list.get(i)[0];
            String uid = list.get(i)[1];

            sb.append(map.get(uid));

            if (visit.equals("Enter")) {
                sb.append("님이 들어왔습니다.");
            } else if (visit.equals("Leave")) {
                sb.append("님이 나갔습니다.");
            }

            result[i] = sb.toString();
        }

        return result;
    }

    private static void print(String[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                            "Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        print(solution(record));

    }

}
