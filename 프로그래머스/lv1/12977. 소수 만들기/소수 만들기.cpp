#include <vector>
#include <iostream>
using namespace std;
bool is_Prime(int n){
    for(int i=2;i<n;i++){
        if(n%i==0) return false;
    }
    return true;
}
int solution(vector<int> nums) {
    int answer = 0;
    for(int i=0;i<size(nums);i++){
        for(int j=i+1;j<size(nums);j++){
            for(int k=j+1;k<size(nums);k++){
                if(is_Prime(nums[i]+nums[j]+nums[k])==true) answer++;
            }
        }
    }
    return answer;
}