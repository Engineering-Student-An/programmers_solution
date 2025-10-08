import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i ++) {
            String[] lines = terms[i].split(" ");
            
            map.put(lines[0].charAt(0), Integer.parseInt(lines[1]) * 28);
        }
        
        String[] s = today.split("\\.");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]) + year * 12;
        int day = Integer.parseInt(s[2]) + month * 28;
        
        for(int i = 0; i < privacies.length; i ++) {
            
            String[] strings = privacies[i].split(" ");
            char c = strings[1].charAt(0);
            
            String[] line = strings[0].split("\\.");
            int y = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]) + y * 12;
            int d = Integer.parseInt(line[2]) + m * 28;
            
            if(day - d >= map.get(c)) result.add(i + 1);
        }
        
        
        int[] answer = new int[result.size()];
        int index = 0;
        for(Integer i : result) {
            answer[index ++] = i;
        }
        return answer;
    }
}