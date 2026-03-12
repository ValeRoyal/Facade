
package Subsystem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Subsistema: Escribe contenido en un archivo de texto en el sistema de archivos.
 * <p>
 * Esta clase es un componente de bajo nivel del subsistema. Normalmente será usada
 * por la fachada para persistir contenido (por ejemplo, texto cifrado).
 * </p>
 *
 * <h2>Responsabilidad</h2>
 * <ul>
 *   <li>Escribir (sobrescribir) texto en un archivo dado un {@code filePath}.</li>
 * </ul>
 *
 * <h2>Notas</h2>
 * <ul>
 *   <li>No realiza cifrado/descifrado; eso corresponde a {@link FileEncryptor}.</li>
 * </ul>
 *
 * @author Valen Aguilar
 */

public class FileWriter {

    /**
     * Escribe contenido en un archivo de texto. Si el archivo no existe, se crea.
     * Si existe, se sobrescribe.
     *
     * @param filePath ruta del archivo (por ejemplo: {@code "test.txt"}).
     * @param content texto a escribir (UTF-8).
     * @throws java.io.IOException si ocurre un error de E/S.
     */
    public void writeToFile(String filePath, String content) {
        try {
            Files.writeString(Path.of(filePath), content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Error escribiendo el archivo: " + filePath, e);
        }
    }
}
