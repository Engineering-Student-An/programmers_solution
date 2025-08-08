import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        parent = new int[n];
        for(int i = 0; i < n; i ++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                if(i != j && computers[i][j] == 1 && find(i) != find(j)) {
                    union(i, j);                  
                }            
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            find(i);
            if(!list.contains(parent[i])) {
                list.add(parent[i]);
                answer ++;
            }
        }
        
        
        
        return answer;
    }
    
    static int find(int a) {
        if(a == parent[a]) return a;
        
        return parent[a] = find(parent[a]);
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a != b) {
            parent[Math.max(a, b)] = Math.min(a, b);
        }
    }
}