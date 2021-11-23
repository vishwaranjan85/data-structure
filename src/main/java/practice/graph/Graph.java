package practice.graph;

public class Graph {
	
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;
	private int[][] edges;
	private int nVerts;

	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		edges = new int[MAX_VERTS][MAX_VERTS];
	}
	
	public void addVertex(char label){
		vertexList[nVerts++] = new Vertex(label);
	}
	
	public void addEdge(int start, int end, boolean bidirectional){
		edges[start][end] = 1;
		if(bidirectional){
			edges[end][start] = 1;
		}
	}
	
	public void displayVertex(int vertex){
		System.out.println(vertexList[vertex].label+ " ");
	}
	
	public int getAdjUnvisitedVertex(int vertex){
		for(int j=0; j<nVerts;j++){
			if(edges[vertex][j]==1 && !vertexList[j].visited){
				return j;
			}
		}
		return -1;
	}
	

	
	public Vertex[] getVertexList() {
		return vertexList;
	}

	public void setVertexList(Vertex[] vertexList) {
		this.vertexList = vertexList;
	}

	public int[][] getEdges() {
		return edges;
	}

	public void setEdges(int[][] edges) {
		this.edges = edges;
	}
}
