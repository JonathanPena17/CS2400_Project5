public class Graph<E>
{
    private boolean[][] edges; // edges[i][j] is true if there is a vertex from i to j
    private E[] labels; // labels[i] contains the label for vertex i  
 
    //** Constructor: */
    public Graph(int n) {
        edges = new boolean[n][n]; // All values initially false
        labels = (E[]) new Object[n]; // All values initially null
    }
    

    //**Boolean Method: */

    //Test whether an edge exists
    public boolean isEdge(int source, int target) {
        return edges[source][target];
    }
    
    //** Methods: */
   
    // Add an edge
    public void addEdge(int source, int target) {
        edges[source][target] = true;
    }

    //Accessor method to get the label of a vertex of this Graph 
    public E getLabel(int vertex) {
        return labels[vertex];
    }

     //Obtain a list of neighbors of a specified vertex of this Graph
     public int[] neighbors(int vertex) {
        int i;
        int count = 0;
        int[] answer;
        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i])
                count++;
        }
        answer = new int[count];
        count = 0;
        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i])
                answer[count++] = i;
        }
        return answer;
    }

     // Remove an edge
     public void removeEdge(int source, int target) {
        edges[source][target] = false;
    }
    
    // Change the label of a vertex of this Graph
     public void setLabel(int vertex, E newLabel) {
        labels[vertex] = newLabel;
    }

    //Accessor method to determine the number of vertices in this Graph
    public int size() {
        return labels.length;
    }

    //** Implementation of BFS */
    public QueueInterface<T> getBreadthFirstTraversal(T origin)
    {
    resetVertices();
    QueueInterface<T> traversalOrder = new LinkedQueue<>(); 
    QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>(); 
    VertexInterface<T> originVertex = vertices.getValue(origin); 
    originVertex.visit();
    traversalOrder.enqueue(origin); // Enqueue vertex label 
    vertexQueue.enqueue(originVertex); // Enqueue vertex
    while (!vertexQueue.isEmpty())
    {
        VertexInterface<T> frontVertex = vertexQueue.dequeue(); 
        Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator(); 
        while (neighbors.hasNext())
        {
            VertexInterface<T> nextNeighbor = neighbors.next(); 
            if (!nextNeighbor.isVisited())
            {
                nextNeighbor.visit(); 
                traversalOrder.enqueue(nextNeighbor.getLabel()); 
                vertexQueue.enqueue(nextNeighbor);
            }// end if
        } //end while 
    } // end while
    return traversalOrder;
    } // end getBreadthFirstTraversal

    //** Implementation of DFS */

    public QueueInterface<T> getDepthFirstTraversal(T origin)
    {
        //assume graph is not empty
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<>(); 
        StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<>();

        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin); //Enqueue Vertex Label
        vertexStack.push(originVertex); //Enqueue Vertex

        while(!vertexStack.isEmpty())
        {
            VertexInterface<T> topVertex = vertexStack.peek();
            VertexInterface<T> nextNeighbor = topVertex.getUnvistedNeighbor();

            if (nextNeighbor!= null)
            {
                nextNeighbor.visit();
                traversalOrder.enqueue(nextNeighbor.getlabel());
                vertexStack.push(nextNeighbor);
            }
            else // All neighbors are visited
                vertexStack.pop();
        } // end while
        return traversalOrder;
    } // end GetDepthFirstTraversal

} // End Graph
