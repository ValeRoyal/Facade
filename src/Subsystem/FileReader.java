
package Subsystem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    public String readFromFile(String filePath) {
        try {
            return Files.readString(Path.of(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo el archivo: " + filePath, e);
        }
    }
}
