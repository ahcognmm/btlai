import java.util.*;

public class AstarSearchAlgo {

    public List<Node> printPath(Node target) {
        List<Node> path = new ArrayList<Node>();

        for (Node node = target; node != null; node = node.parent) {
            path.add(node);
        }

        Collections.reverse(path);

        return path;
    }

    public void AstarSearch(Node source, Node goal) {

        Set<Node> explored = new HashSet<Node>();

        //override compare method
        PriorityQueue<Node> queue = new PriorityQueue<Node>(20,
                (i, j) -> {
                    if (i.f_scores > j.f_scores) {
                        return 1;
                    } else if (i.f_scores < j.f_scores) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
        );

        //cost from start
        source.g_scores = 0;

        queue.add(source);

        boolean found = false;

        while ((!queue.isEmpty()) && (!found)) {

            //the node in having the lowest f_score value
            Node current = queue.poll();

            explored.add(current);

            //goal found
            if (current.value.equals(goal.value)) {
                found = true;
            }


            //check every child of current node
            for (Edge e : current.adjacencies) {
                Node child = e.target;
                double cost = e.cost;
                double temp_g_scores = current.g_scores + cost;
                double temp_f_scores = temp_g_scores + child.h_scores;


                                /*if child node has been evaluated and 
                                the newer f_score is higher, skip*/

                if ((explored.contains(child)) &&
                        (temp_f_scores >= child.f_scores)) {
                    continue;
                }

                                /*else if child node is not in queue or 
                                newer f_score is lower*/

                else if ((!queue.contains(child)) ||
                        (temp_f_scores < child.f_scores)) {

                    child.parent = current;
                    child.g_scores = temp_g_scores;
                    child.f_scores = temp_f_scores;

                    if (queue.contains(child)) {
                        queue.remove(child);
                    }

                    queue.add(child);

                }

            }

        }

    }

}

class Node {

    public final String value;
    public double g_scores;
    public final double h_scores;
    public double f_scores = 0;
    public ArrayList<Edge> adjacencies = new ArrayList<>();
    public Node parent;

    public Node(String val, double hVal) {
        value = val;
        h_scores = hVal;
    }

    public String toString() {
        return value;
    }

}

class Edge {
    public final double cost;
    public final Node target;

    public Edge(Node targetNode, double costVal) {
        target = targetNode;
        cost = costVal;
    }

    @Override
    public String toString() {
        return target.value;
    }
}