/*

Kahn's Algorithm

*/

package Leetcode;

import java.util.*;

public class TopologicalSortUsingBFS {
	
	public static Map<Integer, Integer> indegree = new HashMap<>();
	
	public static Map<Integer, List<Integer>> map = new HashMap<>();
	
	public static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args)
	{
		TopologicalSortUsingBFS obj = new TopologicalSortUsingBFS();
		// build graph
		obj.addEdge(1, 2);
		obj.addEdge(1, 3);
		obj.addEdge(3, 5);
		obj.addEdge(2, 5);
		obj.addEdge(5, 4);
		
		System.out.println(map);
		
		// build indegree table
		for(int i : map.keySet())
		{
			indegree.put(i, 0);
		}
		
		for(Map.Entry<Integer, List<Integer>> m : map.entrySet())
		{
			List<Integer> list = map.get(m.getKey());
			for(int i : list)
			{
				indegree.put(i, indegree.get(i)+1);
			}
		}
		
		// print indegree table
		System.out.println(indegree);
		
		// put items with 0 indegree in queue
		for(Map.Entry<Integer, Integer> m : indegree.entrySet())
		{
			if(m.getValue() == 0)
			{
				q.add(m.getKey());
			}
		}
		
		// ans
		ArrayList<Integer> arrlist = new ArrayList<>();
		
		// apply bfs
		while(!q.isEmpty())
		{
			int v = q.poll();
			arrlist.add(v);
			
			// get neighbours
			List<Integer> neighbours = map.get(v);
			for(int i=0;i<neighbours.size();i++)
			{
				int neighbour = neighbours.get(i);
				// reduce indegree of this neighbour
				indegree.put(neighbour, indegree.get(neighbour)-1);
				// if indegree of this neighbour is 0 
				if(indegree.get(neighbour) == 0)
				{
					q.add(neighbour);
				}
			}
		}
		
		// finally print ans
		System.out.println("valid topological sort: :" +  arrlist);
		
	}
	
	public void addEdge(int u, int v)
	{
		if(!map.containsKey(u))
		{
			map.put(u, new LinkedList<>());
		}
		
		if(!map.containsKey(v))
		{
			map.put(v, new LinkedList<>());
		}
		
		map.get(u).add(v);
	}
}
