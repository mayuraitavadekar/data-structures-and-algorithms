import java.util.*;

public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<>();
        
        // map = my graph 
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<edges.size();i++)
        {
            int u = edges.get(i).get(0);
            int va = edges.get(i).get(1);
            
            buildGraph(u, va, map);
        }
        
        // initialize data structures
        for(int i=0;i<v;i++)
        {
            visited.put(i, false);
        }
        
        // start traversing the graph
        for(int i=0;i<v;i++)
        {
            if(visited.get(i) != true)
            {
                stack = dfs(i, map, visited, stack);
            }
        }
        
        while(!stack.empty())
        {
            result.add(stack.pop());
        }
        
        return result;
    }
    
    public static Stack<Integer> dfs(int source, Map<Integer, List<Integer>> map, Map<Integer, Boolean> visited, Stack<Integer> stack)
    {
        // mark the source node 
        visited.put(source, true);
        
        if(map.get(source) != null)
        {
            Iterator<Integer> i = map.get(source).iterator();
            
            while(i.hasNext())
            {
                int node = i.next();
                
                if(visited.get(node) != true)
                {
                    // visit this node
                    dfs(node, map, visited, stack);
                }
            }
        }
        
        stack.push(source);
        return stack;
    }
    
    public static void buildGraph(int u, int v, Map<Integer, List<Integer>> map)
    {
        if(!map.containsKey(u))
        {
            map.put(u, new ArrayList<>()); // u -> []
        }
        
        if(!map.containsKey(v))
        {
            map.put(v, new ArrayList<>()); // v -> []
        }
        
        // graph is directed
        map.get(u).add(v); // u -> [v]
    }
}
