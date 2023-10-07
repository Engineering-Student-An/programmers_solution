#include <string>
#include <vector>

using namespace std;

int solution(string my_string, string is_suffix) {
    int answer = 0;
    for(int i=0;i<size(my_string);i++){
        string tmp="";
        for(int j=i;j<size(my_string);j++){
            tmp+=my_string[j];
        }
        if(tmp == is_suffix) return 1;
    }
    return answer;
}