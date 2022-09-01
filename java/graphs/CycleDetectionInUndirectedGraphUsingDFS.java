
import java.util.*;
public class Solution {
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        Map<Integer, List<Integer>> map = new HashMap<>();
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
                if(cycleDetectionUsingDFS(i, -1, map, visited))
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
    
    public static boolean cycleDetectionUsingDFS(
        int node, 
        int parent,
        Map<Integer, List<Integer>> map, 
        Map<Integer, Boolean> visited
    )
    {
        visited.put(node, true);
        
        if(map.get(node) != null)
        {
            Iterator<Integer> i = map.get(node).iterator();
            
            while(i.hasNext())
            {
                int neighbour = i.next();
                
                if(visited.get(neighbour) != true)
                {
                    boolean res = cycleDetectionUsingDFS(neighbour, node, map, visited);
                    if(res == true)
                    {
                        return true;
                    }
                }
                
                else if(neighbour != parent)
                {
                    return true;
                }
            }
        }
        
        return false;
       
    }
    
}
