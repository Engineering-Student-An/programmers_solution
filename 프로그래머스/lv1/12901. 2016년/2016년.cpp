#include <string>
#include <vector>

using namespace std;

string solution(int a, int b) {
    string answer = "";
    int sum = b;
    int day[12]={0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};
    string dday[7]= {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
    for(int i=0;i<a;i++) sum+=day[i];
    answer = dday[sum%7];
    return answer;
}