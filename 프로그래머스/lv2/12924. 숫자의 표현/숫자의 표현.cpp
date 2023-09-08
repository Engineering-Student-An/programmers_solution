#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int sum=0;
    for(int i=1;i<=n;i++){
        int j=i;
        sum=0;
        while(1){
            sum+=j;
            if(sum>=n) break;
            j++;
        }
        if(sum==n) answer++;
    }
    return answer;
}