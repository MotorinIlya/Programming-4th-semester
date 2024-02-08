import java.io.*;

public class FileReader {
    public String[] getWordsInFile(String nameFile, String path) {
        Reader reader = null;  
        StringBuilder builder = new StringBuilder(); 
        
        try {
            reader = new InputStreamReader(new FileInputStream(path + nameFile));
            
            while (reader.ready()) {
                builder.append((char)reader.read());               
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("file for read not found: " + e.getLocalizedMessage());
        }
        catch (IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
        finally {
            if (null != reader) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
        return builder.toString().split("[^\\w\\d]");
    }
}
