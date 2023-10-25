#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

string solution(string my_string, vector<vector<int>> queries) {
    
    for(int i=0;i<size(queries);i++){
        reverse(my_string.begin()+queries[i][0], my_string.begin()+queries[i][1]+1);
    }
    return my_string;
}