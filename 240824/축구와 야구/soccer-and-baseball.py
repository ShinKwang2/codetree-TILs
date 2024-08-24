def d(i, j, k):
    if j > 11 or k > 9:return -100001
    if i == n+1:
        return 0
    if dp[i][j][k]!=-1:
        return dp[i][j][k]
    dp[i][j][k] = max(d(i+1,j+1,k) + point[i][0],d(i+1,j,k+1) + point[i][1],d(i+1,j,k))
    return dp[i][j][k]

n = int(input())

point =[[0,0]] + [[*map(int,input().split())] for _ in range(n)]

dp = [[[-1]*10 for _ in range(12)]for _ in range(n+1)]
print(d(1,0,0))