package Leetcode;

import java.util.*;

public class TopologicalSortUsingDFS {

	public static Map<Integer, List<Integer>> map = new HashMap<>();
	
	public static Map<Integer, Boolean> visited = new HashMap<>();
	
	public static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		
		TopologicalSortUsingDFS obj = new TopologicalSortUsingDFS();
		obj.addEdge(1, 2);
		obj.addEdge(1, 3);
		obj.addEdge(2, 4);
		obj.addEdge(3, 4);
		obj.addEdge(2, 4);
		obj.addEdge(4, 5);
		obj.addEdge(4, 6);
		obj.addEdge(5, 6);
		
		// mark all vertices as false visited
		for(int i=1;i<=6;i++)
		{
			visited.put(i, false);
		}
		
		for(int i=1;i<=6;i++)
		{
			if(map.containsKey(i) && visited.get(i) == false)
			{
				obj.topologicalSort(i, visited, stack);
			}
		}
		
		// print ordering
		int[] arr = new int[map.keySet().size()];
		int k = 0;
		
		while(!stack.empty())
		{
			arr[k++] = stack.pop();
		}
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public void topologicalSort(int source, Map<Integer, Boolean> visited, Stack<Integer> stack)
	{
		visited.put(source, true);
		
		Iterator<Integer> i = map.get(source).iterator();
		while(i.hasNext())
		{
			int node = i.next();
			if(visited.get(node) == false)
			{
				topologicalSort(node, visited, stack);
			}
		}
		
		stack.push(source);
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
