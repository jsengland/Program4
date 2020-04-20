package sample;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * This class implements the Graph210 interface. This class also includes a ctor and toString.
 *
 * @author Jason England
 * @version 4/18/20
 */
public class MyGraph implements Graph210 {
    ArrayList<MyEdge> edgeList;

    /**
     * Ctor for MyGraph
     */
    public MyGraph(){
        edgeList = new ArrayList<MyEdge>();
    }

    /**
     * Returns the number of vertices in the graph; verts are numbered 0 to V-1.
     * @return Returns the number of vertices
     */
    public int numVerts(){
        ArrayList<Integer> vertList = new ArrayList<Integer>();

        for(int i = 0; i < edgeList.size(); i++){
            if(!vertList.contains(edgeList.get(i).getVert1())){
                vertList.add(edgeList.get(i).getVert1());
            }
            if(!vertList.contains(edgeList.get(i).getVert2())){
                vertList.add(edgeList.get(i).getVert2());
            }
        }
        return vertList.size();
    }

    /**
     * Returns the number of edges in the graph; edges are numbered 0 to E-1.
     * @return Returns the number of edges
     */
    public int numEdges(){
        return edgeList.size();
    }

    /**
     * Adds an edge to the graph.
     * @param v1 is vert1, from vert
     * @param v2 is vert2, to vert
     * @param weight Edge weight
     * @return Returns the edge just added; on error, null is returned
     */
    public Edge210 addEdge(int v1, int v2, double weight){
        MyEdge edge = new MyEdge(v1, v2, weight);
        edgeList.add(edge);
        return edge;
    }

    /**
     * Returns a list of edges connected to the vertex.
     * @param v The vertex
     * @return Returns a list of edges connected to the vertex; null is never returned
     * an empty list is returned if 1) no edges, or 2) a bad vert is specified;
     */
    public List<Edge210> edges(int v){
        List<Edge210> vEdges = new ArrayList<Edge210>();
        for(int i = 0; i < numEdges(); i++){
            if(v == edgeList.get(i).getVert1() || v == edgeList.get(i).getVert2()){
                vEdges.add(edgeList.get(i));
            }
        }
        return vEdges;
    }

    /**
     * Returns a list of all edges in the graph.
     * @return Returns a list of all edges; never null
     */
    public List<Edge210> allEdges(){
        return (List)edgeList;
    }

    /**
     * Two steps: 1) Normalize each edge in the graph, and 2) Properly sort all edges.
     * We do this so that we can (easily) compare two normalized graphs.
     */
    public void normalizeEdges(){
        for(int i = 0; i < edgeList.size(); i++){
            edgeList.get(i).normalize();
        }
        Collections.sort(edgeList);
    }

    /**
     *
     * @return Returns the String of the the num of verts on first line, num of edges on second line, and each edge with verts (1 per line).
     */
    public String toString(){
        String s = "";
        s += this.numVerts() + "\n";
        s += this.numEdges() + "\n";
        for(int i = 0; i < this.numEdges(); i++){
            s += edgeList.get(i).getVert1() + " " + edgeList.get(i).getVert2() + " " + edgeList.get(i).getWeight() + "\n";
        }
        return s;
    }
}
