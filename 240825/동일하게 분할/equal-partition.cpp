#include <iostream>

// 가능 불가능?
// dp[i]는 i를 만드는게 가능하냐? 이다.
// 목표치는 /2 임에 유의
// dp[i]=dp[원하는값] 1이라면 나도 1 아니면 나도 0

using namespace std;

int n;
int matrix[101];
int dp[100001];

int main() {
    int total = 0;

    cin >> n;
    for(int i = 0; i<n; i++){
        cin >> matrix[i];
        total += matrix[i];
    }

    if(total%2==1){
        cout << "No";
        return 0;
    }

    //set
    dp[0]=1;

    //matrix 순회
    for(int i = 0; i<n; i++){
        int matrixVal = matrix[i];
        //dp 순회
        for(int j = total/2; j>=0; j--){
            int dpVal = j;

            if(matrixVal>dpVal)continue;

            if(dp[dpVal-matrixVal]==1){
                dp[dpVal]=1;
            }
        }
    }

    int ans = dp[total/2];
    if(ans){
        cout << "Yes";
    }else{
        cout << "No";
    }
}