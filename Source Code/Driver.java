public class Driver 
{
    static Graph<String> createGraph(){
        Graph<String> g = new Graph<>(9);

        g.setLabel(0, "A");
        g.setLabel(1, "B");
        g.setLabel(2, "D");
        g.setLabel(3, "E");
        g.setLabel(4, "G");
        g.setLabel(5, "F");
        g.setLabel(6, "H");
        g.setLabel(7, "C");
        g.setLabel(8, "I");

        //add Edges for "A" (A,B)(A,D)(A,E)
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);

        //add Edges for "B" (B,E)
        g.addEdge(1, 3);

        //add Edges for "D" (D,G)
        g.addEdge(2, 4);

        //add Edges for "E" (E,F) (E,H)
        g.addEdge(3, 5);
        g.addEdge(3, 6);

        //add Edges for "G" (G,H)
        g.addEdge(4, 6);
        
        //add Edges for "F" (F,C) (F,H)
        g.addEdge(5, 7);
        g.addEdge(5, 6);

        //add Edges for "H" (H,I)
        g.addEdge(6, 8);

        //add Edges for "C" (C,B)
        g.addEdge(7, 1);


        //add Edges for "I" (I,F)
        g.addEdge(8, 5);

        return g;
    }

    public static void main(String[] args)
    {
        Graph<String> g1 = createGraph();

        System.out.println("\n\nGraph Traversal: Directed Graphs");
        System.out.println("\nTraversing the following graph with verticies and adjacencies:\n");
        g1.printConnections();
        
        System.out.println("====== Breadth First Traversal ======\n");
        
        g1.breadthFirstTraversal("A");

        System.out.println("\n\n\n====== Depth First Traversal ======\n");

        g1.depthFirstTraversal("A");
    }
}
