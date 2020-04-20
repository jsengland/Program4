package sample;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * The main() class for Program04, CSC 210 Spring 2020.
 * This class holds the doPrims method and the main method.
 *
 * @author Jason England
 */
public class Program04 {
    /**
     * This main() method just says hello.
     * @param args unused
     */
    public static void main( String[] args) {
        //get desired filename to test from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Available files to test: ");

        File folder = new File("Program4/graphs"); //I found this code online from here: https://javaconceptoftheday.com/list-all-files-in-directory-in-java/
        String[] files = folder.list();
        for (String file : files){
            System.out.println(file);
        }

        //user input section
        System.out.println("Please enter a file name to test (include .txt please): ");
        String userStr = sc.nextLine();
        System.out.println("Please enter desired starting vertex: ");
        int userInt = sc.nextInt();

        //Gets the graph and uses doPrims method
        MyGraph graph1 = (MyGraph)GraphHelper.readGraphFile("Program4/graphs/" + userStr);
        System.out.println(doPrims(graph1, userInt));


    }

    /**
     *
     * @param g The graph to pass in and find the prim's min spanning tree.
     * @param startVert The vert that you want to start at for the Prim's min spanning tree.
     * @return Returns a graph of the final Prim's min spanning tree.
     */
    public static Graph210 doPrims(Graph210 g, int startVert){ //doesn't consider weight in finding min Prim. I got confused with all of the variables.
        g.normalizeEdges();
        boolean[] visitList = new boolean[g.numVerts()];
        double[] weightList = new double[g.numVerts()];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Graph210 graph = new MyGraph();
        //ArrayList<MyEdge> temp = new ArrayList<MyEdge>();

        pq.add(startVert);
        while(!pq.isEmpty()) {
            int curV = pq.poll();
            visitList[curV] = true;

            ArrayList<Edge210> edgeList = (ArrayList<Edge210>) g.edges(curV);
            for (Edge210 e : edgeList) {
                if (visitList[e.otherVert(curV)] == false) {
                    graph.addEdge(curV, e.otherVert(curV), e.getWeight());
                    //temp.add(new MyEdge(curV, e.otherVert(curV), e.getWeight()));
                    pq.add(e.otherVert(curV));
                    visitList[e.otherVert(curV)] = true;
                }

            }
        }
        return graph;
    }

}
