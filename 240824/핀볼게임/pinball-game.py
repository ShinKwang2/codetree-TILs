n = int(input())

grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

def in_range(idx):
    return 0 <= idx < n

# 좌표
class Coord:
    def __init__(self, x, y, grid_coord=True):
        self.x = x
        self.y = y
        # 격자의 좌표값인지 표시
        self.grid_coord = grid_coord

    # 좌표 변경
    def change(self, add_coord):
        
        # 격자의 좌표값이 아니면 -1을 리턴 
        if not self.grid_coord:
            return -1

        _x = self.x + add_coord.x
        _y = self.y + add_coord.y

        # 변경된 좌표가 범위 밖이면 0 리턴
        if not in_range(_x) or not in_range(_y):
            return 0

        self.x = _x
        self.y = _y

        return 1
    
    def grid_value(self):
        # 격자의 좌표값이 아니면 -1을 리턴 
        if not self.grid_coord:
            return -1

        # 격자의 좌표값을 리턴 이렇게 적으면 결합도가 높아지나요?
        # 이거잘한건지 모르겠습니다.
        return grid[self.y][self.x]

# 방향 좌표값 dict
d_coord_dict = {
    "U": Coord(0, -1, False),
    "R": Coord(1, 0, False),
    "D": Coord(0, 1, False),
    "L": Coord(-1, 0, False)
}

# 볼
class Ball:
    def __init__(self, d, coord):
        self.d = d
        self.coord = coord
        self.cnt = 1

    # 방향전환
    def change_d(self, bar):
        if self.d == "U":
            if bar == 1:
                self.d = "R"
            elif bar == 2:
                self.d = "L"
            
        elif self.d == "R":
            if bar == 1:
                self.d = "U"
            elif bar == 2:
                self.d = "D"

        elif self.d == "D":
            if bar == 1:
                self.d = "L"
            elif bar == 2:
                self.d = "R"

        elif self.d == "L":
            if bar == 1:
                self.d = "D"
            elif bar == 2:
                self.d = "U"

    # 움직임
    def move(self):
        bar = self.coord.grid_value()

        # 볼이있는 좌표에 바가 있으면 방향 전환
        if bar:
            self.change_d(bar)
        
        self.cnt += 1

        return self.coord.change(d_coord_dict[self.d])
 

ball_list = []

# 시작위치와 방향으로 볼을 만들어서 리스트에 넣어줌
for i in range(n):
    ball_list.append(Ball("U", Coord(i, n - 1)))
    ball_list.append(Ball("R", Coord(0, i)))
    ball_list.append(Ball("D", Coord(i, 0)))
    ball_list.append(Ball("L", Coord(n - 1, i)))

max_cnt = 0

# 볼을 하나씩 가져와서 벗어날때까지 움직임 
for ball in ball_list:
    while True:
        if not ball.move():
            break
    
    max_cnt = max(max_cnt, ball.cnt)

print(max_cnt)