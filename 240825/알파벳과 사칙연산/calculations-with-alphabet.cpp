#include <iostream>
#include <vector>
#include <cstring>

#define ll long long

using namespace std;

//func
void init();
void run(int lev);
void check();

//var
char input_buf[201];
int input_len;
int char_len;
int oper_len;
ll ans; // max value;
ll tem_value;

vector<char> ori_char_vector;
vector<char> ori_oper_vector;

vector<int> char_vector;
vector<char> oper_vector;

int char_table[213];//알파벳 중복등장 여부 확인용

int main() {
    // 여기에 코드를 작성해주세요.
    ans = -(21e5);
    init();
    run(0);
    cout << ans;
    return 0;
}


void init() {

    cin >> input_buf;
    input_len = strlen(input_buf);
    char_len = (input_len / 2) + 1;
    oper_len = (input_len / 2);

    for (int i = 0; i < input_len; i++) {
        if (i % 2) {
            ori_oper_vector.push_back(input_buf[i]);
        }else{
        }
    }

    for (int i = ('a'-0); i < ('g'-0); i++) {
        char_table[i] = 0;
    }


}

void run(int lev) {
    if (lev == input_len) {
        //결과값 산출 후 ans와 비교
        check();
        return;
    }
    else if (lev > input_len) {
        cout << "lev over limit"<<endl;
    }
    else {}

    if (lev % 2) {//true -> 1 -> oper

        run(lev + 1);

    }else{ //false -> 0 -> char

        if (char_table[input_buf[lev] - 0] == 0) {//첫 등장(init)

            for (int i = 1; i <= 4; i++) {
                char_table[input_buf[lev] - 0] = i;
                char_vector.push_back(i);

                run(lev + 1);

                char_table[input_buf[lev] - 0] = 0;
                char_vector.pop_back();


            }
        }
        else {//이미 나온 알파벳(그대로)
            char_vector.push_back(char_table[input_buf[lev] - 0]);
            run(lev + 1);
            char_vector.pop_back();
        }
    }

    return;
}

void check() {
    //var
    ll pre_int;
    int tem_int;
    int tem_iter;

    char tem_oper;

    //init
    pre_int = char_vector[0];
    tem_iter = 1;
    tem_oper = 'A';
    //결과값 산출
    for (int i = 1; i < input_len; i++) {
        if (i % 2) {//연산자,1 
            tem_oper = input_buf[i];
            
        }
        else {//숫자
            tem_int = char_vector[tem_iter];
            tem_iter++;

            switch (tem_oper) {
            case('-'):
                pre_int = pre_int - tem_int;
                break;

            case('*'):
                pre_int = pre_int * tem_int;
                break;

            case('+'):
                pre_int = pre_int + tem_int;
                break;

            default:
                cout << "unexpected operator in switch";
                break;
            }
        }
    
    }

    tem_value = pre_int;

    //ans와 비교 
    if (ans < tem_value) {
        ans = tem_value;
    }
}