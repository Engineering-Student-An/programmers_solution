import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        
        if(n > s) {
            answer = new int[]{-1};
        } else {
            answer = new int[n];
            int count = n;
            for(int i = 0; i < n; i ++) {
                answer[i] = (s % count > 0) ? s/count + 1 : s/count;
                s -= answer[i];
                count --;
            }
            
            Arrays.sort(answer);
        }
        
        
        return answer;
    }
}