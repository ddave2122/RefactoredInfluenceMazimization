import java.util.Hashtable;

public class Node implements Comparable<Node>{

    private int vertexNumber;
    private Hashtable<Integer, Double> vertexNeighbors;  //Represents neighbors
    private Hashtable<Long, Double> pastInfluences;  //Represents previous influence attempts
    private long lastInfluenceTime;
    private double simplePastInfluences;
    private boolean isActive;
    private double totalNeighborInfluence;
    private boolean exhaustedInfluenceAttempts;

    public boolean isExhaustedInfluenceAttempts() {
        return exhaustedInfluenceAttempts;
    }

    public void setExhaustedInfluenceAttempts(boolean exhaustedInfluenceAttempts) {
        this.exhaustedInfluenceAttempts = exhaustedInfluenceAttempts;
    }

    //Used for sorting
    public int compareTo(Node nodeCompare)
    {
        return Double.compare(nodeCompare.getTotalNeighborInfluence(), this.totalNeighborInfluence);
    }

    public double getTotalNeighborInfluence() {
        return totalNeighborInfluence;
    }

    public void setTotalNeighborInfluence(double totalNeighborInfluence) {
        this.totalNeighborInfluence = totalNeighborInfluence;
    }

    public double getSimplePastInfluences() {
        return simplePastInfluences;
    }

    public void setSimplePastInfluences(double simplePastInfluences) {
        this.simplePastInfluences = simplePastInfluences;
    }

    public long getLastInfluenceTime() {
        return lastInfluenceTime;
    }

    public void setLastInfluenceTime(long lastInfluenceTime) {
        this.lastInfluenceTime = lastInfluenceTime;
    }

    public Hashtable<Integer, Double> getVertexNeighbors() {
        return vertexNeighbors;
    }

    public void setVertexNeighbors(Hashtable<Integer, Double> vertexNeighbors) {
        this.vertexNeighbors = vertexNeighbors;
    }

    public Hashtable<Long, Double> getPastInfluences() {
        return pastInfluences;
    }

    public void setPastInfluences(Hashtable<Long, Double> pastInfluences) {
        this.pastInfluences = pastInfluences;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Node(int vertexNumber, Hashtable<Integer, Double> vertexNeighbors)
    {
        this.vertexNumber = vertexNumber;
        this.vertexNeighbors = vertexNeighbors;
    }

    public int getVertexNumber()
    {
        return vertexNumber;
    }
}
