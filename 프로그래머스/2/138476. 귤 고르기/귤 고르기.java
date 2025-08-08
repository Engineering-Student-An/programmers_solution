import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i ++) {
            int n = tangerine[i];
            if(map.get(n) == null) map.put(n, 1);
            else map.replace(n, map.get(n) + 1);
        }
        
        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.count, o1.count));
        for(Integer i : map.keySet()) {
            queue.add(new Info(i, map.get(i)));
        }
        
        while(!queue.isEmpty() && k > 0) {
            Info now = queue.poll();
            
            k -= now.count;
            answer ++;
        }
        return answer;
    }
    
    static class Info {
        int num, count;
        
        public Info (int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}