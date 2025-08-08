import java.util.*;

class Solution {
    
    static int n;
    static int[] result;
    static List<Integer>[] adjacencyList;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        n = words.length;
        adjacencyList = new ArrayList[n];
        
        int e = -1;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            adjacencyList[i] = new ArrayList<>();
            
            if(target.equals(words[i])) e = i;
            
            int diff = 0;
            for(int j = 0; j < words[i].length(); j ++) {
                if(begin.charAt(j) != words[i].charAt(j)) {
                    diff ++;
                }
                
                if(diff > 1) break;
            }
            
            if(diff == 1) list.add(i);
        }
        
        if(e != -1) {
            for(int i = 0; i < n; i ++) {
                for(int j = i + 1; j < n; j ++) {
                    int diff = 0;
                    for(int k = 0; k < words[i].length(); k ++) {
                        if(words[i].charAt(k) != words[j].charAt(k)) diff ++;
                        if(diff > 1) break;
                    }

                    if(diff == 1) {
                        adjacencyList[i].add(j);
                        adjacencyList[j].add(i);
                    }
                }
            }
            
            PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.count, o2.count));
            result = new int[n];
            for(int i = 0; i < n; i ++) {
                result[i] = Integer.MAX_VALUE;
            }
            
            for(Integer i : list) {
                result[i] = 1;
                queue.add(new Info(i, 1));
            }
            
            boolean isFound = false;
            while(!queue.isEmpty()) {
                Info now = queue.poll();
                
                if(result[now.index] < now.count) continue;
                
                for(Integer next : adjacencyList[now.index]) {
                    if(result[next] > result[now.index] + 1) {
                        result[next] = result[now.index] + 1;
                        
                        if(next == e) {
                            isFound = true;
                            break;
                        }
                        queue.add(new Info(next, result[next]));
                    }
                }
                if(isFound) break;
                
            }
            answer = result[e];
        }
            
        return answer;
    }
    
    static class Info {
        int index, count;
        
        public Info(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}