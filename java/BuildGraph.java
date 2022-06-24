package Leetcode;

import java.util.*;

public class BuildGraph {
	
	public static HashMap<Integer, List<Integer>> map = new HashMap<>();
	
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
	
	public static void main(String[] args)
	{
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
		
	}
}
