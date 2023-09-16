#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    vector<int> answer;
    for(int i=0;i<size(photo);i++){
        int sum = 0;
        for(int j=0;j<size(photo[i]);j++){
            for(int k=0;k<size(name);k++){
                if(photo[i][j] == name[k]) {
                    sum+= yearning[k];
                    break;
                }
            }
        }
        answer.push_back(sum);
    }
    return answer;
}