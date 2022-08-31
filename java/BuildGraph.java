/*
	
	use algorithms for undirected graphs only.
	
*/

package Leetcode;

import java.util.*;

public class BuildGraph {
	
	public static HashMap<Integer, List<Integer>> map = new HashMap<>();
	
	///////////// DFS variables ///////////////
	public static Map<Integer, Boolean> visited = new HashMap<>();
	public static ArrayList<Integer> arrlist = new ArrayList<>();
	public static Map<Integer, Integer> parent = new HashMap<Integer, Integer>();
	//////////////////////////////////////////
	///////////// cycle detection variables //
	public static Map<Integer, Integer> parent = new HashMap<Integer, Integer>();
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
	
	public void dfs(int source, Map<Integer, Boolean> visited)
	{
		visited.put(source, true);
		arrlist.add(source);
		
		Iterator<Integer> i = map.get(source).iterator();
		while(i.hasNext())
		{
			int node = i.next();
			if(visited.get(node) != true)
			{
				dfs(node, visited);
			}
		}
	}
	
	public boolean cycleDetectionWithBFS(int source)
	{
		Queue<Integer> q = new LinkedList<>();
		Map<Integer, Integer> parent = new HashMap<Integer, Integer>(); // {child -> parent}
		Map<Integer, Boolean> visited = new HashMap<>();
		// mark all vertices false
		for(int i=0;i<map.keySet().size();i++)
		{
			visited.put(i, false); 
		}
		
		int vertex = source;
		parent.put(source, -1);
		q.add(vertex);
		visited.put(vertex, true);
		
		while(!q.isEmpty())
		{
			int node = q.poll();
			List<Integer> neighbours = map.get(node);
			
			for(int i=0;i<neighbours.size();i++)
			{
				int neighbour = neighbours.get(i);
				
				// if neighbour is parent and if neighbour is child of node
				if(visited.get(neighbour) == true && neighbour != parent.get(node))
				{
					return true;
				}
				
				else if(visited.get(neighbour) == false)
				{
					visited.put(neighbour, true);
					q.add(neighbour);
					parent.put(neighbour, node);
				}
			}
		}
		
		return false;
	}
	
	public boolean cycleDetectionWithDFS(int source, Map<Integer, Boolean> visited,int parent)
	{
		visited.put(source, true);
	
		Iterator<Integer> i = map.get(source).iterator();
		while(i.hasNext())
		{
			int node = i.next();
			if(visited.get(node) != true)
			{	
				boolean cycleDetected = cycleDetectionWithDFS(node, visited, source);
				if(cycleDetected == true)
				{
					return true;
				}
			}
			else if(visited.get(node) == true && node != source)
			{
				return true;
			}
		}
		
		return false;
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
		obj.addEdge(3, 4, true);
		obj.addEdge(4, 1, true);
		
		// get vertex count
		obj.getVertexCount();
		
		// get edges count
		obj.getEdgesCount(true);
		
		// has vertex
		obj.hasVertex(0);
		
		// has edge
		obj.hasEdge(3, 0);
		
		// BFS traversal
		obj.bfs(0);
		
		// prepare visited map first
		for(int i=0;i<map.keySet().size();i++)
		{
			visited.put(i, false); // all false initially
		}
		obj.dfs(0, visited);		
		// solution of dfs
		System.out.println(arrlist);
		
		// cycle detection using BFS
		System.out.println("======= CYCLE DETECTION USING BFS======");
		boolean res = obj.cycleDetectionWithBFS(0);
		if(res == true) System.out.println("yes cycle is present");
		else System.out.println("no cycle is not present");
		
		// cycle detection using DFS
		System.out.println("======= CYCLE DETECTION USING DFS======");
		for(int i=0;i<map.keySet().size();i++)
		{
			visited.put(i, false); // all false initially
		}
		
		res = obj.cycleDetectionWithDFS(0, visited, -1);
		if(res == true) System.out.println("yes cycle is present");
		else System.out.println("no cycle is not present");
	}
}
