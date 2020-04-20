package sample;
/**
 * This class implements the Edge210 interface. This class also includes a ctor, a compareTo, and an equals.
 *
 * @author Jason England
 * @version 4/18/20
 */
public class MyEdge implements Edge210, Comparable<MyEdge> {
    int vert1,vert2;
    double weight;

    /**
     * Ctor for MyEdge
     */
    public MyEdge(int v1, int v2, double w){
        vert1 = v1;
        vert2 = v2;
        weight = w;
    }

    /**
     * Returns the first "from" vert on the edge.
     * @return Returns the first vert
     */
    public int getVert1(){
        return vert1;
    }

    /**
     * Returns the second "to" vert on the edge.
     * @return Returns the second vert
     */
    public int getVert2(){
        return vert2;
    }

    /**
     * Returns the edge weight, a positive number (greater than 0)
     * @return Returns the edge weight
     */
    public double getWeight(){
        return weight;
    }

    /**
     * Returns the "other" vertex in the edge
     * @param v This vert
     * @return Returns the other vert; if v is not on the edge, then vert1 is returned
     */
    public int otherVert( int v){
        if(v == vert1){
            return vert2;
        }
        return vert1;
    }

    /**
     * Returns true if vert is part of the edge.
     * @param v The vert to check
     * @return Returns true if part of edge
     */
    public boolean hasVert( int v){
        if(v == vert1 || v == vert2){
            return true;
        }
        return false;
    }

    /**
     * Normalize the edge by ordering its verts, smallest first.
     * Warning: Only use for UNDIRECTED graphs!
     */
    public void normalize(){
        int temp = 0;
        if(vert1 > vert2){
            temp = vert1;
            vert1 = vert2;
            vert2 = temp;
        }
    }

    /**
     *
     * @param edge the edge you want to compare against.
     * @return Returns positive than this.getWeight() is greater than
     */
    public int compareTo(MyEdge edge){
        return (int)this.getWeight() - (int)edge.getWeight();
    }

    /**
     *
     * @param edge the edge you want to check against.
     * @return Returns true if the edgest are equal in weight and verts
     */
    public boolean equals(MyEdge edge){
        if(this.getVert1() == edge.getVert1() && this.getVert2() == edge.getVert2() && this.getWeight() == edge.getWeight()){
            return true;
        }
        return false;
    }
}
