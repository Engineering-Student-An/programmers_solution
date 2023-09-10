#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string s, int n) {
    string answer = "";
    for(int i=0;i<size(s);i++){
        if(s[i]==' ') answer+=' ';
        else if(s[i]>='A' && s[i]<='Z'){
            (s[i]+n > 'Z') ? answer+=s[i]+n-26 : answer += s[i]+n ;
        }
        else if(s[i]>='a' && s[i]<='z'){
            (s[i]+n > 'z') ? answer+=s[i]+n-26 : answer += s[i]+n;
        }
    }
    return answer;
}