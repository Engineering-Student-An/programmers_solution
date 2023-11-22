#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(string my_string) {
    vector<int> answer;
    for(int i=0;i<52;i++){
        answer.push_back(0);
    }
    for(int i=0;i<size(my_string);i++){
        if(my_string[i]>='A' && my_string[i]<='Z') answer[my_string[i]-'A']++;
        else answer[my_string[i]-'a' + 26]++;        
    }
    return answer;
}