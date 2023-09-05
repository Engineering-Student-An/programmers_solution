#include <string>
#include <vector>
#include <cmath>
using namespace std;

long long solution(long long n) {
    long long answer = 0;
    double sq = sqrt(n);
    if(sq - int(sq) == 0) {
        answer = int(sq) + 1;
        answer = pow(answer,2);
    }
    else answer = -1;
    return answer;
}