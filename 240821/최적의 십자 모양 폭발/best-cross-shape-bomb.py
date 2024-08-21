n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

dxs = [1, -1, 0, 0]
dys = [0, 0, 1, -1]

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

# step 1. make a map for all case of explosion (n^2)
# step 2. for all numbers of grid, check if is pair and deviede by 2

def explosion(x, y):
    new_grid = [[grid[x][y] for y in range(n)] for x in range(n)] # deep copy
    scale = new_grid[x][y]
    result = [[0 for _ in range(n)] for _ in range(n)]
    scale = grid[x][y]

# make new_grid exploded
    for i in range(scale):
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx * i, y + dy * i
            if in_range(nx, ny):
                new_grid[nx][ny] = 0
    
# assign result as new_grid falls from gravity
    for c in range(n):
        flag = n-1
        for r in range(n-1, -1, -1):
            if new_grid[r][c]:
                result[flag][c] = new_grid[r][c]
                flag -= 1

    return result

def cnt_pair(grid):
    cnt = 0
    for x in range(n):
        for y in range(n):
            curr = grid[x][y]
            for dx, dy in zip(dxs, dys):
                nx, ny = x + dx, y + dy
                if in_range(nx, ny) and grid[x][y] and grid[x][y] == grid[nx][ny]:
                    cnt += 1
    return int(cnt/2)

max_num = 0
# full case of explosion
for x in range(n):
    for y in range(n):
        max_num = max(cnt_pair(explosion(x, y)), max_num)

print(max_num)