#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    for(int i=yellow; i>0 && size(answer)==0 ;i--){
        if(yellow % i == 0){
            if((i+2)*2 + 2*(yellow/i) == brown){
                answer.push_back(i+2);
                answer.push_back(yellow/i + 2);
            }
        }
    }
    return answer;
}