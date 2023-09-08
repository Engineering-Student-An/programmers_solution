#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    int num=999;
    for(int i=0;i<size(arr);i++){
        if(arr[i]!=num){
            num=arr[i];
            answer.push_back(num);
        }
    }
    return answer;
}