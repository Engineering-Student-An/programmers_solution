#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string my_string, string is_prefix) {
    int answer = 0;
    for(int i=0;i<size(my_string);i++){
        string tmp="";
        for(int j=0;j<size(my_string)-i;j++){
            tmp+=my_string[j];
        }
        if(tmp==is_prefix) return 1;
    }
    return answer;
}