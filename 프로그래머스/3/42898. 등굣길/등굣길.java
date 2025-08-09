class Solution {
    public long solution(int m, int n, int[][] puddles) {
        long answer = 0;
        final long mod = 1000000007;
        boolean[][] water = new boolean[n][m];
        for(int i = 0; i < puddles.length; i ++) {
            water[puddles[i][1] - 1][puddles[i][0] - 1] = true;
        }
        
        long[][] result = new long[n][m];
        result[0][0] = 1;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(!water[i][j]) {
                    if(i - 1 >= 0) result[i][j] += result[i-1][j];
                    if(j - 1 >= 0) result[i][j] += result[i][j-1];
                    result[i][j] %= mod;
                }        
            }
        }
        
        answer = result[n-1][m-1] % mod;
        return answer;
    }
}