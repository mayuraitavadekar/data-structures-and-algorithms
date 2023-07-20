def bfsOfGraph(self, V: int, adj: List[List[int]]) -> List[int]:
        # code here
        res = []
        q = []
        q.append(0)
        visited = set()
        visited.add(0)
        
        while len(q) != 0:
            
            node = q.pop(0)
            res.append(node)
            
            # visit all the neighbors
            neighbors = adj[node]
            
            for neighbor in neighbors:
                if neighbor in visited:
                    continue
                
                q.append(neighbor)
                visited.add(neighbor)
                
        
        return res
