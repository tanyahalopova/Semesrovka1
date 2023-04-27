import java.util.*;

public class topoSort<T> implements Sorting<T> {
    public List<Integer> sort(Graph g, Comparator<? super T> c) {

        int V = g.getSize();
        List<Integer> order = new ArrayList<>();

        Map<Integer, Boolean> visited = new HashMap<>();
        for (Node tmp: g.getNodes())
            visited.put(tmp.getId(), false);

        for (Node tmp: g.getNodes()) {
            if (!visited.get(tmp.getId()))
                blackMagic(g, tmp.getId(), visited, order);
        }


        Collections.reverse(order);
        return order;
    }

    private static void blackMagic(Graph g, int v, Map<Integer, Boolean> visited, List<Integer> order) {
        visited.replace(v, true);
        Integer i;
        for (Integer neighborId: g.getNode(v).getNeighbors()) {
            if (!visited.get(neighborId)) {
                blackMagic(g, neighborId, visited, order);
            }
        }

        order.add(v);
    }
}
