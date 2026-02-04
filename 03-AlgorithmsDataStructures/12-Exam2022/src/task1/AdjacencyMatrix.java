package task1;

public class AdjacencyMatrix {
	private int[][] adjMatrix;
	
	AdjacencyMatrix(int[][] data) {
		adjMatrix = data;
	}
	
	public int get(int v, int u) {
		return adjMatrix[v][u];
	}
	
	public int numOfVertices() {
		return adjMatrix.length;
	}
	
	public boolean weightsOfNeighbours(int v, int relativeWeight) {
		int amountNeighbours = 0;
		
		for (int i = 0; i < numOfVertices(); i++) {
			if (adjMatrix[v][i] == 1) {
				amountNeighbours++;
			}
		}
		// TODO later extend this algorithm to check the whole matrix and verify that you're not repeating values
		
		if (amountNeighbours < relativeWeight) {
			return true;
		} else {
			return false;
		}
	}
	
	public void forAllVertices(int relativeWeight) {
		for (int v = 0; v < numOfVertices(); v++) {			
			System.out.println("Vertex " + v + ": " + weightsOfNeighbours(v, relativeWeight));
		}
	}
	
	public static void main(String[] args) {		
		final int H = 0;
		int[][] data = {
				{H, 0, 0, 1, 1},
				{0, H, 1, 0, 0}, 
				{1, 0, H, 0, 1}, 
				{0, 0, 0, H, 1},
				{1, 0, 0, 0, H}};
		
		int w = 2;
		
		AdjacencyMatrix adjMatrix = new AdjacencyMatrix(data);
		
		System.out.println("Total number of vertices: " + adjMatrix.numOfVertices());
		System.out.println("\nDo the neighbours of v0 have less weight than 1?: " + adjMatrix.weightsOfNeighbours(0, w));
		System.out.println("\nIs it true for every vertice?");
		
		adjMatrix.forAllVertices(w);
	}
}