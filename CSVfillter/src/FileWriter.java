import java.io.*;
import java.util.*;
import java.text.DecimalFormat;


public class FileWriter {
    public void WriteStatisticInFile(List<Map.Entry<String, Integer>> pairs, int countWords, String path) {
        Writer writer = null;
        File output = new File(path + "output.csv");
        try {
            writer = new OutputStreamWriter(new FileOutputStream(output));
            
            for (var entry : pairs) {
                String key = entry.getKey();
                int value = entry.getValue();
                String freqString = new DecimalFormat("#0.00").format(((float)value / countWords) * 100);
                writer.write(key + "," + value + "," + freqString + "%" + "\n");
            }
        }
        catch (IOException e) {
            System.err.println("error while writing file: " + e.getLocalizedMessage());
        }
        finally {
            if (null != writer) {
                try {
                    writer.close();
                }
                catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}
