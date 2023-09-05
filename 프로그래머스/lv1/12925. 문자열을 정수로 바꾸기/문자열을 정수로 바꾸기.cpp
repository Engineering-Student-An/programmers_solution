#include <string>
#include <vector>
#include <cmath>
using namespace std;

int solution(string s) {
    int answer = 0;
    int start = 0;
    if(s[0]=='-' || s[0]=='+') start=1;
    for(int i=start; i<s.size(); i++){
        answer += (s[i]-'0') * pow(10,s.size()-i-1);
    }
    if(s[0]=='-') answer*=-1;
    return answer;
}