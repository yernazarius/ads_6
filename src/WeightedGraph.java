import java.util.*;

public class WeightedGraph<V> {
   private final boolean undirected;
   private Map<V, Vertex<V>> map = new HashMap<>();
   public WeightedGraph() {
       this.undirected = true;
    }
    public WeightedGraph(boolean undirected) {
       this.undirected = undirected;
    }

    public void addVertex(V data) {
       Vertex<V> newvert = new Vertex<>(data);
       map.put(data, newvert);
    }

    public void addEdge(V source, V dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasWeightedEdge(source, dest) || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).addAdjacentVertices(map.get(dest), weight);

        if (undirected)
            map.get(dest).addAdjacentVertices(map.get(source), weight);
    }


    public int getEdgesCount() {
        int count = 0;
        for (V v : map.keySet()) {
            count += map.get(v).numberOfEdges();
        }

        if (undirected)
            count /= 2;

        return count;
    }
    public boolean hasVertex( V data) {

       return map.containsKey(data);
    }
    public Iterable<V> AdjacencyList(V v) {
        if (!hasVertex(v))
            return null;
        return map.get(v).getAdjacencyList();
    }

    public Map<V, Vertex<V>> getMap() {
        return map;
    }

    public Vertex<V> getVertex(V v){
        return map.get(v);
    }

    public boolean hasWeightedEdge(V source, V dest) {
        if (!hasVertex(source))
            return false;
        return map.get(source).containsDest(new Vertex<>(dest));
    }




}