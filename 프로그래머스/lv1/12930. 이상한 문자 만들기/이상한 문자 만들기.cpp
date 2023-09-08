#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    int chk=0;
    for(int i=0;i<size(s);i++){
        if(chk%2==0) s[i]=toupper(s[i]);
        else s[i]=tolower(s[i]);
        chk++;
        if(s[i]==' ') chk=0;
    }
    answer = s;
    return answer;
}