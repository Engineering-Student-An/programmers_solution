#include <string>
#include <vector>

using namespace std;

bool solution(bool x1, bool x2, bool x3, bool x4) {
    bool answer = false;
    bool a1=true, a2=true;
    if(x1==false && x2==false) a1=false;
    if(x3==false && x4==false) a2=false;
    if(a1==true && a2==true) answer=true;
    return answer;
}