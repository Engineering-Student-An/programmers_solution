#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(int k, vector<int> score) {
    vector<int> answer;
    vector<int> arr;
    for(int i=0;i<size(score);i++){
        if(size(arr) < k) arr.push_back(score[i]);
        else{
            if(arr[0] < score[i]) arr[0] = score[i];
            
        }
        sort(arr.begin(), arr.end());
        answer.push_back(arr[0]);
    }
    return answer;
}