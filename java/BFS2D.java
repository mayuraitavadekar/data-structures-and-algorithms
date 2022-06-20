package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	
	private static int[][] arr = new int[4][4];
	private static int k = 0;
	
	
	private static int[][] visited = new int[4][4];
	private static List<int[]> directions = Arrays.asList(
			new int[] {1,0}, // bottom
			new int[] {-1,0}, // up
			new int[] {0, 1}, // right
			new int[] {0,-1} // left
	);
	
	public static void main(String[] args)
	{
		// fill out 2d array
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				arr[i][j] = k++;
			}
		}
		
		// now we can run bfs
		// start running bfs from 0,0 cell
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0});
		int m = arr.length;
		int n = arr[0].length;
		
		while(!q.isEmpty())
		{
			int[] point = q.poll();
			int row = point[0];
			int col = point[1];
			visited[0][0] = 1;
			System.out.println(arr[row][col]);
			
			for(int[] direction : directions)
			{
				int newRow = row + direction[0];
				int newCol = col + direction[1];
				
				// check if these are valid
				if(newRow < 0 || newRow >=m || newCol < 0 || newCol >=n
						|| visited[newRow][newCol] == 1)
				{
					continue;
				}
				
				// valid
				visited[newRow][newCol] = 1;
				q.add(new int[] {newRow, newCol});
			}
		}
		
	}
}
