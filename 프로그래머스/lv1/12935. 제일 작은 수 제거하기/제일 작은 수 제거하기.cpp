#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    int minimum = arr[0];
    for(int i=0;i<size(arr);i++){
        minimum = min(minimum, arr[i]);
    }
    for(int i=0;i<size(arr);i++){
        if(arr[i]!=minimum) answer.push_back(arr[i]);
    }
    if(size(answer)==0) answer.push_back(-1);
    return answer;
}