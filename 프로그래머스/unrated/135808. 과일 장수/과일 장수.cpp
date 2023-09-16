#include <string>
#include <vector>
//#include <cmath>
#include <algorithm>

using namespace std;

int solution(int k, int m, vector<int> score) {
    int answer = 0;
    sort(score.begin(), score.end());
    while(size(score) >= m){
        int min_v = 100;
        for(int i=0;i<m;i++){
            min_v = min(score[size(score)-1], min_v);
            score.erase(score.begin() + size(score)-1);
        }
        answer += min_v * m;
    }
    return answer;
}