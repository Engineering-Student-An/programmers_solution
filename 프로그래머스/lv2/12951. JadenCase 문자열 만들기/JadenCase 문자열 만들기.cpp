#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string s) {
    string answer = "";
    for(int i=0;i<size(s);i++){
        string temp;
        while(true){
            if(s[i] == ' ' || i>=size(s)) break;
            temp += s[i];
            i++;
        }
        temp[0] = toupper(temp[0]);
        for(int i=1;i<size(temp);i++){
            temp[i] = tolower(temp[i]);
        }
        answer = answer + temp + " ";
    }
    answer.pop_back();
    if(s[size(s)-1] == ' ') answer += " ";
    return answer;
}