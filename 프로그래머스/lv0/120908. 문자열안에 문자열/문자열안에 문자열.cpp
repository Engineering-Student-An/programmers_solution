#include <string>
#include <vector>

using namespace std;

int solution(string str1, string str2) {
    int answer = 2;
    if(str1.find(str2) < size(str1)) answer=1;
    return answer;
}