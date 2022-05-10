public class Driver 
{
    public static void main(String []args) 
    {
        //Adjancy Matrix
        MatrixGraph matrixGraph = new MatrixGraph(9);

        matrixGraph.setLabel(0, 'A');
        matrixGraph.setLabel(1, 'B');
        matrixGraph.setLabel(2, 'D');
        matrixGraph.setLabel(3, 'E');
        matrixGraph.setLabel(4, 'G');
        matrixGraph.setLabel(5, 'F');
        matrixGraph.setLabel(6, 'H');
        matrixGraph.setLabel(7, 'C');
        matrixGraph.setLabel(8, 'I');

        //add Edges for "A" (A,B)(A,D)(A,E)
        matrixGraph.addEdge(0, 1);
        matrixGraph.addEdge(0, 2);
        matrixGraph.addEdge(0, 3);

        //add Edges for "B" (B,E)
        matrixGraph.addEdge(1, 3);

        //add Edges for "D" (D,G)
        matrixGraph.addEdge(2, 4);

        //add Edges for "E" (E,F) (E,H)
        matrixGraph.addEdge(3, 5);
        matrixGraph.addEdge(3, 6);

        //add Edges for "G" (G,H)
        matrixGraph.addEdge(4, 6);
        
        //add Edges for "F" (F,C) (F,H)
        matrixGraph.addEdge(5, 7);
        matrixGraph.addEdge(5, 6);

        //add Edges for "H" (H,I)
        matrixGraph.addEdge(6, 8);

        //add Edges for "C" (C,B)
        matrixGraph.addEdge(7, 1);


        //add Edges for "I" (I,F)
        matrixGraph.addEdge(8, 5);

        System.out.println("\n*****Adjacency Matrix*****\n");
        
        System.out.println("\n====== Breadth First Traversal ======\n");

        LinkedQueue traversalBreadth1 = matrixGraph.getBreadthFirstTraversal(0);

        printTraversalLabels_forMatrix(matrixGraph, traversalBreadth1);

        System.out.println("\n====== Depth First Traversal ======\n");

        LinkedQueue traversalDepth1 = matrixGraph.getDepthFirstTraversal(0);

        printTraversalLabels_forMatrix(matrixGraph, traversalDepth1);

        // Adjacency List 
        ListGraph graphList = new ListGraph(9);

        graphList.setLabel(0, 'A');
        graphList.setLabel(1, 'B');
        graphList.setLabel(2, 'D');
        graphList.setLabel(3, 'E');
        graphList.setLabel(4, 'G');
        graphList.setLabel(5, 'F');
        graphList.setLabel(6, 'H');
        graphList.setLabel(7, 'C');
        graphList.setLabel(8, 'I');

        //add Edges for "A" (A,B)(A,D)(A,E)
        graphList.addEdge(0, 1);
        graphList.addEdge(0, 2);
        graphList.addEdge(0, 3);

        //add Edges for "B" (B,E)
        graphList.addEdge(1, 3);

        //add Edges for "D" (D,G)
        graphList.addEdge(2, 4);

        //add Edges for "E" (E,F) (E,H)
        graphList.addEdge(3, 5);
        graphList.addEdge(3, 6);

        //add Edges for "G" (G,H)
        graphList.addEdge(4, 6);
        
        //add Edges for "F" (F,C) (F,H)
        graphList.addEdge(5, 7);
        graphList.addEdge(5, 6);

        //add Edges for "H" (H,I)
        graphList.addEdge(6, 8);

        //add Edges for "C" (C,B)
        graphList.addEdge(7, 1);


        //add Edges for "I" (I,F)
        graphList.addEdge(8, 5);

        
        
        //Print
        System.out.println("\n*****Adjacency List*****\n");

        System.out.println("\n====== Breadth First Traversal ======\n");

        LinkedQueue traversalBreadth = graphList.getBreadthFirstTraversal(0);

        printTraversalLabels_forList(graphList, traversalBreadth);

        System.out.println("\n====== Depth First Traversal ======\n");

        LinkedQueue traversalDepth = graphList.getDepthFirstTraversal(0);

        printTraversalLabels_forList(graphList, traversalDepth);

        System.out.println();


    }

    public static void printTraversalLabels_forMatrix(MatrixGraph matrixGraph, LinkedQueue traversal) {

        for (int i = 0; i < matrixGraph.getSize(); i++) {
            int vertex = traversal.dequeue();
            char label = matrixGraph.getLabel(vertex);

            System.out.print(label + " ");
        }

        System.out.println();
    }

    public static void printTraversalLabels_forList(ListGraph listGraph, LinkedQueue traversal) {

        for (int i = 0; i < listGraph.getSize(); i++) {
            int vertex = traversal.dequeue();
            char label = listGraph.getLabel(vertex);

            System.out.print(label + " ");
        }

        System.out.println();
    }
}
