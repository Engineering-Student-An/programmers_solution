#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> intStrs, int k, int s, int l) {
    vector<int> answer;
    for(int i=0;i<size(intStrs);i++){
        string temp;
        for(int j=s;j<s+l;j++){
            temp+=intStrs[i][j];
        }
        if(stoi(temp) > k) answer.push_back(stoi(temp));
    }
    return answer;
}