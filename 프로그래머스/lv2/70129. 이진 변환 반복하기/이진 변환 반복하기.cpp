#include <string>
#include <vector>
#include <algorithm>
using namespace std;

string to_binary(int n){
    string bin;
    while(n!=0){
        (n%2 == 0) ? bin+="0" : bin+="1";
        n/=2;
    }
    reverse(bin.begin(), bin.end()); 
    return bin;
}
vector<int> solution(string s) {
    vector<int> answer(2,0);
    int zero, one;
    
    while(1){
        zero = one = 0;
        for(int i=0;i<size(s);i++){
            (s[i]=='0') ? zero+=1 : one+=1;
        }
        if(one == 1 && zero==0) break;
        answer[1]+=zero;
        answer[0]++;
        s = to_binary(one);
    }
    return answer;
}