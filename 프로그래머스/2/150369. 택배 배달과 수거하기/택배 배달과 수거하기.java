import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        PriorityQueue<Info> del = new PriorityQueue<>();
        PriorityQueue<Info> pick = new PriorityQueue<>();
        
        for(int i = 0; i < deliveries.length; i ++) {
            if(deliveries[i] > 0) del.add(new Info((long) i + 1, deliveries[i]));
            if(pickups[i] > 0) pick.add(new Info((long) i + 1, pickups[i]));
        }
        
        while(true) {
            if(del.isEmpty() && pick.isEmpty()) break;
            
            int count = cap;
            long distance = 0;
            while(!del.isEmpty()) {
                Info info = del.poll();
                distance = Math.max(distance, info.n);
                
                if(count >= info.num) count -= info.num;
                else {
                    info.num -= count;
                    del.add(info);
                    count = 0;
                }
                
                if(count == 0) break;
            }
            count = 0;
            
            while(!pick.isEmpty()) {
                Info info = pick.poll();
                distance = Math.max(distance, info.n);
                
                if(cap - count >= info.num) count += info.num;
                else {
                    info.num -= cap - count;
                    pick.add(info);
                    count = cap;
                }
                
                if(count >= cap) break;
            }
            
            answer += distance * 2;
        }
        
        return answer;
    }
    
    public class Info implements Comparable <Info> {
        long n;
        int num;
        
        @Override
        public int compareTo(Info o) {
            return Long.compare(o.n, this.n);
        }
        
        public Info(long n, int num) {
            this.n = n;
            this.num = num;
        }
    }
}