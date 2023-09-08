#include <string>
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    stack<int> arr;
    for(int i=0;i<size(s);i++){
        if(s[i]=='(') arr.push(1);
        else if(!arr.empty()) arr.pop();
        else{
            answer=false;
            break;
        }
    }
    if(size(arr)!=0) answer=false;
    return answer;
}