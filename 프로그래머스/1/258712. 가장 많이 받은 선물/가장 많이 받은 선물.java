import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int ind = 0;
        for(String string : friends) {
            map.put(string, ind++);
        }
        
        int[] index = new int[friends.length];
        int[][] send = new int[friends.length][friends.length];
        for(int i = 0; i < gifts.length; i++) {
            String[] g = gifts[i].split(" ");
            send[map.get(g[0])][map.get(g[1])] ++;
        }
        
        for (int i = 0; i < friends.length; i++) {
            int give = 0;
            int receive = 0;
            for(int j = 0; j < friends.length; j++) {
                give += send[i][j];
                receive += send[j][i];
            }
            index[i] = (give - receive);
        }
        
        int[] nextWeek = new int[friends.length];
        for(int i = 0; i < friends.length; i++) {
            for(int j = i+1; j < friends.length; j++) {
                if(send[i][j] > send[j][i]) {
                    nextWeek[i] ++;
                } else if(send[i][j] < send[j][i]) {
                    nextWeek[j] ++;
                } else {
                    if(index[i]>index[j]) {
                        nextWeek[i] ++;
                    } else if(index[i]<index[j]) {
                        nextWeek[j] ++;
                    }
                    
                }
            }
        }
        
        Arrays.sort(nextWeek);
        answer = nextWeek[friends.length-1];
        
        return answer;
    }
}