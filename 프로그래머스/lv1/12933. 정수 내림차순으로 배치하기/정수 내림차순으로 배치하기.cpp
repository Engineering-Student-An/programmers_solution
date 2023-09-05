#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

long long solution(long long n) {
    long long answer = 0;
    string str = to_string(n);
    vector<int> arr;
    
    for(int i=0;i<size(str);i++){
        arr.push_back(str[i]-'0');
    }
    sort(arr.begin(),arr.end());
    for(int i=0; i<size(arr); i++){
        answer+=arr[i]*pow(10,i);
    }
    return answer;
}