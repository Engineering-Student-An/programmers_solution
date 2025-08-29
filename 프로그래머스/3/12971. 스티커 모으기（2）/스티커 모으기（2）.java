import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer;
        int n = sticker.length;

        if(n == 1) return sticker[0];
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        int[][] result = new int[2][n]; // 0행 : x, 1행 : o
        
        // 1. 첫번째 o
        result[0][0] = Integer.MIN_VALUE;
        result[1][0] = sticker[0];
        for(int i = 1; i < n; i ++) {
            result[0][i] = Math.max(result[0][i-1], result[1][i-1]);
            result[1][i] = result[0][i-1] + sticker[i];
        }
        answer = result[0][n-1];
        
        // 2. 첫번째 x
        result = new int[2][n];
        result[1][0] = Integer.MIN_VALUE;
        for(int i = 1; i < n; i ++) {
            result[0][i] = Math.max(result[0][i-1], result[1][i-1]);
            result[1][i] = result[0][i-1] + sticker[i];
        }
        
        answer = Math.max(answer, Math.max(result[0][n-1], result[1][n-1]));
        
        return answer;
    }
}

/*
    14  6   5   11  3   9   2   10
x   0   14  14  19  25  25  34  
o   14  6   19  25  22  34  36

        14  6   5   11  3   9   2   10
   x    -   14  14  19  25  25  34  34
(0) 뜯  14   -   19  25  22  34  27  -
        

(0) x   0   0   6   6   17  17  26  26
o       -   6   5   17  9   26  19  36
*/