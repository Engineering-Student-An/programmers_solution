import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 1️⃣ 전체 보석 종류 개수
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int total = gemTypes.size();

        // 2️⃣ 현재 구간 내 보석 개수를 저장할 맵
        Map<String, Integer> map = new HashMap<>();

        int start = 0, end = 0;
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];

        // 3️⃣ 슬라이딩 윈도우 이동
        while (true) {
            // 조건 만족하지 않으면 end 확장
            if (map.size() < total && end < gems.length) {
                map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
                end++;
            }
            // 모든 종류 포함 시 start 줄이기
            else if (map.size() == total) {
                // 현재 구간이 더 짧으면 갱신
                if (end - start < minLength) {
                    minLength = end - start;
                    answer[0] = start + 1; // 진열대 번호는 1부터 시작
                    answer[1] = end;
                }

                // start 이동 (왼쪽 줄이기)
                String leftGem = gems[start];
                map.put(leftGem, map.get(leftGem) - 1);
                if (map.get(leftGem) == 0) map.remove(leftGem);
                start++;
            }
            // end가 끝까지 갔고 더 이상 줄일 수 없으면 종료
            else break;
        }

        return answer;
    }
}
