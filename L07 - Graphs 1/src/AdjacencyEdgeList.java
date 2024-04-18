import java.util.ArrayList;
import java.util.List;

public class AdjacencyEdgeList implements Graph{
    List<List<Edge>> adjacencyList = new ArrayList<>();
    @Override
    public int getSize() {
        return adjacencyList.size();
    }

    @Override
    public int getNumEdges() {
        int numEdges = 0;
        for (List<Edge> edges : adjacencyList) {
            numEdges += edges.size();
        }
        return numEdges;
    }

    @Override
    public List<Integer> getVertices() {
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < getSize(); i++) {
            vertices.add(i);
        }
        return vertices;
    }

    @Override
    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < adjacencyList.size(); i++) {
            for (Edge edge : adjacencyList.get(i)) {
                if (edge.getV() > i) {
                    edges.add(edge);
                }
            }
        }
        return edges;
    }

    @Override
    public Object getVertex(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return index;
    }

    @Override
    public int getIndex(Object o) {
        return 0;
    }

    @Override
    public Object getMaxVertex() {
        return null;
    }

    @Override
    public List getNeighbors(Object o) {
        return List.of();
    }

    @Override
    public List<Integer> getNeighborsIndex(Object o) {
        return List.of();
    }

    @Override
    public List<Edge> getIncidentEdges(Object o) {
        return List.of();
    }

    @Override
    public int getDegree(Object o) {
        return 0;
    }

    @Override
    public void printEdges() {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean addVertex(Object vertex) {
        return false;
    }

    @Override
    public boolean addEdge(int u, int v, int e) {
        return false;
    }

    @Override
    public boolean addEdge(int u, int v) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean remove(int u, int v) {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
