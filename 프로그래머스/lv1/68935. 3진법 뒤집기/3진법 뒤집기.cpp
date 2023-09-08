#include <string>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

int solution(int n) {
    int answer = 0;
    string tri;
    while(n!=0){
        tri += (n%3) + '0';
        n/=3;
    }
    reverse(tri.begin(), tri.end());
    for(int i=0;i<size(tri);i++){
        answer+=(tri[i]-'0') * pow(3, i);
    }
    return answer;
}