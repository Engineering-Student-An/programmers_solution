#include <string>
#include <vector>
#include <iostream>
#include <cmath>
using namespace std;

int solution(string t, string p) {
    int answer = 0;
    long long int_p=0;
    if(size(p) > 18) return 0;
    // p : string -> int
    for(int i=0; i<size(p); i++){
        int_p += (p[i]-'0') * pow(10, size(p)-i-1);
    }
    // checking t
    long long int_t=0;
    for(int i=0;i<=size(t)-size(p);i++){
        int_t=0;
        for(int j=i;j<i+size(p);j++){
            int_t += (t[j]-'0') * pow(10, size(p)-(j-i)-1);
        }
        if(int_t <= int_p) answer++;
    }
    return answer;
}