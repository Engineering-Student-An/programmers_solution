#include <string>
#include <vector>
#include<iostream>
using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    vector<vector<int>> answer;
    
    for(int i=0;i<size(arr1);i++){
        vector<int> temp;
        for(int j=0;j<size(arr1[i]);j++){
            temp.push_back(arr1[i][j] + arr2[i][j]);
        }
        answer.push_back(temp);
    }
    return answer;
}