#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <stack>

using namespace std;

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<double> fail;
    int num[502]= {0};
    for(int i=0;i<size(stages);i++){
        num[stages[i]] ++;
    }
    int sum=num[N+1];
    for(int i=N; i>0; i--){
        sum += num[i];
        fail.push_back(double(num[i])/double(sum));
    }
    
    reverse(fail.begin(), fail.end());
    fail.insert(fail.begin(), 0);
    
    int arr[501] = {0};
    for(int i=1;i<=N; i++){
        arr[i] = i;
    }
    
    for(int i=2;i<=N;i++){
        for(int j=i; j>1; j--){
            if(fail[j] > fail[j-1]){
                swap(fail[j], fail[j-1]);
                swap(arr[j], arr[j-1]);
            }
            else break;
        }
    }
    for(int i=1;i<=N;i++){
       answer.push_back(arr[i]);
    }
    
    return answer;
}