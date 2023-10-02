#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> stk;
    int i=0;
    while(i<size(arr)){
        if(stk.empty()==true) {
            stk.push_back(arr[i]);
            i++;
            continue;
        }
        else{
            if(stk[size(stk)-1] < arr[i]) {
                stk.push_back(arr[i]);
                i++;
            }
            else stk.erase(stk.end()-1);
        }
    }
    return stk;
}