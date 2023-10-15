#include <string>
#include <vector>

using namespace std;

string solution(string my_string, vector<int> indices) {
    string answer = "";
    int arr[101] = {0};
    for(int i=0;i<size(indices);i++){
        arr[indices[i]]=1;
    }
    for(int i=0;i<size(my_string);i++){
        if(arr[i]==0) answer+=my_string[i];
    }
    return answer;
}