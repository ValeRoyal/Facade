
package Subsystem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter {

    public void writeToFile(String filePath, String content) {
        try {
            Files.writeString(Path.of(filePath), content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Error escribiendo el archivo: " + filePath, e);
        }
    }
}
