#include <vector>
#include <algorithm>
#include <cmath>
#include <iostream>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    int kind = 0;
    int check[200000] = {0};
    for(int i=0;i<size(nums);i++){
        if(check[nums[i]]==0) {
            kind++;
            check[nums[i]]=1;
        }
    }
    int siz = size(nums) / 2;
    answer = min(siz, kind);
    return answer;
}