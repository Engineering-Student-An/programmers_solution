#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

string solution(string X, string Y) {
    string answer = "";
    int arr_x[10]={0};
    int arr_y[10]={0};
    for(int i=0;i<size(X);i++) arr_x[X[i]-48]++;
    for(int i=0;i<size(Y);i++) arr_y[Y[i]-48]++;
    vector<int> s;
    for(int i=9;i>=0;i--){
        int m = min(arr_x[i], arr_y[i]);
        for(int j=0;j<m;j++){
            s.push_back(i);
        }
    }
    for(int i=0;i<size(s);i++){
        answer+=to_string(s[i]);
    }
    if(answer=="") answer="-1";
    if(answer[0]=='0') answer="0";
    return answer;
}