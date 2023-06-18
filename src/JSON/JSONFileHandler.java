package JSON;

import Interfaces.Serializable;

import java.io.FileWriter;
import java.io.IOException;

public class JSONFileHandler {
    public static void saveToFile(String filename, Serializable serializable) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(serializable.toJSON());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}