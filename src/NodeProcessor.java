import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class NodeProcessor {

    private final boolean useSimpleInfluence = true;
    private Node[] nodesToProcess;
    private Node[] indexedNodes;

    public void processNodes(Node[] nodes, int numberOfSeeds)
    {

        this.nodesToProcess = nodes;

        //Calculate the total influence each node has
        calculateTotalInfluence();
        this.indexedNodes = nodesToProcess;

        //TODO create a dictionary linking vertex number to index positions

        Arrays.sort(nodesToProcess);

        for(int i = 0; i < numberOfSeeds; i++)
        {
            Node node = nodesToProcess[i];
            node.setLastInfluenceTime(1);
            node.setActive(true);
            for(Map.Entry<Integer, Double> map : node.getVertexNeighbors().entrySet())
            {
                //Attempt to influence another node
                attemptInfluence(map.getKey(), map.getValue(), node.getLastInfluenceTime());
                //increment the time for the node
                node.setLastInfluenceTime(node.getLastInfluenceTime()+1);
            }
            node.setExhaustedInfluenceAttempts(true);

            nodesToProcess[i] = node;
        }
        int foo = 0;
    }

    private Node[] calculateTotalInfluence()
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

    public double calculateInfluence(int nodeNumber, double currentInfluence, long currentTime)
    {
        if(useSimpleInfluence)
        {
            long lastInfluenceTime = nodesToProcess[nodeNumber].getLastInfluenceTime();
            double pastInfluence = nodesToProcess[nodeNumber].getSimplePastInfluences();

            if (nodesToProcess[nodeNumber].isActive()) {
                System.out.println("Node " + nodesToProcess[nodeNumber].getVertexNumber() + " is already active!");
                return -1;
            }

            double newInfluence = (1/(currentTime - lastInfluenceTime))*pastInfluence + currentInfluence;

            return newInfluence;

        }
        return -1;
    }

    public void attemptInfluence(int nodeNumber, double currentInfluence, long currentTime)
    {
        //Sanity check
        if(nodesToProcess[nodeNumber].isActive())
        {
            System.out.println("Node " + nodesToProcess[nodeNumber].getVertexNumber() + " is already active!");
            return;
        }
        double newInfluence = calculateInfluence(nodeNumber, currentInfluence, currentTime);

        if(newInfluence >= Math.random())
        {
            nodesToProcess[nodeNumber].setActive(true);
        }
        else
        {
            nodesToProcess[nodeNumber].setSimplePastInfluences(nodesToProcess[nodeNumber].getSimplePastInfluences() + newInfluence);
            nodesToProcess[nodeNumber].setActive(false);
        }
    }

}
