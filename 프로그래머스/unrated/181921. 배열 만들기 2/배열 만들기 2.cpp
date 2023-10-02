#include <string>
#include <vector>

using namespace std;

vector<int> solution(int l, int r) {
    vector<int> answer;
    if(l>555555){
        answer.push_back(-1);
        return answer;
    }
    if(r>555555) r=555555;
    for(int i=l;i<=r;i++){
        if(i%5!=0) continue;
        string chk=to_string(i);
        bool check = true;
        for(int i=0;i<size(chk);i++){
            if(chk[i]!='5' && chk[i]!='0'){
                check=false;
                break;
            }
        }
        if(check==true) answer.push_back(i);
    }
    if(size(answer)==0) answer.push_back(-1);
    return answer;
}