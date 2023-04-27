import java.util.*;

public class SortingTest {
    static int ARRAY_SIZE;
    static final boolean PRINT_ARRAY = false;

    public static Graph generateDAG(int numNodes) {
        List<Node> nodes = new ArrayList<>();

        // Создание вершин
        for (int i = 0; i < numNodes; i++) {
            nodes.add(new Node(i));
        }

        // Генерация ребер
        Random rand = new Random();
        for (int i = 0; i < numNodes; i++) {
            Node node1 = nodes.get(i);
            for (int j = i + 1; j < numNodes; j++) {
                Node node2 = nodes.get(j);
                // С вероятностью 50% добавляем ребро из node1 в node2
                if (rand.nextInt(2) == 0) {
                    node1.addNeighbor(node2.getId());
                    // Иначе добавляем ребро из node2 в node1
                } else {
                    node2.addNeighbor(node1.getId());
                }
            }
        }

        return new Graph(nodes);
    }
    private static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
    public static void main(String[] args) {
        for(int i = 100; i<1000; i+=10) {
            ARRAY_SIZE = i;
            Graph g = generateDAG(ARRAY_SIZE);

            if (PRINT_ARRAY) {
                System.out.println(g.toString());
            }

            long startTime = System.nanoTime();
            Sorting<Integer> sorting = new topoSort<>();
            List<Integer> gr = sorting.sort(g, Integer::compare);
            long endTime = System.nanoTime();


            System.out.println(g.getSize() + ";" + g.getSizeNei() + ";" + (endTime - startTime) / 1000);
        }
    }
}
