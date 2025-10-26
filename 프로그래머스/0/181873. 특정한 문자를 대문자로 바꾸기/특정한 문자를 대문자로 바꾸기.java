class Solution {
    public String solution(String my_string, String alp) {
        String up = alp.toUpperCase();
        String answer = my_string.replace(alp.charAt(0), up.charAt(0));   
        return answer;
    }
}