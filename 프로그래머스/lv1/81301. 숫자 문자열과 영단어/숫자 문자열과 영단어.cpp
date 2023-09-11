#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(string s) {
    long long answer = 0;
    vector<int> arr;
    string alph[10] = {"zero", "one", "two", "three", "four",
                     "five", "six", "seven", "eight", "nine"};
    int alph_ind[10] = {4, 3, 3, 5, 4, 4, 3, 5, 5, 4};
    int index = 0;
    while(index<size(s)){
        if(s[index]>='0' && s[index]<='9') {
            arr.push_back(s[index]-'0'); index+=1;
        }
        else{   // 영단어 검사
            for(int i=0;i<10;i++){
                bool chk=true;
                for(int j=0;j<size(alph[i]);j++){
                    if(s[index+j] != alph[i][j]){
                        chk = false;
                        break;
                    }
                }
                if(chk == true){
                    arr.push_back(i);
                    index+=alph_ind[i];
                    break;
                }
            }
        }
    }
    for(int i=0;i<size(arr);i++) {
        answer += arr[i] * pow(10,size(arr)-i-1);
    }
    return answer;
}