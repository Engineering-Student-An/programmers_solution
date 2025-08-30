class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        while(true) {
            answer ++;
            
            if(b % 2 == 0 && a == b-1) {
                break;
            }
            
            b = (b%2 == 0) ? b/2 : b/2 + 1;
            a = (a%2 == 0) ? a/2 : a/2 + 1;
        }

        return answer;
    }
}