package graphPrograms;

public class Graph {
	private int numberOfVertices = 9; // Default number of vertices is 9, but can be changed later
	// Creates new array that contains all the nodes. +1 is to leave [0] empty
	Node[] listOfNodes = new Node[numberOfVertices + 1]; 
	
	public Graph() { // Default constructor if the user doesn't have a custom size they want
		for (int i = 1; i < numberOfVertices + 1; i++) {
			listOfNodes[i] = new Node(null); // Sets all the node entries as null nodes
		}
	}
	
	public Graph(int userNumOfVertices) { // Constructor if user has size they want the graph to be
		numberOfVertices = userNumOfVertices + 1; // Sets numberOfVertices to the users number. +1 for array offset
		listOfNodes = new Node[userNumOfVertices];
		for (int i = 1; i < numberOfVertices + 1; i++) {
			listOfNodes[i] = new Node(null); // Sets all the node entries as null nodes
		}
	}
	
	// Changes the inputted character, such as A or B to their respective place in alphabetic
	// order Ex: A or a would be 1, B or b would be 2, etc...
	public int stringToUsableInt(String stringSource) { 
		String upperCase = stringSource.toUpperCase();
		char c = upperCase.charAt(0);
		int integer = c - 64; // -64 since capital letters are 64 numbers ahead of their 
		// alphanumerical position
		return integer;
	}
	
	// Gets the number of neighbors a vertex has
	public int getNumNeighbors(String requestedVertex) {
		int numNeighbors = 0;
		int locationOfVertex = stringToUsableInt(requestedVertex); // Gets alphanumerical location of requested vertex
		Node tempNode = listOfNodes[locationOfVertex];
		String tempString = tempNode.getData(); // Temp variables to make it easier for reading the code
		while(tempString != null) { // If the next node is null then exit while loop
			numNeighbors++; // Increases number of neighbor variable by 1
			tempNode = tempNode.getNextNode();
			tempString = tempNode.getData();
		}
		return numNeighbors; // Returns number of neighbors a node has
	}
	
	public void addEdge(String Source, String newNeighbor) { // Adds a new edge between a source and a user inputted variable
		int sourceAsInt = stringToUsableInt(Source);
		Node newInput = new Node(newNeighbor); // Stores the new input as its own node temporarily
		newInput.setNextNode(listOfNodes[sourceAsInt]);
		listOfNodes[sourceAsInt] = newInput; // End result has the previous node behind the new node. Thats why the output is reverse from the inputted way
	}

	public String[] getNeighbors(String requestedVertex) { // Gets the neighbors a vertex has and returns them in an array
		int numNeighbors = getNumNeighbors(requestedVertex); // Number of neighbors
		String[] neighborList = new String[numNeighbors + 1]; // + 1 for the array offset
		int locationOfVertex = stringToUsableInt(requestedVertex); // Gets alphanumerical location of vertex to be used in node array
		Node tempNode = listOfNodes[locationOfVertex];
		String tempString = tempNode.getData();
		int i = 0;
		while(tempString != null) { // Prevents error from happening. Copies neighbors for selected vertex into array and returns it
			neighborList[i] = tempString;
			i++;
			tempNode = tempNode.getNextNode();
			tempString = tempNode.getData();
		} 

		return neighborList;
	}

	// Node class copied from previous lectures and projects.
	private class Node {
		private String data;
		private Node next;

		public Node(String dataPortion) {
			this(dataPortion, null);
		}

		public Node(String dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}

		public String getData() {
			return data;
		}

		public Node getNextNode() {
			return next;
		}


		public void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}
}
