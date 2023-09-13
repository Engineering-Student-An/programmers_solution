#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int sort_result(vector<int> array, int start, int end, int n){
    vector<int> a;
    for(int i=start-1;i<end;i++){
        a.push_back(array[i]);
    }
    sort(a.begin(), a.end());
    return a[n-1];
}

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    for(int i=0;i<size(commands);i++){
        answer.push_back(sort_result(array, commands[i][0], commands[i][1], commands[i][2]));
    }
    return answer;
}