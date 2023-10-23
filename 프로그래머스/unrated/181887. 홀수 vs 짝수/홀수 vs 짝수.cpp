#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int answer = 0;
    int sum1=0, sum2=0;
    for(int i=0;i<size(num_list);i++){
        if(i%2==0) sum1+=num_list[i];
        else sum2+=num_list[i];
    }
    (sum1 > sum2) ? answer=sum1 : answer=sum2;
    return answer;
}