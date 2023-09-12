#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> solution(vector<string> strings, int n) {
    vector<string> answer;
    for(int i=0;i<size(strings)-1;i++){
        for(int j=i+1;j<size(strings);j++){
            if(strings[i][n] > strings[j][n]){
                swap(strings[i], strings[j]);
            }
            else if(strings[i][n] == strings[j][n]){
                if(strings[i] > strings[j]){
                    swap(strings[i], strings[j]);
                }
            }
        }
    }
    answer = strings;
    return answer;
}