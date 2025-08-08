import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        
        int n = triangle.length;
        int[][] arr = new int[n][n];
        
        arr[0][0] = triangle[0][0];
        for(int i = 1; i < n; i ++) {
            arr[i][0] = arr[i-1][0] + triangle[i][0];
            for(int j = 1; j <= i; j ++) {
                arr[i][j] = Math.max(arr[i-1][j-1], arr[i-1][j]) + triangle[i][j];
            }
        }
        
        for(int i = 0; i < n; i ++) {
            answer = Math.max(answer, arr[n-1][i]);
        }
        
        return answer;
    }
}