#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list) {
    vector<int> answer;
    if(num_list[size(num_list)-1] > num_list[size(num_list)-2]) 
        num_list.push_back(num_list[size(num_list)-1]-num_list[size(num_list)-2]);
    else num_list.push_back(num_list[size(num_list)-1]*2);
    return num_list;
}