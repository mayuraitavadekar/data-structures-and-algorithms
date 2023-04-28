m = 3 # 3 rows
n = 3 # 3 cols

# create matrix
matrix = [[0 for i in range(n)] for i in range(m)]

# fill the matrix
k = 0
for i in range(m):
    for j in range(n):
        k += 1
        matrix[i][j] = k

# perform BFS
directions = [(1,0),(-1,0),(0,1),(0,-1)]

# start bfs
# single source bfs
result = []
q = []
# initialize visited memo
visited = [[0 for i in range(n)] for j in range(m)]

# start with element at pos 0,0
q.append((0,0))
visited[0][0] = 1

while len(q) != 0:
    
    pos = q.pop(0)
    row = pos[0]
    col = pos[1]
    
    result.append(matrix[row][col]) # visited
    
    # visit its neighbours
    for direction in directions:
        newRow = row + direction[0]
        newCol = col + direction[1]
        
        if newRow >=m or newCol >=n or visited[newRow][newCol] == 1 or newRow < 0 or newCol <0:
            continue
        
        # as soon as you add it in q; mark visited
        visited[newRow][newCol] = 1
        q.append((newRow, newCol))

print(result)
