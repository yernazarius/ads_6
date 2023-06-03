import java.util.*;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public  Vertex(V data) {
        this.data = data;
        adjacentVertices = new HashMap<>();
    }

    public void addAdjacentVertices(Vertex <V> dest, double weight ){
        adjacentVertices.put(dest, weight);
    }
    public boolean containsDest(Vertex<V> v){
        return adjacentVertices.containsKey(v);
    }
    public Double getWeight(Vertex<V> v) {
        return adjacentVertices.get(v);
    }

    public int numberOfEdges(){
        return adjacentVertices.size();
    }

    public V getData() {
        return data;
    }
    public Iterable<V> getAdjacencyList(){
        List<V> vertices = new LinkedList<>();
        for (var e : adjacentVertices.keySet()) {
            vertices.add(e.data);
        }
        return vertices;
    }
    public void setData(V data) {
        this.data = data;
    }
}
