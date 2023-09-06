#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <cmath>
using namespace std;

string solution(string s) {
    string answer = "";
    int sign=1, i;
    vector<int> v;
    
    for(i=0;i<size(s);i++){
        if(s[i]!=' '){
            sign=1;
            vector<int> temp;
            if(s[i]=='-') {
                i+=1;
                sign=-1;
            }
            while(s[i]!=' '){
                temp.push_back(s[i]-'0');
                i++;
                if(s[i]==' ' || i>=size(s)) break;
            }
            int sum=0;
            for(int j=0;j<size(temp);j++){
                sum += temp[j] * pow(10, size(temp)-j-1);
            }
            sum*=sign;
            v.push_back(sum);
        }
    }
    sort(v.begin(), v.end());
    answer = to_string(v[0]) + " " + to_string(v[size(v)-1]);
    return answer;
}