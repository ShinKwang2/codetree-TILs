n=int(input())
array=list(map(int,input().split()))

answer=11
def in_range(x):
    return 0<=x<n

def find_min(idx, cnt):
    global answer
    if idx==n-1:
        answer=min(answer, cnt)
        return

    for i in range(1,array[idx]+1):
        nx=idx+i
        if in_range(nx):
            find_min(nx, cnt + 1)

find_min(0, 0)
if answer==11:
    print(-1)
else:
    print(answer)