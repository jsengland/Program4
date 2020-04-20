package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * These are Helper methods for Program 04.
 * This is optional. It's just one way to set this up.
 * It's also a place where I can share more P4 Helper code.
 *
 * @author Prof Bill, Cole P, Dev T, Luis G, Jason E
 * @version 0.2
 */
public class GraphHelper {
    /**
     * Read a directed graph from a file.
     *
     * The format of the file is from Sedgewick, algs4.cs.princeton.edu/43mst:
     *   num-vertices
     *   num-edges
     *   v1 v2 weight   // one line per edge
     *
     * @param fileName name of graph file
     * @return Returns a new Graph210, or null on error
     */
    public static Graph210 readGraphFile( String fileName){
        try {
            MyGraph graph = new MyGraph();
            Scanner sc = new Scanner(new File(fileName));
            int numV = sc.nextInt();
            int numE = sc.nextInt();
            for (int i = 0; i < numE; i++) {
                graph.addEdge(sc.nextInt(), sc.nextInt(), sc.nextDouble());
            }
            return graph;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns true if two graphs are equal.
     * Graph edges are normalized (aka, changed) by this method.
     * Once normalized, equal graphs will have exactly equal edges.
     *
     * @param g1 Graph one
     * @param g2 Graph two
     * @return Returns true if they are equal
     */
    public static boolean compareGraphs( Graph210 g1, Graph210 g2) {
        g1.normalizeEdges();
        g2.normalizeEdges();
        List<Edge210> g1List = g1.allEdges();
        List<Edge210> g2List = g2.allEdges();
        if(g1List.size() != g2List.size()){
            return false;
        }
        for(int i = 0; i < g1List.size(); i++){
            if(!g1List.get(i).equals(g2List.get(i))) {
                return false;
            }
        }
        return true;
    }
}
