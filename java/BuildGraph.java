package Leetcode;

import java.util.*;

public class BuildGraph {
	
	public static HashMap<Integer, List<Integer>> map = new HashMap<>();
	
	///////////// DFS variables ///////////////
	public static Map<Integer, Boolean> visited = new HashMap<>();
	public static ArrayList<Integer> arrlist = new ArrayList<>();
	//////////////////////////////////////////
	
	public void addEdge(int u, int v, boolean bidirectional)
	{
		if(!map.containsKey(u))
		{
			map.put(u, new ArrayList<Integer>());
		}
		
		if(!map.containsKey(v))
		{
			map.put(v,  new ArrayList<Integer>());
		}
		
		map.get(u).add(v);
		
		if(bidirectional == true)
		{
			map.get(v).add(u);
		}
	}
	
	public void getVertexCount()
	{
		System.out.println("vertex count : " + map.keySet().size());
	}
	
	public void getEdgesCount(boolean bidirectional)
	{
		int count = 0;
		
		for(Map.Entry<Integer, List<Integer>> m : map.entrySet())
		{
			count += m.getValue().size();
		}
		
		if(bidirectional == true) count /= 2;
		
		System.out.println("edge count : " + count);
	}
	
	public void hasVertex(int u)
	{
		if(map.containsKey(u))
		{
			System.out.println(u + " is present");
		}
		else
		{
			System.out.println(u + " not present");
		}
	}
	
	public void hasEdge(int u, int v)
	{
		if(map.get(u).contains(v))
		{
			System.out.println("yes edge is there");
		}
		else
		{
			System.out.println("no edge is present");
		}
	}
	
	public void bfs(int source)
	{
		// to store traversal; not to be used in problems
		List<Integer> arrlist = new ArrayList<Integer>();
		
		// for bfs we need following data structures
		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[map.keySet().size()]; // you can also take map<Integer, Boolean> instead of this
		
		q.add(source);
		visited[source] = 1;
		arrlist.add(source);
		
		
		while(!q.isEmpty())
		{
			int v = q.poll();
			// get neighbours
			List<Integer> neighbours = map.get(v);
			
			for(int i=0;i<neighbours.size();i++)
			{
				int neighbour = neighbours.get(i);
				if(visited[neighbour] ==  1)
				{
					continue;
				}
				
				arrlist.add(neighbour);
				visited[neighbour] = 1;
				q.add(neighbour);
			}
		}
		
		System.out.println(arrlist);
	}
	
	public void dfs(int v, Map<Integer, Boolean> visited)
	{
		
		visited.put(v, true);
		arrlist.add(v);
		
		Iterator<Integer> i = map.get(v).iterator();
		while(i.hasNext())
		{
			int node = i.next();
			if(visited.get(node) != true)
			{
				dfs(node, visited);
			}
		}
	}
	
	public static void main(String[] args)
	{
		
		/*
		 *  0------1
		 *  |	   |\
		 *  |	   | \
		 *  |      |  4
		 *  |	   | /
		 *  |      |/
		 *  2------3
		 * 
		 * 
		 */
		
		BuildGraph obj = new BuildGraph();
		
		obj.addEdge(0, 1, true);
		obj.addEdge(0, 2, true);
		obj.addEdge(2, 3, true);
		obj.addEdge(3, 1, true);
		obj.addEdge(4, 1, true);
		obj.addEdge(4, 2, true);
		
		// get vertex count
		obj.getVertexCount();
		
		// get edges count
		obj.getEdgesCount(true);
		
		// has vertex
		obj.hasVertex(0);
		
		// has edge
		obj.hasEdge(3, 0);
		
		// prepare visited map first
		for(int i=0;i<map.keySet().size();i++)
		{
			visited.put(i, false); // all false initially
		}
		obj.dfs(0, visited);		
		// solution of dfs
		System.out.println(arrlist);
	}
}
