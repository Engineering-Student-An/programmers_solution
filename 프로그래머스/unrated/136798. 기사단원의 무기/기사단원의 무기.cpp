#include <string>
#include <vector>
#include <numeric>
#include <iostream>
#include <cmath>

using namespace std;

int num_prime(int n, int limit){
    int sum=0;
    if(n==1) return 1;
    for(int i=1;i<=sqrt(n);i++){
        if(n%i == 0) sum++;
        if(sum > limit) return limit+10;
    }
    if(n==sqrt(n)*sqrt(n)) return sum*2-1;
    return sum*2;
}

int solution(int number, int limit, int power) {
    int answer = 0;
    int arr[100001]={0};
    for(int i=1;i<=number;i++){
        for(int j=1;j<=number/i;j++){
            arr[j*i] ++;
        }
    }
    for(int i=1; i<=number; i++){
        if(arr[i] > limit) arr[i] = power;
    }
    answer = accumulate(begin(arr), end(arr), 0);

    return answer;
}