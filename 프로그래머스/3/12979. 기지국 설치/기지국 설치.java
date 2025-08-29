class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int left = 1;
        int right = 1;
        int coverDistance = w * 2 + 1;
        for(int i = 0; i < stations.length; i ++) {
            right = stations[i] - w - 1;
            
            int distance = right - left + 1;
            left = stations[i] + w + 1;
            if(distance <= 0) continue;
            
            answer += (distance % coverDistance == 0) ? distance / coverDistance : distance / coverDistance + 1;
            
        }

        if(left <= n) {
            int distance = n - left + 1;
            answer += (distance % coverDistance == 0) ? distance / coverDistance : distance / coverDistance + 1;
        }
        return answer;
    }
}