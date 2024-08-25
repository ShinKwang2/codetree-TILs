#===================dp 초기화 조건==========================#
for i in range(n):
    dp[0][i] = max(dp[0][i-1], graph[0][i])
    dp[i][0] = max(dp[i-1][0], graph[i][0])

#===================코드전체==========================#
n = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]
dp = [[0]*n for _ in range(n)]

for i in range(n):
    dp[0][i] = max(dp[0][i-1], graph[0][i])
    dp[i][0] = max(dp[i-1][0], graph[i][0])

for i in range(1,n):
    for j in range(1,n):
        dp[i][j] =max(min(dp[i-1][j],dp[i][j-1]),graph[i][j])

print(dp[-1][-1])