
import java.util.*;
public class Solution {
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        Queue<Integer> q = null;
        
        // build graph
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            
            buildGraph(map, u, v);
        }
        
        // apply BFS
        for(int i=1;i<=n;i++)
        {
            visited.put(i, false);
        }
        
        for(int i=1;i<=n;i++)
        {
            if(visited.get(i) != true)
            {
                // visit this node
                if(cycleDetectionUsingBFS(i, map, visited, parent, q))
                {
                    return "Yes";
                }
            }
        }
        
        return "No";
    }
    
    public static void buildGraph(Map<Integer, List<Integer>> map, int u, int v)
    {
        if(!map.containsKey(u))
        {
            map.put(u, new ArrayList<>());
        }
        
        if(!map.containsKey(v))
        {
            map.put(v, new ArrayList<>());
        }
        
        map.get(u).add(v);
        map.get(v).add(u);
    }
    
    public static boolean cycleDetectionUsingBFS(
        int source, 
        Map<Integer, List<Integer>> map, 
        Map<Integer, Boolean> visited,
        Map<Integer, Integer> parent,
        Queue<Integer> q
    )
    {
        q = new LinkedList<>();
        // visit source
        visited.put(source, true);
        parent.put(source, -1);
        q.add(source);
        
        while(!q.isEmpty())
        {
            int v = q.poll();
            
            if(map.get(v) != null)
            {
                List<Integer> neighbours = map.get(v);
                
                for(int i=0;i<neighbours.size();i++)
                {
                    int node = neighbours.get(i);
                    
                    if(visited.get(node) == true && node != parent.get(v))
                    {
                        return true; // cycle is present
                    }
                    
                    if(visited.get(node) != true)
                    {
                        // visit this node
                        visited.put(node, true);
                        parent.put(node, v);
                        q.add(node);
                    }
                }
            }
        }
        
        return false;
        
    }
    
}
