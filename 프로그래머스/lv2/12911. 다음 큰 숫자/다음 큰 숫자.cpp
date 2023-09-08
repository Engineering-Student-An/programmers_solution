#include <string>
#include <vector>
#include <algorithm>
using namespace std;

string to_binary(int n){
    string bin;
    while(n!=0){
        (n%2 == 0) ? bin+='0' : bin+='1';
        n/=2;
    }
    reverse(bin.begin(), bin.end());
    return bin;
}
int check(string str){
   int one=0;
    for(int i=0;i<size(str);i++){
        if(str[i]=='1') one++;
    }
    return one;
}

int solution(int n) {
    int answer = n+1;
    int init_one = check(to_binary(n));
    
    while(1){
        if(init_one == check(to_binary(answer))){
            break;
        }
        answer++;
    }
    return answer;
}