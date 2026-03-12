
package Subsystem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


/**
 * Subsistema: Lee el contenido completo de un archivo de texto desde el sistema de archivos.
 * <p>
 * Esta clase forma parte del subsistema del patrón Facade y expone una operación
 * de bajo nivel (lectura) que la fachada orquesta para simplificar el uso desde el cliente.
 * </p>
 *
 * <h2>Responsabilidad</h2>
 * <ul>
 *   <li>Leer el contenido de un archivo dado su {@code filePath}.</li>
 * </ul>
 *
 * <h2>Notas</h2>
 * <ul>
 *   <li>No realiza cifrado/descifrado; eso corresponde a {@link FileEncryptor}.</li>
 *   <li>La fachada (FileFacade) debe ser la encargada de coordinar esta clase con las demás.</li>
 * </ul>
 *
 * @author Valen Aguilar
 */

public class FileReader {

     /**
     * Lee el contenido de un archivo de texto y lo retorna como {@link String}.
     *
     * @param filePath ruta del archivo a leer (por ejemplo: {@code "test.txt"}).
     * @return contenido del archivo como texto (UTF-8).
     * @throws java.io.IOException si ocurre un error de E/S o el archivo no existe.
     */
    public String readFromFile(String filePath) {
        try {
            return Files.readString(Path.of(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo el archivo: " + filePath, e);
        }
    }
}
