#include <string>
#include <vector>

using namespace std;

int solution(vector<int> number) {
    int answer = 0;
    for(int i=0;i<size(number);i++){
        for(int j=i+1;j<size(number);j++){
            for(int k=j+1;k<size(number);k++){
                if(number[i] + number[j] + number[k] == 0) answer++;
            }
        }
    }
    return answer;
}