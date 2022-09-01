package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CycleDetectionInDirectedGraphDFS {
	
	public static HashMap<Integer, List<Integer>> map = new HashMap<>();
	public static Map<Integer, Boolean> dfs_visited = new HashMap<>();
	public static Map<Integer, Boolean> visited = new HashMap<>();
	
	public void addEdge(int u, int v)
	{
		if(!map.containsKey(u))
		{
			map.put(u, new ArrayList<Integer>());
		}
		
		if(!map.containsKey(v))
		{
			map.put(v, new ArrayList<Integer>());
		}

		map.get(u).add(v);
	}
	
	public boolean cycleDetectionInDirectedGraph(
			int source, 
			Map<Integer, Boolean> visited,
			Map<Integer, Boolean> dfs_visited
			)
	{
		visited.put(source, true);
		dfs_visited.put(source, true);
		
		Iterator<Integer> i = map.get(source).iterator();
		while(i.hasNext())
		{
			int node = i.next();
			if(visited.get(node) != true)
			{	
				boolean res = cycleDetectionInDirectedGraph(node, visited, dfs_visited);
				if(res == true)
				{
					return true;
				}
			}
			else if(visited.get(node) == true && dfs_visited.get(node) == true)
			{
				return true;
			}
		}
		
		dfs_visited.put(source, false);
		return false;
		
	}
	
	public static void main(String[] args)
	{
		CycleDetectionInDirectedGraphDFS obj = new CycleDetectionInDirectedGraphDFS();
		
		obj.addEdge(2, 0);
		obj.addEdge(1, 0);
		obj.addEdge(3, 1);
		obj.addEdge(3, 2);
		obj.addEdge(1, 3);
//		obj.addEdge(2, 4);
//		obj.addEdge(4, 5);
//		obj.addEdge(5, 6);
//		obj.addEdge(6, 4);
//		obj.addEdge(8, 7);
		
		for(Map.Entry<Integer, List<Integer>> m : map.entrySet())
		{
			dfs_visited.put(m.getKey(), false);
			visited.put(m.getKey(), false);
		}
		
		int arr[] = {2,0,1,3,1};
		for(int i=0;i<arr.length;i++)
		{
			if(visited.get(arr[i]) != true)
			{
				boolean res = obj.cycleDetectionInDirectedGraph(arr[i], visited, dfs_visited);
				if(res == true)
				{
					System.out.println("yes cycle is present");
				}
			}
		}
		
		System.out.println("no cycle is not present");
		
//		boolean res = obj.cycleDetectionInDirectedGraph(2, visited, dfs_visited);
//		if(res == true) System.out.println("yes cycle is present");
//		else System.out.println("no cycle is not present");
	}
}
