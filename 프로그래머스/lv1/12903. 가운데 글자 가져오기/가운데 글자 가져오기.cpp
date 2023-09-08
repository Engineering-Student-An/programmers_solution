#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    if(size(s) % 2 == 0){
        answer += s[(size(s)/2) - 1];
        answer += s[(size(s)/2)];
    }
    else answer += s[size(s)/2];
    return answer;
}