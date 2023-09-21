#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string str;
    cin >> str;
    for(int i=0;i<size(str);i++){
        if(str[i]>='A' && str[i]<='Z') str[i]+=32;
        else str[i]-=32;
    }
    cout << str;
    return 0;
}