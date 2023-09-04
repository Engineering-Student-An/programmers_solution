#include <iostream>
#include <string>
#include <vector>

using namespace std;

double solution(vector<int> arr) {
    double answer = 0;
    for(int i=0;i<arr.size();i++){
        answer+=arr[i];
    }
    answer/=arr.size();
    return answer;
}

int main(void){
    vector<int> arr;
    string str;
    cin >> str;
    for(int i=0;i<str.size();i++){
        arr.push_back(str[i]-'0');
    }
    double ans = solution(arr);
    cout << ans;
}