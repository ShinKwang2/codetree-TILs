n, m = map(int, input().split())

grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

max_size = -1;

for start_row in range(n):
    for end_row in range(start_row, n):
        for start_col in range(m):
            for end_col in range(start_col, m):
                size = 0
                test_case = True
                for row in range(start_row, end_row + 1):
                    if not test_case:
                        break
                    for col in range(start_col, end_col + 1):
                        if grid[row][col] > 0:
                            size += 1
                            continue
                        test_case = False
                if not test_case:
                    continue
                
                max_size = max(max_size, size)

print(max_size)