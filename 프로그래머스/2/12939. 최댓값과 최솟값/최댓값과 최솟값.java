import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(c == ' ') {
                int index = 0;
                int sum = 0;
                while(!stack.isEmpty()) {
                    Integer n = stack.pop();
                    if(n != -1) sum += n * Math.pow(10, index ++);
                    else sum *= -1;
                }
                
                max = Math.max(max, sum);
                min = Math.min(min, sum);
            } else {
                stack.push((c != '-') ? (c - '0') : -1);
            }
        }
        
        int index = 0;
        int sum = 0;
        while(!stack.isEmpty()) {
            Integer n = stack.pop();
            if(n != -1) sum += n * Math.pow(10, index ++);
            else sum *= -1;
        }

        max = Math.max(max, sum);
        min = Math.min(min, sum);
        
        answer = min + " " + max;
        
        return answer;
    }
}