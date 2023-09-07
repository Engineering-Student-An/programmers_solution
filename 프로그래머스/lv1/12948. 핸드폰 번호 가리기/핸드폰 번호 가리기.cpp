#include <string>
#include <vector>

using namespace std;

string solution(string phone_number) {
    string answer = "";
    if(size(phone_number)!=4){
        for(int i=0;i<=size(phone_number)-5;i++){
            phone_number[i]='*';
        }
    }
    answer=phone_number;
    return answer;
}