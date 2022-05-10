import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DriverTest 
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

    @Test
    public void testbreadthFirstTraversal()
    {
        Graph<String> g1 = createGraph();
        System.out.println("====== Breadth First Traversal ======\n");
        g1.breadthFirstTraversal("A");
        String result = g1.breadthFirstTraversal("A");
        String expected = "Breadth First Traversal - starting from vertex"+"A\nA B D E G F H C I";

        assertEquals(expected, result);
    }

    @Test
    public void testdepthFirstTraversal()
    {
        Graph<String> g1 = createGraph();
        System.out.println("\n\n\n====== Depth First Traversal ======\n");
        g1.depthFirstTraversal("A");

        String result = g1.depthFirstTraversal("A");
        String expected = "Depth First Traversal - starting from vertex"+"A\nA B E F H I C D G";

        assertEquals(expected, result);
    }
}
