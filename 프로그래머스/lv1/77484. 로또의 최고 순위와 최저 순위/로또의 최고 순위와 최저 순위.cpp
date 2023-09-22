#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    int high=0, low=0, zero=0;
    for(int i=0;i<size(lottos);i++){
        if(lottos[i]==0){
            zero++;
            continue;
        }
        for(int j=0;j<size(win_nums);j++){
            if(lottos[i] == win_nums[j]){
                high++;
                low++;
            }
        }
    }
    high+=zero;
    (high!=0) ? answer.push_back(7-high) : answer.push_back(6);
    (low!=0) ? answer.push_back(7-low) : answer.push_back(6);
    return answer;
}