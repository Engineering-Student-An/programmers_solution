class Solution {
    
    static int n, m;
    static int[] percent, answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        n = users.length;
        m = emoticons.length;
        
        percent = new int[m];
        
        find(0, users, emoticons);
        
        return answer;
    }
    
    public void find(int index, int[][] users, int[] emoticons) {
        if(index == m) {
            int[] temp = calculate(users, emoticons);
            if(answer[0] < temp[0] || (answer[0] == temp[0] && answer[1] < temp[1])) {
                answer[0] = temp[0];
                answer[1] = temp[1];
            }
            
            return;
        }
        
        for(int p = 10; p <= 40; p += 10) {
            percent[index] = p;
            find(index + 1, users, emoticons);
        }        
    }
    
    public int[] calculate(int[][] users, int[] emoticons) {
        int[] result = new int[2];
        
        for(int i = 0; i < n; i ++) {
            int sum = 0;
            for(int j = 0; j < m; j ++) {
                if(percent[j] >= users[i][0]) {
                    sum += (emoticons[j] * (100 - percent[j]) / 100);
                }
            }
            
            if(sum >= users[i][1]) result[0] ++;
            else result[1] += sum;
        }
        
        return result;
    }
}