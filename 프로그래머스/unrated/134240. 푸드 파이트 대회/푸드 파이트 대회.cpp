#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<int> food) {
    string answer = "";
    string ans1 = "", ans2="";

    for(int i=1;i<size(food);i++){
        if(food[i]%2!=0) food[i]--;
        food[i]/=2;
    }
    for(int i=1;i<size(food);i++){
        for(int j=0;j<food[i];j++){
            ans1 += i + '0';
        }
    }
    ans2 = ans1;
    reverse(ans2.begin(), ans2.end());
    answer = ans1 + '0' + ans2;
    return answer;
}