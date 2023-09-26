#include <string>
#include <vector>
#include <cmath>
#include <numeric>

using namespace std;

int solution(vector<int> num_list) {
    int answer = 0;
    int mul=1;
    for(int i=0;i<size(num_list);i++){
        mul *= num_list[i];
    }
    (mul < pow(accumulate(num_list.begin(), num_list.end(),0),2)) ? answer=1 : answer=0;
    return answer;
}