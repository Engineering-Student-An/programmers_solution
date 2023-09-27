#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    for(int i=0;i<size(queries);i++){
        int indi = queries[i][0];
        int indj = queries[i][1];
        swap(arr[indi], arr[indj]);
    }
    return arr;
}