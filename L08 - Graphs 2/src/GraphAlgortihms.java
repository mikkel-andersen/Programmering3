import java.util.*;

public class GraphAlgortihms {

    /**
     * Returnerer en liste af grafens knuder fundet ved et dybdeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> dfs(Graph<V> graph, V v) {
        List<V> visited = new ArrayList<>();
        dfsHelper(graph, v, visited); //Kalder hjælpemetode
        return visited;
    }

    private static <V> void dfsHelper(Graph<V> graph, V v, List<V> visited) {
        visited.add(v);

        for (V neighbor : graph.getNeighbors(v)) { //For hver nabo, tjekker den om den er besøgt
            if (!visited.contains(neighbor)) { //Hvis ikke den er besøgt bliver metoden kaldt med den aktuelle neighbor
                dfsHelper(graph, neighbor, visited);
            }
        }
    }

    /**
     * Returnerer en liste af grafens knuder fundet ved et breddeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> bfs(Graph<V> graph, V v) {
        // TODO Opgave 3
        Queue<V> queue = new ArrayDeque<>();
        List<V> visited = new ArrayList<>();

        queue.add(v);

        while (!queue.isEmpty()) {
            V current = queue.remove();
            visited.add(current);
            System.out.println(visited);
            for (V neighbor : graph.getNeighbors(current)) {
                if (!visited.contains(neighbor) && !queue.contains(neighbor)) {
                    queue.add(neighbor);

                }
            }
        }
        return visited;
    }

    /**
     * Returnerer om grafen er sammenhængende
     * Pre: Grafen er ikke tom
     */
    public static <V> boolean connected(Graph<V> graph) {
        // TODO Opgave 4
        return false;
    }

    /**
     * Returnerer om der er en vej fra v1 til v2 i graph
     */
    public static <V> boolean isPath(Graph<V> graph, V v1, V v2) {
        // TODO Opgave 5
        return false;
    }
}