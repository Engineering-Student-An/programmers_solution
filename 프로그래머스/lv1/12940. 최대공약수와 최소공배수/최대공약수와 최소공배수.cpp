#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, int m) {
    vector<int> answer;
    int maxx;
    for(int i=1;i<=min(n,m);i++){
        if(n%i ==0 && m%i==0) maxx=i;
    }
    int minn = maxx * (n/maxx) * (m/maxx);
    answer.push_back(maxx);
    answer.push_back(minn);
    return answer;
}