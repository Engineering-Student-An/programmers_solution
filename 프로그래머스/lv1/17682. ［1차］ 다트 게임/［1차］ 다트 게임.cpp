#include <string>
#include <cmath>

using namespace std;

int solution(string dartResult) {
    int answer = 0;
    int arr[4]={0};
    int count=0;
    for(int i=0;i<size(dartResult);i++){
        int now = 0;
        if(dartResult[i]=='*') {
            arr[count]*=2; 
            arr[count-1]*=2;
        }
        else if(dartResult[i]=='#') arr[count]=arr[count]*(-1);
        else{
            if(dartResult[i]>='0' && dartResult[i]<='9' && dartResult[i]!='1'){
                if(dartResult[i+1]=='S') now=int(dartResult[i])-48;
                else if(dartResult[i+1]=='D') now=pow(int(dartResult[i])-48,2);
                else if(dartResult[i+1]=='T') now=pow(int(dartResult[i])-48,3);
                i+=1;
                count++;
            }
            else if(dartResult[i]=='1' && dartResult[i+1]!='0'){
                now=1;
                i+=1;
                count++;
            }
            else if(dartResult[i]=='1' && dartResult[i+1]=='0'){
                if(dartResult[i+2]=='S') now=10;
                else if(dartResult[i+2]=='D') now=pow(10,2);
                else if(dartResult[i+2]=='T') now=pow(10,3);
                i+=2;
                count++;
            }
            arr[count]=now;
        }
        
    }
    for(int i=1;i<=3;i++) answer+=arr[i];
    
    return answer;
}