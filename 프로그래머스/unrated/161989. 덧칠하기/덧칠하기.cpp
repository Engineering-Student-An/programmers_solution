#include <string>
#include <vector>

using namespace std;

int solution(int n, int m, vector<int> section) {
    int answer = 0;
    int check[100001] = {0};
    for(int i=0;i<size(section);i++){
        if(check[section[i]]==0) {
            answer++;
            for(int j=i;j<size(section) && section[j]<section[i]+m; j++){
                check[section[j]]=1;
            }
        }
    }
    return answer;
}