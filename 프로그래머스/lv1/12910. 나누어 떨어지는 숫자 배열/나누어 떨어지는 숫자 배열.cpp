#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr, int divisor) {
    vector<int> answer;
    for(int i=0; i<size(arr); i++){
        if(arr[i] % divisor == 0) answer.push_back(arr[i]);
    }
    if(size(answer)==0) answer.push_back(-1);
    sort(answer.begin(), answer.end());
    
    return answer;
}