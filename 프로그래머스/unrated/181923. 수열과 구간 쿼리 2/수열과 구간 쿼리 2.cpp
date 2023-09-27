#include <string>
#include <vector>
#define INF 99999999
using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> answer;
    for(int i=0;i<size(queries);i++){
        int min = INF;
        for(int j=queries[i][0]; j<=queries[i][1]; j++){
            if(arr[j] > queries[i][2] && min>arr[j]) min = arr[j];
        }
        (min!=INF) ? answer.push_back(min) : answer.push_back(-1);
    }
    return answer;
}