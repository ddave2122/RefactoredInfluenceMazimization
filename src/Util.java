import java.util.Hashtable;
import java.util.LinkedList;

public class Util {

    //The array should be sorted by node number at this point
    public Node[] convertStringArrayToNodeArray(String[] arrayToConvert)
    {
        LinkedList<Node> nodeList = new LinkedList<>();
        String[] splitElement;
        Hashtable<Integer, Double> neighbors;

        for(int i = 0; i < arrayToConvert.length; i++)
        {
            neighbors = new Hashtable<>();
            splitElement = arrayToConvert[i].split(",");
            if(splitElement.length != 3)
                System.out.println("Import Error for: " + arrayToConvert[i]);
            int vertexNumber = Integer.parseInt(splitElement[0]);

            //Add the neighbor to the table
            neighbors.put(Integer.parseInt(splitElement[1]), Double.valueOf(splitElement[2]));

            //Continue to add neighbors while they exist
            while((i < arrayToConvert.length -1) && splitElement[0].equals(arrayToConvert[i+1].split(",")[0]))
            {
                splitElement = arrayToConvert[++i].split(",");
                neighbors.put(Integer.parseInt(splitElement[1]), Double.valueOf(splitElement[2]));
            }
            nodeList.add(new Node(vertexNumber, neighbors));
        }
        return nodeList.toArray(new Node[nodeList.size()]);
    }


}
