#include <string>
#include <vector>

using namespace std;

bool is_Prime(int n){
    for(int i=2; i<n; i++){
        if(n%i == 0) return false;
    }
    return true;
}

int solution(int n) {
    int answer = 0;
    int size = n+1;
    int arr[1000001]={0};
    for(int i=2; i<=n; i++){
        if(arr[i]==0){
            answer++;
            for(int j=1;j<=n/i;j++){
                arr[j*i] = 1;
            }
        }
    }
    return answer;
}