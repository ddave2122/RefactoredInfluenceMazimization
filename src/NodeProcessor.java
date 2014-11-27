import java.util.Arrays;
import java.util.Map;

public class NodeProcessor {

    public void processNodes(Node[] nodesToProcess, int numberOfSeeds)
    {
        //Calculate the total influence each node has
        nodesToProcess = calcualteTotalInfluence(nodesToProcess);

        //Run the tests
        Arrays.sort(nodesToProcess);

        for(int i = 0; i < numberOfSeeds; i++)
        {
            Node node = nodesToProcess[i];
            
        }


    }

    private Node[] calcualteTotalInfluence(Node[] nodesToProcess)
    {
        double totalInfluence;
        for(Node node : nodesToProcess)
        {
            totalInfluence = 0;
            for(Map.Entry<Integer, Double> map : node.getVertexNeighbors().entrySet())
            {
                totalInfluence += map.getValue();
            }
            node.setTotalNeighborInfluence(totalInfluence);
        }
        return nodesToProcess;
    }
}
