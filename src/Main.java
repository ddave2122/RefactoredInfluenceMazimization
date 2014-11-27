public class Main {

    private static final String fileName = "data/sampleData.csv";
    private static final float marketPercent = 0.2f;

    public static void main(String[] args)
    {
        DataImporter dataImporter = new DataImporter();
        Util util = new Util();
        NodeProcessor nodeProcessor = new NodeProcessor();

        //Import the data
        String[] importedArray = dataImporter.importArrayFromFile(fileName);
        Node[] forest = util.convertStringArrayToNodeArray(importedArray);

        int numberOfSeeds = (int)(forest.length*marketPercent);

        //Find the seeds
        nodeProcessor.processNodes(forest, numberOfSeeds);

        //Start primary processing
    }

}
