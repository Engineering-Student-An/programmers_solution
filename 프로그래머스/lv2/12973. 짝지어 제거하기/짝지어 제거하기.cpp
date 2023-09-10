#include <stack>
#include <string>
#include <iostream>
using namespace std;

int solution(string s)
{
    int answer = -1;
    stack<char> arr;
    arr.push(s[0]);
    for(int i=1;i<size(s);i++){
        if(!arr.empty() && arr.top()==s[i]) arr.pop();
        else arr.push(s[i]);
    }
    return (arr.empty()) ? 1 : 0;
}