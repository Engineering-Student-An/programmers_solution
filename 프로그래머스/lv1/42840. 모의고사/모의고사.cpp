#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int ans1[] = {1,2,3,4,5};           // 0 ~ 4
    int ans2[] = {2,1,2,3,2,4,2,5};     // 0 ~ 7
    int ans3[] = {3,3,1,1,2,2,4,4,5,5}; // 0 ~ 9
    int sum1 = 0, sum2 = 0, sum3 = 0;
    for(int i=0;i<size(answers);i++){
        if(ans1[i%5] == answers[i]) sum1++;
        if(ans2[i%8] == answers[i]) sum2++;
        if(ans3[i%10] == answers[i]) sum3++;
    }
    int max_v = max(sum1, sum2);
    max_v = max(max_v, sum3);
    if(max_v == sum1) answer.push_back(1);
    if(max_v == sum2) answer.push_back(2);
    if(max_v == sum3) answer.push_back(3);
    return answer;
}