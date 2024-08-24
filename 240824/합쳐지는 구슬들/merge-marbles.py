n, m, t = map(int, input().split())

# 범위 체크함수
def in_range(row, col):
    return 0 <= row < n and 0 <= col < n

# 방향별 coord
d_coord_dict = {
    "U": (-1, 0),
    "R": (0, 1),
    "D": (1, 0),
    "L": (0, -1)
}

# 방향전환 dict
d_rotate_dict = {
    "U": "D",
    "R": "L",
    "D": "U",
    "L": "R" 
}

# 구슬
class Marble:
    def __init__(self, row, col, d, w):
        self.row = row
        self.col = col
        self.d = d
        self.w = w
        self.state = True

    # 움직이는 함수
    def move(self, _grid):
        # 다음 좌표를 구해보고
        add_row, add_col = d_coord_dict[self.d]
        _row, _col = self.row + add_row, self.col + add_col
        # 범위 밖이면 좌표변경없이 방향만 변경
        if not in_range(_row, _col):
            self.d = d_rotate_dict[self.d]
            _row, _col = self.row, self.col
        
        self.row, self.col = _row, _col

        # 다음 위치가 비어있다면 넣어주고 리턴
        if _grid[self.row][self.col] == None:
            _grid[self.row][self.col] = self
            return
        
        # 기존위치에 있는 구슬의 상태를 False로 바꾸고
        _marble = _grid[self.row][self.col]
        _marble.state = False

        # 현재구슬에 무게를 더하고 넣어줌
        self.w += _marble.w
        _grid[self.row][self.col] = self

# 구슬을 저장하는 공간
marble_list = []

# 격자
grid = [
    [None for _ in range(n)]
    for _ in range(n)
]

# 구슬을 넣어줌
for _ in range(m):
    _row, _col, d, _w = input().split()
    _row, _col, w = map(int, [_row, _col, _w])
    row, col = _row - 1, _col - 1
    
    marble = Marble(row, col, d, w)
    marble_list.append(marble)

    grid[row][col] = marble

# 구슬을 하나씩 움직여줌
for _ in range(t):
    _grid = [
        [None for _ in range(n)]
        for _ in range(n)
    ]

    for marble in marble_list:
        marble.move(_grid)

    # 상태를 감지해서 필터링 해줌
    marble_list = list(filter(lambda x: x.state, marble_list))

    grid = _grid

# 정답출력
print(len(marble_list), max(map(lambda marble: marble.w, marble_list)))