class Solution {
    public int solution(int[][] dots) {
        if(check(dots, 0, 1, 2, 3)) {
            return 1;
        }
        if(check(dots, 0, 2, 1, 3)) {
            return 1;
        }
        if(check(dots, 0, 3, 1, 2)) {
            return 1;
        }
        return 0;
    }
    
    public boolean check(int[][] dots, int f1, int f2, int s1, int s2) {
        
        if( (double)(dots[f1][0]-dots[f2][0]) / (dots[f1][1]-dots[f2][1]) 
           == (double)(dots[s1][0]-dots[s2][0]) / (dots[s1][1]-dots[s2][1]) ) return true;
        else return false;
    }
}