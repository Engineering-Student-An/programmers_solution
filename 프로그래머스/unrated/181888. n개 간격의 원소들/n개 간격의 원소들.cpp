#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list, int n) {
    vector<int> answer;
    for(int i=0;i<size(num_list);i+=n){
        answer.push_back(num_list[i]);
    }
    return answer;
}