import java.util.HashSet;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[][] rep = new int[id_list.length][id_list.length];

        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        for(String string : id_list) {
            map.put(string, index++);
        }
        
        for(int i=0; i<report.length; i++) {
            String[] one = report[i].split(" ");
            rep[map.get(one[0])][map.get(one[1])] = 1;
        }
        
        for(int i=0; i<id_list.length; i++) {
            int count = 0;
            for(int j=0; j<id_list.length; j++) {
                if(rep[j][i] == 1) {
                    count ++;
                }
            }
            if(count >= k) {
                for(int j=0; j<id_list.length; j++) {
                    if(rep[j][i] == 1) {
                        answer[j] ++;
                    }
                }   
            }
        }
        
        return answer;
    }
}