#include <string>
#include <vector>

using namespace std;

bool check(string s){
    string possible[5] = {"", "aya", "ye", "woo", "ma"};
    for(int i=0; i<5;i++){
        for(int j=0;j<5;j++){
            for(int k=0;k<5;k++){
                for(int l=0;l<5;l++){
                    if(s==possible[i]+possible[j]+possible[k]+possible[l]) return true;
                }
            }
        }
    }
    return false;
}

int solution(vector<string> babbling) {
    int answer = 0;
    for(int i=0;i<size(babbling);i++){
        (check(babbling[i])) ? answer+=1 : answer=answer;
        
    }
    return answer;
}