#include <iostream>
#include <cmath>

using namespace std;

int solution(int n)
{
    int answer = 0;
    for(int i=8;i>=0;i--){
        int e = pow(10,i);
        answer += n / e;
        n = n % e;
    }
    return answer;
}

int main(void){
    int n;
    cin >> n;
    int ans = solution(n);
    cout << ans;
}