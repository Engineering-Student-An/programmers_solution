#include <string>
#include <vector>

using namespace std;

bool solution(string s) {
    bool answer = true;
    if(size(s) != 4 && size(s)!=6) return false;
    for(int i=0;i<size(s);i++){
        if(s[i]<'0' || s[i]>'9'){
            answer=false;
            break;
        }
    }
    return answer;
}