import java.util.*;

class Solution {
    
    static int n, m;
    static int answer = 0;
    static List<String> visitString = new ArrayList<>();
    static boolean[] visit;
    
    public int solution(String[] user_id, String[] banned_id) {
        n = user_id.length;
        m = banned_id.length;
        
        visit = new boolean[n];
        
        findBannedId(user_id, banned_id, 0);
        
        
        return answer;
    }
    
    public void findBannedId(String[] user, String[] ban, int count) {
        if(count == m) {
            
            String s = "";
            for(int i = 0; i < n; i ++) {
                if(visit[i]) s += i;
            }
            
            for(String before : visitString) {
                if(s.equals(before)) return;
            }
            visitString.add(s);
            answer ++;
            return;
        }
        
        String b = ban[count];
        for(int i = 0; i < n; i ++) {
            String u = user[i];
            
            if(visit[i] || b.length() != u.length()) continue;
            
            boolean check = true;
            for(int j = 0; j < b.length(); j ++) {
                if(b.charAt(j) != '*' && b.charAt(j) != u.charAt(j)) {
                    check = false;
                    break;
                }
            }
            
            if(check) {
                visit[i] = true;
                findBannedId(user, ban, count + 1);
                visit[i] = false;
            }
        }
    }
}