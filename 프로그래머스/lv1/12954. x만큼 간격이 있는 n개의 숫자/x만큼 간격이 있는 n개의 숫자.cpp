#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<long long> solution(int x, int n) {
    vector<long long> answer;
    for(int i=0; i<n; i++){
        answer.push_back(x + i*x);    
    }
    
    return answer;
}

int main(void){
    int x,n;
    cin >> x >> n;
    vector<long long> ans = solution(x,n);
    for(int i=0; i<ans.size(); i++){
        cout << ans[i] << ", ";
    }
}