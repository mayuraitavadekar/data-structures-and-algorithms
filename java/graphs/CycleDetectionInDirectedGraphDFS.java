import java.util.ArrayList;
import java.util.*;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    // Write your code here.
      Map<Integer, List<Integer>> map = new HashMap<>();
      Map<Integer, Boolean> visited = new HashMap<>();
      Map<Integer, Boolean> dfs_visited = new HashMap<>();
      
      for(int i=1;i<=n;i++)
      {
          visited.put(i, false);
          dfs_visited.put(i, false);
      }
      
      // build graph
      for(int i=0;i<edges.size();i++)
      {
          int u = edges.get(i).get(0);
          int v = edges.get(i).get(0);
          
          buildGraph(u, v, map);
      }
      
      // cycle detection using DFS
      for(int i=1;i<=n;i++)
      {
          if(visited.get(i) != true)
          {
              // visit this
              if(dfs(i, map, visited, dfs_visited))
              {
                  return true;
              }
          }
      }
      
      return false;
  }
    
    public static boolean dfs(int source, Map<Integer, List<Integer>> map, Map<Integer, Boolean> visited,  Map<Integer, Boolean> dfs_visited)
    {
        // visit the source
        visited.put(source, true);
        dfs_visited.put(source, true);
        
        if(map.get(source) != null)
        {
            Iterator<Integer> i = map.get(source).iterator();
            
            while(i.hasNext())
            {
                // get the node from list
                int node = i.next();
                
                // check if it is visited
                if(visited.get(node) != true)
                {
                    // this node is not visited
                    boolean res = dfs(node, map, visited, dfs_visited);
                    if(res == true)
                    {
                        // cycle is present
                        return true;
                    }
                }
                
                else if(visited.get(node) == true && dfs_visited.get(node) == true)
                {
                    return true;
                }
            }
        }
        
        dfs_visited.put(source, false);
        return false;
    }
  
    public static void buildGraph(int u, int v, Map<Integer, List<Integer>> map)
    {
        if(!map.containsKey(u))
        {
            map.put(u, new ArrayList<>());
        }
        
        if(!map.containsKey(v))
        {
            map.put(v, new ArrayList<>());
        }
        
        // graph is directed
        map.get(u).add(v); // u -> [v]
    }
  
}
