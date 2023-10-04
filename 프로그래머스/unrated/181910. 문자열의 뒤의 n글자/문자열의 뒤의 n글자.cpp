#include <string>
#include <vector>

using namespace std;

string solution(string my_string, int n) {
    string answer = "";
    for(int i=size(my_string)-n;i<size(my_string);i++){
        answer+=my_string[i];
    }
    return answer;
}