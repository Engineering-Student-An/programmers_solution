#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    // 첫번째 사람 검사 => 한글자
    if(size(words[0])==1) {
        answer.push_back(1); answer.push_back(1);
        return answer;
    }
    
    // 나머지 검사
    int index=-1;
    bool chk=false;
    for(int i=1;i<size(words);i++){
        
        // 끝말잇기 검사
        if(words[i-1][size(words[i-1])-1] != words[i][0]){
            index=i;
            break;
        }
        // 중복 검사
        for(int j=0;j<i;j++){
            if(words[i]==words[j]){
                index = i;
                chk = true;
                cout << i << chk;
                break;
            }
        }
        if(chk==true) break;
    }
    if(index == -1){
        answer.push_back(0); answer.push_back(0);
        return answer;
    }
    answer.push_back(index%n + 1);
    answer.push_back(index/n + 1);
    return answer;
}