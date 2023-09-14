#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    int alp[26]={0};
    int index[26]={0};
    for(int i=0;i<size(s);i++){
        if(alp[s[i]-'a'] == 0) answer.push_back(-1);
        else answer.push_back(i-index[s[i]-'a']);
        index[s[i]-'a']=i;
        alp[s[i]-'a']=1;
    }
    return answer;
}