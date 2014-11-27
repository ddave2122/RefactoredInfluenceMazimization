import java.io.*;
import java.util.LinkedList;

public class DataImporter {

    public String[] importArrayFromFile(String fileName)
    {
        LinkedList<String> importedData = new LinkedList<>();

        try(FileInputStream fileInputStream = new FileInputStream(fileName))
        {
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String line;

            while((line = bufferedReader.readLine()) != null)
            {
                importedData.add(line);
            }

            return importedData.toArray(new String[importedData.size()]);
        }
        catch(IOException e) { System.out.println("IOException: " + e); }

        return null;
    }

}
