#include <cmath>

using namespace std;

int solution(int a, int b, int c, int d) {
    int answer = 0;
    int arr[7]={0};
    int num[7];
    for(int i=1;i<=6;i++) num[i]=i;
    arr[a]++; arr[b]++;
    arr[c]++; arr[d]++;
    for(int i=1;i<=6;i++){
        for(int j=i+1;j<=6;j++){
            if(arr[i]<arr[j]){
                swap(arr[i],arr[j]);
                swap(num[i],num[j]);
            }
        }
    }
    if(arr[1]==4) answer=1111*num[1];
    else if(arr[1]==3) answer=pow(10*num[1]+num[2],2);
    else if(arr[1]==2 && arr[2]==2) answer=(num[1]+num[2]) * abs(num[1]-num[2]);
    else if(arr[1]==2 && arr[2]==1 && arr[3]==1) answer=num[2]*num[3];
    else if(arr[1]==1){
        answer = min(min(num[1],num[2]),min(num[3],num[4]));
    }
    return answer;
}