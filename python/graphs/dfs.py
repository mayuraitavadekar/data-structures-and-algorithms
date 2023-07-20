# example: V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]
def dfsOfGraph(self, V, adj):
    # code here
    res = []
    visited = set()
    
    def dfs(node):
        
        if node in visited:
            return
        
        visited.add(node)
        res.append(node)
        
        # get the neighbors
        neighbors = adj[node]
        
        for neighbor in neighbors:
            dfs(neighbor)
        
    
    for i in range(V):
        if not i in visited:
            dfs(i)
            
    
    return res # [0 2 4 3 1]
