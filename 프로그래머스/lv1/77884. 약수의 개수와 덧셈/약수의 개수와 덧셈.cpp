#include <string>
#include <vector>

using namespace std;
int number(int n){
    int sum = 0;
    for(int i=1;i<=n;i++){
        if(n % i == 0) sum++;
    }
    return sum;
}
int solution(int left, int right) {
    int answer = 0;
    for(int i=left;i<=right;i++){
        if(number(i)%2==0) answer+=i;
        else answer-=i;
    }
    return answer;
}