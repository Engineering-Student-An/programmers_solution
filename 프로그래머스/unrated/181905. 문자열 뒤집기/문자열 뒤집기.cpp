#include <string>
#include <vector>

using namespace std;

string solution(string my_string, int s, int e) {
    string answer = "";
    string tmp="";
    for(int i=e;i>=s;i--) tmp+=my_string[i];
    for(int i=0;i<s;i++) answer+=my_string[i];
    answer+=tmp;
    for(int i=e+1;i<size(my_string);i++) answer+=my_string[i];
    return answer;
}