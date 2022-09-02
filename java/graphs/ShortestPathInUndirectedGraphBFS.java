/*
 * 
 * BFS by default uses shortest path
 * all logic of BFS cycle detection we use
 * we use parent data structure to find shortest path
 */

package Leetcode;

import java.util.*;
public class shortestPathInUndirectedGraphBFS {

	public static Map<Integer, Integer> parent = new HashMap<>();
	public static Queue<Integer> q = new LinkedList<>();
	public static Map<Integer, List<Integer>> map = new HashMap<>();
	public static Map<Integer, Boolean> visited = new HashMap<>();
	
	public static void main(String[] args) {
		
		// given
		int source = 1;
		int destination = 8; 
		
		// build graph
		shortestPathInUndirectedGraphBFS obj = new shortestPathInUndirectedGraphBFS();
		obj.addEdge(1, 2);
		obj.addEdge(1, 4);
		obj.addEdge(1, 3);
		obj.addEdge(2, 5);
		obj.addEdge(4, 6);
		obj.addEdge(3, 8);
		obj.addEdge(5, 8);
		obj.addEdge(6, 7);
		obj.addEdge(7, 8);
		
		System.out.println(map);
		
		// mark all visited false
		for(int key : map.keySet())
		{
			visited.put(key, false);
		}
		
		obj.BFS(1);
		
		// prepare shortest path
		List<Integer> shortestPath = new ArrayList<>();
		
		int currentNode = destination;
		shortestPath.add(currentNode);
		
		while(currentNode != source)
		{
			currentNode = parent.get(currentNode);
			shortestPath.add(currentNode);
		}

		Collections.reverse(shortestPath);
		System.out.println(shortestPath);
		
	}
  
	public void BFS(int source)
	{
		q.add(source);
		visited.put(source, true);
		parent.put(source, -1);
		
		while(!q.isEmpty())
		{
			int v = q.poll();
			
			List<Integer> neighbours = map.get(v);
			
			for(int i=0;i<neighbours.size();i++)
			{
				int neighbour = neighbours.get(i);
				
				if(visited.get(neighbour) == true)
				{
					continue;
				}
			
				visited.put(neighbour, true);
				parent.put(neighbour, v);
				q.add(neighbour);
			}
		}
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
		map.get(v).add(u); // bidirectional/undirected graph
	}

}
