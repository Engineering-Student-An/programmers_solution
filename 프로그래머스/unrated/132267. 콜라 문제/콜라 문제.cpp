#include <string>
#include <vector>

using namespace std;

int solution(int a, int b, int n) {
    int answer = 0;
    while(n>=a){
        if(n < 2) break;
        int get = 0, bring=0;
        for(int i=n; i>0; i--){
            if(i % a == 0){
                bring = i;
                get = i / a * b;
                break;
            }
        }
        answer += get;
        n = n - bring + get;
    }
    return answer;
}