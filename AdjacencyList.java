package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class AdjacencyList
{
	private Map<Integer, List<Integer>> Adjacency_List;
	private LinkedList<Integer> bftList = new LinkedList<Integer>();
	
    // Adjacency List
	public AdjacencyList(int vertices) {
		Adjacency_List = new HashMap<Integer, List<Integer>>();
		for(int x =1; x<=vertices; x++){
			Adjacency_List.put(x, new LinkedList<Integer>());
		}
		
	}
	
    // Set Edge
	public void setEdge(int src, int dest){
		if (src > Adjacency_List.size() || dest > Adjacency_List.size()){
			System.out.println("Entered node is not present");
			return;
		}
		List<Integer> slist = Adjacency_List.get(src);
		slist.add(dest);
	}
	
    // Get Edge
	public List<Integer> getEdge(int src){
		if (src > Adjacency_List.size()){
			System.out.println("Entered node is not present");
			return null;
		}
		return Adjacency_List.get(src);
	}
	
    // Depth first Traversal
	public void dft(int adjacency_matrix[][], int srcNode){
		
//		int no_of_nodes
		Stack<Integer> stack = new Stack<Integer>();
		if(srcNode > Adjacency_List.size()){
			return;
		}
		stack.push(srcNode);
		System.out.println("Depth first Traversal is");
		int[] visited = new int[Adjacency_List.size() + 1];
		int i, element;
		System.out.print(srcNode + "\t");
		while(!stack.isEmpty()){
			element = stack.peek();
			i = element;
			while(i<= Adjacency_List.size()){
				if (adjacency_matrix[element][i] == 1 && visited[i] == 0){
					stack.push(i);
					visited[i] = 1;
					element = i;
					i = 1;
					System.out.print(element + "\t");
					continue;
				}
				i++;
			}
			stack.pop();
		}
	}
	
    // Breadth first traversal
	public void bft(int adjacency_matrix[][], int source)
    {
		if(source > Adjacency_List.size()){
			return;
		}
        int number_of_nodes = adjacency_matrix[source].length - 1;
        int[] visited = new int[number_of_nodes + 1];
        int i, element;
 
        visited[source] = 1;
        bftList.add(source);
 
        while (!bftList.isEmpty())
        {
            element = bftList.remove();
            i = element;
            System.out.print(i + "\t");
            while (i <= number_of_nodes)
            {
                if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
                {
                	bftList.add(i);
                    visited[i] = 1;
                }
                i++;
            }
        }
    }
	
    public static void main(String...arg)
    {
    	int number_of_vertices, number_of_edges, source, destination;
    	int source_node;
    	int count = 0;
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the number of nodes and edges");
    	number_of_vertices = sc.nextInt();
    	number_of_edges = sc.nextInt();
    	AdjacencyList adjacencyList = new AdjacencyList(number_of_vertices);
    	int adjacency_matrix[][] = new int[number_of_vertices + 1][number_of_vertices + 1];
    	
    	System.out.println("Enter the source and destination of edges");
    	while (count < number_of_edges){
    		source = sc.nextInt();
    		destination = sc.nextInt();
    		adjacencyList.setEdge(source, destination);
    		count++;
    	}
    	
    	// Given Adjacency Matrix for graph
    	System.out.println("Adjacency Matrix for Graph is");
    	System.out.print("  ");
    	for(int k =1; k<=number_of_vertices; k++){
    		System.out.print(k + " ");
    	}
    	for(int j =1; j<=number_of_vertices; j++){
    		List<Integer> source_list = adjacencyList.getEdge(j);
    		System.out.print("\n" + j + " ");
    		for(int x =1; x <= number_of_vertices; x++){
	    		if (source_list.contains(x)){
	    			System.out.print("1 ");
	    			adjacency_matrix[j][x] = 1;
	    		}else{
	    			System.out.print("0 ");
	    			adjacency_matrix[j][x] = 0;
	    		}
    		}
    	}
    	  	
    	// Breadth First Traversal
    	System.out.println("\n\n");
    	System.out.println("Enter the source node for Breadth First Traversal");
    	source_node = sc.nextInt();
    	adjacencyList.bft(adjacency_matrix, source_node);
    	
    	// Depth First Traversal
    	System.out.println("\n\n");
    	System.out.println("Enter the source node for Depth First Traversal");
    	source_node = sc.nextInt();
    	adjacencyList.dft(adjacency_matrix, source_node);
    	sc.close();
    }
}