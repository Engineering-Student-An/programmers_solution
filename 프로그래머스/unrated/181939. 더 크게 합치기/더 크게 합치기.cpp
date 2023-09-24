#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int answer = 0;
    string one=to_string(a)+to_string(b)
        ,two=to_string(b)+to_string(a);
    int ia = stoi(one);
    int ib = stoi(two);
    if(ia>ib) answer = ia;
    else answer=ib;
    return answer;
}