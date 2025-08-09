import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIndex = A.length - 1, bIndex = A.length - 1;
        while(aIndex >= 0) {
            if(A[aIndex] < B[bIndex]) {
                bIndex --;
                answer ++;
            }
            aIndex --;
        }
        
        
        return answer;
    }
}
    
    