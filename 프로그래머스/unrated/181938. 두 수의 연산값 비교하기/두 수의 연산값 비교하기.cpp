#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int answer = 0;
    string plus = to_string(a) + to_string(b);
    if(stoi(plus) >= 2*a*b) answer=stoi(plus);
    else answer=2*a*b;
    return answer;
}