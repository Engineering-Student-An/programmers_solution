#include <string>
#include <algorithm>
#include <vector>
#include <iostream>
using namespace std;

int solution(vector<int> sides) {
    int answer = 1;
    sort(sides.begin(), sides.end());
    if(sides[2] >= sides[0] + sides[1]) answer=2;
    return answer;
}