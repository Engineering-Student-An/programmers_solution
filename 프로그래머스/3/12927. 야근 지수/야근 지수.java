import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        
        for(int i = 0; i < works.length; i ++) {
            queue.add(works[i]);
        }
        
        while(!queue.isEmpty() && n > 0) {
            Integer now = queue.poll();
            if(now > 1) queue.add(now - 1);
            
            n --;
        }
        
        while(!queue.isEmpty()) {
            answer += Math.pow(queue.poll(), 2);
        }
        return answer;
    }
}