import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphAlgorithms {

    public static <V> int[] shortestPathWeights(Graph<V> graph, V v) {
        List<Integer> exploredVertexIndexes = new ArrayList<>();
        int[] cost = new int[graph.getSize()];
        Arrays.fill(cost, Integer.MAX_VALUE); //Sætter alle værdi i cost til "uendelig" (En meget høj værdi)

        int sourceVertexIndex = graph.getIndex(v);
        cost[sourceVertexIndex] = 0; //Sætter kilde noden til 0;

        while (exploredVertexIndexes.size() != graph.getSize()) {
            int minCostIndex = -1;

            for (int i = 0; i < graph.getSize(); i++) {
                if (!exploredVertexIndexes.contains(i) && (minCostIndex == -1 || cost[i] < cost[minCostIndex])) {
                    minCostIndex = i;
                }
            }

            for (Edge edge : graph.getIncidentEdges(graph.getVertex(minCostIndex))) {
                int neighborIndex;

                if (edge.endVertexIndex == minCostIndex) {
                    neighborIndex = graph.getIndex(graph.getVertex(edge.startVertexIndex));
                } else {
                    neighborIndex = graph.getIndex(graph.getVertex(edge.endVertexIndex));
                }

                if (!exploredVertexIndexes.contains(neighborIndex)) {

                    int newCost = cost[minCostIndex] + edge.getWeight();

                    if (newCost < cost[neighborIndex]) {
                        cost[neighborIndex] = newCost;
                    }
                }
            }

            exploredVertexIndexes.add(minCostIndex);
        }

        return cost;
    }
}