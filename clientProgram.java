package graphPrograms;

public class clientProgram {
	public static void main(String[] args) {
	
		Graph graph = new Graph(); // New graph created
		// Adding all the neighbors
		graph.addEdge("B","A");
		graph.addEdge("B","C");
		
		graph.addEdge("C","F");
		
		graph.addEdge("D","A");
		
		graph.addEdge("E","A");
		graph.addEdge("E","B");
		
		graph.addEdge("F","E");
		graph.addEdge("F","I");
		
		graph.addEdge("G","D");
		
		graph.addEdge("H","G");
		graph.addEdge("H","E");
		graph.addEdge("H","F");
		
		graph.addEdge("I","H");
		
		String[] neighborsE = graph.getNeighbors("E"); // Using getNeighbor method to move copy of all the neighbors of node E to an array
		
		System.out.println("Neighbors of vertex E: "+neighborsE[0] + ", "+ neighborsE[1]); // Output
	}
}
