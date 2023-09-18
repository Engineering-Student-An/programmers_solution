#include <string>
#include <vector>
#include <iostream>
using namespace std;

void to_bin(int n, int arr[][17], int i, int num){
    for(int j=n-1;j>=0;j--){
        (num%2 == 1) ? arr[i][j] = 1 : arr[i][j] = 0;
        num/=2;
    }
}

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    int arr1_bin[17][17], arr2_bin[17][17];
    for(int i=0;i<size(arr1);i++){
        to_bin(n, arr1_bin, i, arr1[i]);
        to_bin(n, arr2_bin, i, arr2[i]);
    }
    for(int i=0;i<n;i++){
        string temp="";
        for(int j=0;j<n;j++){
            if(arr1_bin[i][j] == 1 || arr2_bin[i][j]==1) temp+="#";
            else if(arr1_bin[i][j]==0 && arr2_bin[i][j]==0) temp+=" ";
        }
        answer.push_back(temp);
        
    }
    return answer;
}