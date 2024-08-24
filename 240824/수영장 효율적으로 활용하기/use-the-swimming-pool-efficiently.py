"""
    레인별 이용시간의 합의 최댓값을 t라고 하자
    모든 레인은 t를 넘지 않아야 한다
"""

import sys

INT_MAX = sys.maxsize

n, m = map(int, input().split())
ts = list(map(int, input().split()))

def success(t):
    """
        첫 m명을 각기 다른 레인에 할당할 수 있는가? NO
        왜냐하면 m번째 사람을 m번 레인에 할당하고 나면 그 이후 모든 사람은 m번 레인만 사용할 수 있음
    """
    res = 0
    lane = 1 # 1번 레인부터 시작
    time_sum = 0
    for i in range(n):
        if ts[i] > t: return False # 어느 누구라도 t보다 오래 걸리면 그 순간 실패

        if time_sum + ts[i] > t:
            if lane == m: return False
            else:
                res = max(res, time_sum)
                lane += 1
                time_sum = ts[i]
        else:
            time_sum += ts[i]

    """
        마지막 참조한 레인에서 마지막 사람이 수영을 하고 난 후 최댓값이 될 수도 있는데 그 경우가 없다!!
        res = max(res, time_sum)
        을 마지막에 한 번 더 하지 않았는데 통과가 됐음
    """
    return res <= t
                
ans = INT_MAX
l, r = 0, n * 1440
while l <= r:
    mid = (l + r) >> 1
    if success(mid):
        ans = min(ans, mid)
        r = mid - 1
    else:
        l = mid + 1

print(ans)