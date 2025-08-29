import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        PriorityQueue<Info> queue = new PriorityQueue<>();
        for(int i = 0; i < routes.length; i ++) {
            queue.add(new Info(routes[i][0], routes[i][1]));
        }
        
        while(!queue.isEmpty()) {
            Info now = queue.poll();
            answer ++;
            
            List<Info> area = new ArrayList<>();
            area.add(now);
            
            while(!queue.isEmpty()) {
                Info next = queue.peek();
                
                boolean check = true;
                for(Info areaInfo : area) {
                    if(next.s > areaInfo.e) {
                        check = false;
                        break;
                    } 
                }
                
                if(check) area.add(queue.poll());
                else break;
            }
        }
        
        return answer;
    }
    
    public class Info implements Comparable<Info> {
        int s, e;
        
        public Info(int s, int e) {
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(Info o) {
            return (this.s - o.s);
        }
    }
}