class Solution {
    public int solution(int hp) {
        int first = hp/5;
        hp%=5;
        int second = hp/3;
        hp%=3;
        
        return (first + second + hp);

    }
}